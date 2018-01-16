package sg.edu.iss.team1.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.team1.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	@Query("SELECT DISTINCT p.partNumber FROM Product p")
	ArrayList<String> findAllPartNumbers();
	
	@Query("SELECT p from Product p where p.quantity<p.minReorderQnty")
	ArrayList<Product> lowQty();
	
	@Query("SELECT Distinct p.supplierName from Product p where p.quantity<p.minReorderQnty")
	ArrayList<String> suppliersLowQty();
	
	@Query("SELECT p FROM Product p WHERE p.color like %:color%")
	ArrayList<Product> findProductByColor(@Param("color")  String color);
	
	@Query("select p from Product p where p.description like %:des%")
	ArrayList<Product> findProductByDescription(@Param("des")  String description);

	@Query("select p from Product p where p.manufacturer like %:manu%")
	ArrayList<Product> findProductByManufacturer(@Param("manu")  String manufacturer);
	

}
