package sg.edu.iss.team1.service;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;


import sg.edu.iss.team1.model.Product;
import sg.edu.iss.team1.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Resource
	ProductRepository prepo;
	
	/* (non-Javadoc)
	 * @see sg.edu.iss.team1test.service.TransactionService#findAllTransaction()
	 */
	@Override
	@Transactional
	public ArrayList<Product> findAllProduct() {
		ArrayList<Product> l = (ArrayList<Product>) prepo.findAll();
		return l;
	}
	
	/* (non-Javadoc)
	 * @see sg.edu.iss.team1test.service.TransactionService#findTransaction(int)
	 */
	@Override
	@Transactional
	public Product findProduct(int partNumber) {
		return prepo.findOne(partNumber);
	}

	/* (non-Javadoc)
	 * @see sg.edu.iss.team1test.service.TransactionService#createTransaction(sg.edu.iss.team1test.model.Transaction)
	 */
	@Override
	@Transactional
	public Product createProduct(Product p) {
		return prepo.saveAndFlush(p);
	}
	
	/* (non-Javadoc)
	 * @see sg.edu.iss.team1test.service.TransactionService#changeTransaction(sg.edu.iss.team1test.model.Transaction)
	 */
	@Override
	@Transactional
	public Product changeProduct(Product p) {
		return prepo.saveAndFlush(p);
	}
	
	/* (non-Javadoc)
	 * @see sg.edu.iss.team1test.service.TransactionService#removeTransaction(sg.edu.iss.team1test.model.Transaction)
	 */
	@Override
	@Transactional
	public void removeProduct(Product p) {
		prepo.delete(p);
	}
	
	@Override
	@Transactional
	public ArrayList<String> findAllPartNumbers() {
		return prepo.findAllPartNumbers();
	}
	
	@Override
	public ArrayList<Product> lowQty() {
		return prepo.lowQty();
	}
	
	@Override
	public ArrayList<String> suppliersLowQty(){
		return prepo.suppliersLowQty();
	}

	@Override
	@Transactional
	public ArrayList<Product> searchProducts(String select , String searchtext)
	{
		ArrayList<Product> al = new ArrayList<>();
		
		switch (select) {
		case "partNumber": 
			Product p = prepo.findOne(Integer.parseInt(searchtext));
			al.add(p);	
			break;
			
		case "description": 
			al = prepo.findProductByDescription(searchtext);
			break;
			
		case "color": 
			al = prepo.findProductByColor(searchtext);
			break;
			
		case "manufacturer": 
			al = prepo.findProductByManufacturer(searchtext);
			break;
			
		default:
			break;
		}
		
		return al;
		
	}

}
