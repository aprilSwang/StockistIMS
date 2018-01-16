package sg.edu.iss.team1.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import sg.edu.iss.team1.model.Product;

public interface ProductService {

	ArrayList<Product> findAllProduct();

	Product findProduct(int partNumber);

	Product createProduct(Product p);

	Product changeProduct(Product p);

	void removeProduct(Product p);

	ArrayList<String> findAllPartNumbers();
	
	ArrayList<Product> lowQty();
	
	ArrayList<String> suppliersLowQty();
	
	ArrayList<Product> searchProducts(String select , String searchtext);
}