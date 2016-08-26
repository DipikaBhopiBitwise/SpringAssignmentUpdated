package springass1.onlineshopping.controller;




	import java.util.ArrayList;
	import java.util.List;

	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.servlet.ModelAndView;

import springass1.onlineshopping.exceptions.OutOfStockException;
import springass1.onlineshopping.helper.CartOperationClass;
import springass1.onlineshopping.model.Product;
import springass1.onlineshopping.model.ProductDetailsClass;
import springass1.onlineshopping.model.ProductListClass;

	@Controller
	public class ProductControllerClass {
		@Autowired
		ProductListClass productList;
		//@Autowired
		CartOperationClass cart = new CartOperationClass();
		List<ProductDetailsClass> itemlist2 = new ArrayList<ProductDetailsClass>();
		List<ProductDetailsClass> listadded=new  ArrayList<ProductDetailsClass>();
		List<ProductDetailsClass> custList=new  ArrayList<ProductDetailsClass>();
		double cartprice=0;
		
		@RequestMapping(value = "/spring/Home", method = RequestMethod.GET)
		public ModelAndView init(ModelMap model) {
//			ProductListClass p1 = new ProductListClass();
			List<ProductDetailsClass> itemlist = productList.getProductlist();
			model.addAttribute("ItemList", itemlist);
			model.addAttribute("product", new Product());
			// model.addAttribute("ItemList", ProductListClass);

			return new ModelAndView("Home",model);

		}

		@RequestMapping(value="/spring/Selected", method = RequestMethod.POST)
		public ModelAndView submit(ModelMap model, @ModelAttribute("product") Product product,HttpServletRequest request,HttpServletResponse response) {
			//System.out.println("In POST");
			//List<String> selectedlist = product.getProductName();
//			for(String temp : product.getProductName()) {
//				System.out.println(temp);
//			}
			//ProductListClass p4 = new ProductListClass();
		//	ProductDetailsClass p5=new ProductDetailsClass();
			
			String[] p2=product.getProductName();
			List<ProductDetailsClass> itemlist1 = productList.getProductlist();
			//System.out.println(itemlist1);
			if(product.getStringLength()!=0)
			{for(ProductDetailsClass str : itemlist1)		
			{//System.out.println(p2.length);
			   for(int i=0;i<product.getStringLength();i++)
			      {     //System.out.println(p2[i]);
			     //System.out.println(itemlist1.get(i).getProductname());
				     if(p2[i].equals(str.getProductname()) && !itemlist2.contains(str))
				      {
					      itemlist2.add(str);
					//System.out.println(itemlist2);}
			        }
			      }
			}
			request.getSession(false).setAttribute("selected", itemlist2);
			model.addAttribute("selected", itemlist2);
			return new ModelAndView("Selected",model) ;}
			else 
				{
				throw new OutOfStockException("No items Selected");
				}

	}
		

	@RequestMapping( value="/spring/Add", method = RequestMethod.POST)
	public String Add(Model model, HttpServletRequest request,HttpServletResponse response,@ModelAttribute("product2") Product product1,@RequestParam("productadded")String prodadd) {
	      //System.out.println(prodadd);
	      List<ProductDetailsClass> itemlistsele = (List<ProductDetailsClass>) request.getSession(false).getAttribute("selected");
	  //    System.out.println("selected"+itemlistsele);
	     HttpSession session = request.getSession(false);
	     session.setAttribute("customerlist", custList);
	    List<ProductDetailsClass> customerList =(List<ProductDetailsClass>) session.getAttribute("customerlist");
	      cart.addtocart(prodadd,itemlistsele,customerList);
	      //System.out.println();
	      request.getSession(false).setAttribute("CustomerList", custList);
	      model.addAttribute("CustomerListm", custList);
	      model.addAttribute("selected", itemlistsele);
	      model.addAttribute("msg", "Item Added");
	     return "Selected";
	     
	}
	     @RequestMapping( value="/spring/View", method = RequestMethod.POST)
	     public String View(Model model, HttpServletRequest request,HttpServletResponse response,@ModelAttribute("product2") Product product1) {
	           //System.out.println(prodadd);
	           List<ProductDetailsClass> itemlistsele = (List<ProductDetailsClass>) request.getSession(false).getAttribute("selected");
	       //    System.out.println("selected"+itemlistsele);
	          HttpSession session = request.getSession(false);
	          session.setAttribute("customerlist", custList);
	          List<ProductDetailsClass> customerList1 =(List<ProductDetailsClass>) session.getAttribute("CustomerList");
	           request.getSession(false).setAttribute("CustomerList", customerList1);
	           model.addAttribute("CustomerListm", customerList1);
	           System.out.println(customerList1);
	          return "ViewCartList";
	}
	@RequestMapping( value="/spring/Remove", method = RequestMethod.POST)
	public String Remove(Model model, HttpServletRequest request,HttpServletResponse response,@ModelAttribute("product2") Product product1,@RequestParam("productremove")String prodremove) {
	      //System.out.println(prodadd);
	    //  List<ProductDetailsClass> itemlistsele = (List<ProductDetailsClass>) request.getSession(false).getAttribute("selected");
	  //    System.out.println("selected"+itemlistsele);
	     HttpSession session = request.getSession(false);
	   //  session.setAttribute("customerlist", custList);
	    List<ProductDetailsClass> customerList =(List<ProductDetailsClass>) session.getAttribute("CustomerList");
	      cart.removetocart(prodremove,customerList);
	      model.addAttribute("CustomerListm", customerList);
	      request.getSession(false).setAttribute("CustomerList", customerList);
	      //System.out.println();
	    //  model.addAttribute("CustomerList", custList);
	     // model.addAttribute("selected", itemlistsele);
	      model.addAttribute("msg", "Item Removed");
	     return "ViewCartList";
	     }
	@RequestMapping( value="/spring/AddMore", method = RequestMethod.POST)
	public String AddMore(Model model, HttpServletRequest request,HttpSession session,HttpServletResponse response) {
	     
		
		List<ProductDetailsClass> customerList =(List<ProductDetailsClass>) session.getAttribute("selected");
		
		if(customerList==null)
		{ return "redirect:/spring/Home";}
		else{customerList.clear();
		model.addAttribute("selected",customerList);}
//		for(ProductDetailsClass str : customerList)
//		{
//			customerList.remove(str);
//		}

		

	     return "redirect:/spring/Home";
	     }
	@RequestMapping( value="/spring/PlaceOrder", method = RequestMethod.POST)
	public String PlaceOrder(Model model, HttpServletRequest request,HttpSession session,HttpServletResponse response) {
	     
		List<ProductDetailsClass> cartlist =(List<ProductDetailsClass>) session.getAttribute("CustomerList");
		if(cartlist.size()!=0)
		{ 
			for(ProductDetailsClass str : cartlist)
		      {
			    cartprice+=(str.getProductquantity()*str.getProductprice());
		       }
		}
		else throw new OutOfStockException("No items in your Cart");
		
		model.addAttribute("CartList", cartlist);
		System.out.println(cartlist);
		model.addAttribute("Cartprice",cartprice);
		//cartlist.clear();
		
		
	     return "PlaceOrder";
	     }
	@ExceptionHandler(OutOfStockException.class)
	public ModelAndView handleCustomException(OutOfStockException except) {

	      return new ModelAndView("ExceptionPage", "Msg", except.getMessage());

	}
	@RequestMapping( value="/spring/CartListEmpty", method = RequestMethod.POST)
	public String Empty(Model model, HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		
		List<ProductDetailsClass> customerList =(List<ProductDetailsClass>) session.getAttribute("selected");
		customerList.clear();
		model.addAttribute("selected",customerList);
		
		List<ProductDetailsClass> cartlist =(List<ProductDetailsClass>) session.getAttribute("CustomerList");
		for(ProductDetailsClass p : cartlist){
			p.setProductquantity(0);
		}
		cartprice=0;
		session.setAttribute("cartprice", cartprice);		
		cartlist.clear();
		model.addAttribute("CustomerListm", cartlist);

		return "redirect:/spring/Home";
	}
	}


