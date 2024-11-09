package prj.shop.service;

import org.springframework.stereotype.Service;

import prj.shop.model.SaleOrderProduct;



@Service
public class SaleOrderProductService extends BaseService<SaleOrderProduct> {

	@Override
	public Class<SaleOrderProduct> clazz() {
		// TODO Auto-generated method stub
		return SaleOrderProduct.class;
	}
}
