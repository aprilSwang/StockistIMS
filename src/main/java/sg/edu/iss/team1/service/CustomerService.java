package sg.edu.iss.team1.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import sg.edu.iss.team1.model.Customer;

public interface CustomerService {

	ArrayList<Customer> findAllCustomer();

	Customer findCustomer(int customerID);

	Customer createCustomer(Customer c);

	Customer changeCustomer(Customer c);

	void removeCustomer(Customer c);

	ArrayList<String> findAllCustomerNames();
}