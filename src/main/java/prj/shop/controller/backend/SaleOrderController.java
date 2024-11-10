package prj.shop.controller.backend;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import prj.shop.controller.BaseController;
import prj.shop.dto.Constants;
import prj.shop.model.Category;
import prj.shop.model.Product;
import prj.shop.model.SaleOrder;
import prj.shop.service.SaleOrderService;

@Controller
public class SaleOrderController extends BaseController implements Constants  {
	@Autowired
	private SaleOrderService saleOrderService;
	
	@RequestMapping(value = "/admin/order/list", method = RequestMethod.GET)
	public String orderList(final Model model) {
		BigDecimal totalSales = BigDecimal.ZERO;
		List<SaleOrder> saleOrders = saleOrderService.findAll(); 
		for(SaleOrder saleOrder : saleOrders) {
			totalSales = totalSales.add(saleOrder.getTotal());
		}
		model.addAttribute("totalSales", totalSales);
		model.addAttribute("saleOrders", saleOrders);
		return "backend/order-list";
	}
	@RequestMapping(value = "delete/{saleOrderId}", method = RequestMethod.GET)
	public String deleteProduct(final Model model, @PathVariable("saleOrderId") int saleOrderId) throws IOException {

		
		SaleOrder saleOrder = saleOrderService.getById(saleOrderId);
		saleOrderService.delete(saleOrder);

		return "redirect:/admin/order/list";
	}
	
	@RequestMapping(value = "edit/{saleOrderId}", method = RequestMethod.POST)
	public String editProduct(final Model model, @PathVariable("saleOrderId") int saleOrderId) throws IOException{
		SaleOrder saleOrder = saleOrderService.getById(saleOrderId);
		 saleOrder.setStatus(true); 
	     saleOrderService.saveOrUpdate(saleOrder);
		return "redirect:/admin/order/list";
	}
	
}
