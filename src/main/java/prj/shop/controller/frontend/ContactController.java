package prj.shop.controller.frontend;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;





@Controller
public class ContactController {
	@RequestMapping(value="/contact/view", method = RequestMethod.GET)
	public String contactView() {
		return "frontend/contact/contact";
	}
	
	@RequestMapping(value="/contact/send", method = RequestMethod.POST)
	public String send(final HttpServletRequest request ) {
//		String name = request.getParameter("txtName");
//		String email = request.getParameter("txtEmail");
//		

//		Contact contact = new Contact(request.getParameter("txtName"),
//				request.getParameter("txtEmail"),
//				request.getParameter("txtMobile"),
//				request.getParameter("txtAddress"),
//				request.getParameter("txtMessage"));
//			System.out.println("Your name: "+ contact.getName());
//		    System.out.println("Your email: "+ contact.getEmail());
//		    System.out.println("Your mobile: "+ contact.getMobile());
//		    System.out.println("Your address: "+ contact.getAddress());
//		    System.out.println("Your message: " +contact.getMessage());
		
		return "frontend/contact/contact";
	}
	
}
