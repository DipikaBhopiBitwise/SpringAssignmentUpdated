package springass1.onlineshopping.helper;

import java.util.Iterator;
import java.util.List;

import springass1.onlineshopping.exceptions.OutOfStockException;
import springass1.onlineshopping.model.ProductDetailsClass;

public class CartOperationClass {

//	List<ProductDetailsClass> custList = new ArrayList<>();
	public boolean checkproductaddedisthereinthelist(String prodadd,ProductDetailsClass str) 
	{ if(prodadd.equals(str.getProductname()))
	{
		return true;
	}

	return false;
	}

	public List<ProductDetailsClass> addtocart(String prodadd, List<ProductDetailsClass> itemlist,List<ProductDetailsClass> custList) {
		for(ProductDetailsClass p : itemlist){
			
			if(p.getProductname().equals(prodadd)){
				
				{  if(custList.contains(p))
						  
				    { // System.out.println("outer if custlist");
						  ProductDetailsClass pr = custList.get(custList.indexOf(p));
					if (p.getProductstock()>0)
					{// System.out.println("inner if custlist");
				      custList.get(custList.indexOf(p)).setProductquantity(pr.getProductquantity()+1);
					p.setProductstock(p.getProductstock()-1);
					//System.out.println(itemlist);
					}
					else
					{System.out.println("Throw");
						throw new OutOfStockException("Product out of stock");
						
					}
				   
				}
				else{
					//System.out.println("outer else custlist");
					custList.add(p);
					ProductDetailsClass pr2 = custList.get(custList.indexOf(p));
				    custList.get(custList.indexOf(p)).setProductquantity(pr2.getProductquantity()+1);
				    
				    p.setProductstock(p.getProductstock()-1);
				    System.out.println("Stock");
				}}

			}}
		//else throw
		return itemlist;
		}

	public void removetocart(String prodremove, List<ProductDetailsClass> customerList) {
     Iterator<ProductDetailsClass> it = customerList.iterator();
     
     while(it.hasNext()){
    	 ProductDetailsClass p = it.next();
    	 if(p.getProductname().equals(prodremove))
			{ if(p.getProductquantity()==1){
				
				p.setProductquantity(0);
				p.setProductstock(p.getProductstock()+1);
				customerList.remove(p);
				break;
				}
			else
			{
				p.setProductquantity(p.getProductquantity()-1);
				p.setProductstock(p.getProductstock()+1);
			}
    	 
     }
//		for(ProductDetailsClass p : customerList){
//			
//			if(p.getProductname().equals(prodremove))
//			{ if(p.productquantity==1){
//				
//				p.setProductquantity(0);
//				p.setProductstock(p.getProductstock()+1);
//				customerList.remove(p);
//				}
//			else
//			{
//				p.setProductquantity(p.getProductquantity()-1);
//				p.setProductstock(p.getProductstock()+1);
//			}
//			}

	} 
	
 //System.out.println(custList);

	}
}

	//	public boolean checkstockavailableandquantityneeded(List<ProductDetailsClass> listadded, ProductDetailsClass str) {
	//		Boolean b=true;
	//		for(ProductDetailsClass str2 : listadded)
	//		{    int st1=  Integer.parseInt(str.getProductstock()); 
	//		     int st2=  Integer.parseInt(str2.getProductquantity()); 
	//			if(st1>=st2&& st1!=0)
	//			{
	//				b= true;}
	//			
	//			else b=false;
	//		}
	//		return b;
	//	}


