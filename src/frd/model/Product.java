package frd.model;

import java.util.List;

public class Product {
	private int id;
	private String productname;
	private String productdescription;
	private List<Lot> productlots;
	
	public Product(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductdescription() {
		return productdescription;
	}

	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}

	public List<Lot> getProductlots() {
		return productlots;
	}

	public void setProductlots(List<Lot> productlots) {
		this.productlots = productlots;
	}
	
}
