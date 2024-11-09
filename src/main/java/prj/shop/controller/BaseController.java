package prj.shop.controller;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;





public class BaseController {

	@ModelAttribute("title")
	public String projectTitle() {
		return  "Aviato Fashion Shop";
	}
//	@ModelAttribute("totalCartProducts")
//	public BigInteger getTotalCartProducts(final HttpServletRequest request) {
//
//		HttpSession session = request.getSession();
//		if (session.getAttribute("cart") == null) {// Khong co gio hang
//			return BigInteger.ZERO;
//		} else {
//			Cart cart = (Cart) session.getAttribute("cart");
//			return cart.totalCartProduct();
//		}
//	}

	
		
			
}
