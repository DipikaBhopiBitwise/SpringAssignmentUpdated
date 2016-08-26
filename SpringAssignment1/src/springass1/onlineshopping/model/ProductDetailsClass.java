package springass1.onlineshopping.model;

import java.io.Serializable;

public class ProductDetailsClass implements Serializable{

	 String productname;
	String productsize;
	String productcolor;
	int productquantity,productstock;
	double productprice;
	
	
	public int getProductstock() {
		return productstock;
	}



	public void setProductstock(int productstock) {
		this.productstock = productstock;
	}



	public  ProductDetailsClass(String productname,String productsize,String productcolor,double productprice,int productquantity,int productstock)
	  {
		this.productname=productname;
	    this.productsize=productsize;
	    this.productcolor=productcolor;
	    this.productquantity=productquantity;
	    this.productprice=productprice;
	    this.productstock=productstock;
      }



	public ProductDetailsClass() {
		
		// TODO Auto-generated constructor stub
	}

	public String getProductname() {
		return productname;
	}

	

	@Override
	public String toString() {
		return "ProductDetailsClass [productname=" + productname + ", productsize=" + productsize + ", productcolor="
				+ productcolor + ", productquantity=" + productquantity + ", productprice=" + productprice
				+ ", productstock=" + productstock + "]";
	}



	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductsize() {
		return productsize;
	}

	public void setProductsize(String productsize) {
		this.productsize = productsize;
	}

	public String getProductcolor() {
		return productcolor;
	}

	public void setProductcolor(String productcolor) {
		this.productcolor = productcolor;
	}

	public int getProductquantity() {
		return productquantity;
	}

	public void setProductquantity(int productquantity) {
		this.productquantity = productquantity;
	}

	public double getProductprice() {
		return productprice;
	}

	public void setProductprice(double productprice) {
		this.productprice = productprice;
	}
	
}
