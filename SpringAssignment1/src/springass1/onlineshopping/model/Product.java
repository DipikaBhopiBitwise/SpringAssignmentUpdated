package springass1.onlineshopping.model;

public class Product {
	private String [] productName;
	/*private ArrayList<String> productName;
	private boolean _productName;

	public boolean is_productName() {
		return _productName;
	}

	public void set_productName(boolean _productName) {
		this._productName = _productName;
	}

	public ArrayList<String> getProductName() {
		return productName;
	}

	public void setProductName(ArrayList<String> productName) {
		this.productName = productName;
	}*/

	public String[] getProductName() {
		return productName;
	}
	public int getStringLength()
	{ int x=productName.length;
		return x;
	}

	public void setProductName(String[] productName) {
		this.productName = productName;
	}

	
	
}
