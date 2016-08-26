package springass1.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springass1.onlineshopping.model.ProductDetailsClass;
import springass1.onlineshopping.model.ProductListClass;
import springass1.onlineshopping.model.UserDetailsClass;
import springass1.onlineshopping.validator.LoginValidatorClass;
@Controller


public class LoginControllerClass {
	@Autowired
	UserDetailsClass user;
	    
	    @RequestMapping(value = "/Login", method = RequestMethod.GET)
	    public String init(Model model) {
	        model.addAttribute("msg", "Please Enter Your Login Details");
	        model.addAttribute("User", user);
	        return "Login";
	        
	    }
	 
	    @RequestMapping(value="/Login", method = RequestMethod.POST)
	    public String submit(Model model, @ModelAttribute("User") UserDetailsClass user,BindingResult result,HttpServletRequest request,HttpServletResponse response,HttpSession session)
	    {
//	       System.out.println("submit.....");
	    	LoginValidatorClass val = new LoginValidatorClass();
	    	
	    	val.validate(user,result);
	    	if(result.hasErrors())
	    	{
	    		// model.addAttribute("error", "Please enter Details");
	                return "Login";
	    	}
            if (user.authenticate(user.getUsername(), user.getPassword())) 
            {
	              model.addAttribute("msg", "Welcome  " + user.getUsername());
	              model.addAttribute("ProductList", new ProductListClass());
	              session=request.getSession(true);
	              
	               return "redirect:/spring/Home";
	        }
            else
	        {
	              model.addAttribute("error", "Invalid Details");
	              return "Login";
	        }
	        

	    }
	    @RequestMapping(value = "/spring/Logout", method = RequestMethod.POST)
	    public String Logout(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
    	List<ProductDetailsClass> customerList =(List<ProductDetailsClass>) session.getAttribute("selected");
	    if(customerList==null)
	    {
	    	return"redirect:/Login";
	    }
	    else{customerList.clear();
	    	model.addAttribute("selected",customerList);
	    
//	    	List<ProductDetailsClass> cartlist =(List<ProductDetailsClass>) session.getAttribute("CustomerList");
//	    	for(ProductDetailsClass p : cartlist){
//	    		p.setProductquantity(0);
//	    	}
//
////	    	cartprice=0;	    	double cartprice=(double) session.getAttribute("cartprice");		
//	    	cartlist.clear();
//	    	model.addAttribute("CustomerListm", cartlist);
	    	
	    	
	    	
	    	
	    	//session=request.getSession();
	       session .invalidate();
	        return "redirect:/Login";}
	        
	    }


}
