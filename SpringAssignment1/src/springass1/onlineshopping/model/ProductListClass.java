package springass1.onlineshopping.model;

import java.util.ArrayList;
import java.util.List;



public class ProductListClass 
{   
private	List<ProductDetailsClass> productlist =new ArrayList<ProductDetailsClass>();

//	public ProductListClass()
//	{
//		this.addProducts();
//	}
//	
	
	
	
//	private void addProducts() 
//	{
//		
//		productlist.add(new ProductDetailsClass("Shirt","42","Blue","2000","0","3"));
//		productlist.add(new ProductDetailsClass("Pants","32","Black","3500","0","4"));
//		productlist.add(new ProductDetailsClass("Saree","3 meters","Orange","10000","0","5"));
//	}
//


	public List<ProductDetailsClass> getProductlist() {
		return this.productlist = productlist;
	}
	public void setProductlist(List<ProductDetailsClass> productlist) {
		this.productlist = productlist;
	}

//	HashMap<String,ProductDetailsClass> h1 = new HashMap<String,ProductDetailsClass>();
//	ProductDetailsClass p1= new ProductDetailsClass();
//	public void add()
//	{
//		h1.put("p1.getProductname()", p1);
//	}
//	public HashMap<String, ProductDetailsClass> getList()
//	{
//		return h1;
//	}
//	
//	ProductDetailsClass p1 = new ProductDetailsClass();
//	String p2=p1.getProductname();
//	public void print()
//	{
//	System.out.println(p2);
//	}

}
