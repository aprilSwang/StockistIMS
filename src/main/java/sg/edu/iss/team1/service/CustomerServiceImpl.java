package sg.edu.iss.team1.service;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;


import sg.edu.iss.team1.model.Customer;
import sg.edu.iss.team1.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Resource
	CustomerRepository crepo;
	
	/* (non-Javadoc)
	 * @see sg.edu.iss.team1test.service.TransactionService#findAllTransaction()
	 */
	@Override
	@Transactional
	public ArrayList<Customer> findAllCustomer() {
		ArrayList<Customer> l = (ArrayList<Customer>) crepo.findAll();
		return l;
	}
	
	/* (non-Javadoc)
	 * @see sg.edu.iss.team1test.service.TransactionService#findTransaction(int)
	 */
	@Override
	@Transactional
	public Customer findCustomer(int customerID) {
		return crepo.findOne(customerID);
	}

	/* (non-Javadoc)
	 * @see sg.edu.iss.team1test.service.TransactionService#createTransaction(sg.edu.iss.team1test.model.Transaction)
	 */
	@Override
	@Transactional
	public Customer createCustomer(Customer c) {
		return crepo.saveAndFlush(c);
	}
	
	/* (non-Javadoc)
	 * @see sg.edu.iss.team1test.service.TransactionService#changeTransaction(sg.edu.iss.team1test.model.Transaction)
	 */
	@Override
	@Transactional
	public Customer changeCustomer(Customer c) {
		return crepo.saveAndFlush(c);
	}
	
	/* (non-Javadoc)
	 * @see sg.edu.iss.team1test.service.TransactionService#removeTransaction(sg.edu.iss.team1test.model.Transaction)
	 */
	@Override
	@Transactional
	public void removeCustomer(Customer c) {
		crepo.delete(c);
	}
	
	@Override
	@Transactional
	public ArrayList<String> findAllCustomerNames() {
		return crepo.findAllCustomerNames();
	}
}
