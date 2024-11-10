package prj.shop.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;





@Entity
@Table(name = "tbl_product")
public class Product extends BaseModel {

	@Column(name ="name", length = 300 , nullable = false)
	private String name;
	
	@Column(name = "avatar" , length= 300, nullable = true)
	private String avatar;
	
	@Column(name = "price",  nullable = true)
	private BigDecimal price;

	@Column(name = "sale_price",  nullable = true)
	private BigDecimal salePrice;
	
	@Column(name = "short_description", length= 500 , nullable = true )
	private String shortDescription;

	@Column(name = "detail_description", nullable = true )
	private String detailDescription;
	
	@Column(name =" is_hot" , nullable = true)
	private Boolean isHot= Boolean.FALSE;
	
	@Column(name  = "seo", length = 1000, nullable =true)
	private String seo;
	
	//-------------Mapping many to one : product-to-category--------------------//
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private Category category;

	//----------------Mapping one-to-many : tbl_product- to - tbl_product_image--------------//
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	private Set<ProductImage> productImages = new HashSet<ProductImage>();
	
	//Methods add and remove elements in relational productimage list
	
	public void addRelationalProductImage(ProductImage productImage) {
		productImages.add(productImage);
		productImage.setProduct(this);
	}
	
	public void removeRelationalProductImage(ProductImage productImage) {
		productImages.remove(productImage);
		productImage.setProduct(null);
	}
	//----------------Mapping one-to-many : tbl_product- to - tbl_sale_order_product--------------//
		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
		private Set<SaleOrderProduct> saleOrderProducts= new HashSet<SaleOrderProduct>();
		
		//Methods add and remove elements in relational productimage list
		
		public void addRelationalSaleOrderProduct(SaleOrderProduct saleOrderProduct) {
			saleOrderProducts.add(saleOrderProduct);
			saleOrderProduct.setProduct(this);
		}
		
		public void removeRelationalSaleOrderProduct(SaleOrderProduct saleOrderProduct) {
			saleOrderProducts.remove(saleOrderProduct);
			saleOrderProduct.setProduct(null);
		}
		
		// -------------Mapping many to one : user-to-product--------------------//
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "create_by")
		private User userCreateProduct;
		// -------------Mapping many to one : user-to-product--------------------//
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "update_by")
		private User userUpdateProduct;
	
	public Product() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDetailDescription() {
		return detailDescription;
	}

	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}

	public Boolean getIsHot() {
		return isHot;
	}

	public void setIsHot(Boolean isHot) {
		this.isHot = isHot;
	}

	public String getSeo() {
		return seo;
	}

	public void setSeo(String seo) {
		this.seo = seo;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUserCreateProduct() {
		return userCreateProduct;
	}

	public void setUserCreateProduct(User userCreateProduct) {
		this.userCreateProduct = userCreateProduct;
	}

	public User getUserUpdateProduct() {
		return userUpdateProduct;
	}

	public void setUserUpdateProduct(User userUpdateProduct) {
		this.userUpdateProduct = userUpdateProduct;
	}
	

}
