package sg.edu.iss.team1.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sg.edu.iss.team1.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	@Query("SELECT DISTINCT c.customerName FROM Customer c")
	ArrayList<String> findAllCustomerNames();
	
}
