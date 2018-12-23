package javaapplication1.models;

import java.util.ArrayList;
import java.util.List;

public class Kid extends Being{

	private List<Product> products;

	public Kid(String name){
		super(name);
		List<Product> products = new ArrayList<Product>();
	}


	public void addProducts(Product product){
		products.add(product);
		System.out.println("The product has been added.");
	}

	public List<Product> getProducts(){
		return products;
	}

}
