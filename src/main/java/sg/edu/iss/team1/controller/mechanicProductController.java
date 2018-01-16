package sg.edu.iss.team1.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sg.edu.iss.team1.model.Product;
import sg.edu.iss.team1.model.Transaction;
import sg.edu.iss.team1.repository.ProductRepository;
import sg.edu.iss.team1.service.ProductService;
import sg.edu.iss.team1.service.TransactionService;


@RequestMapping(value ="/mechanic/products")
@Controller
public class mechanicProductController {

	@Autowired
	private TransactionService tService;
	
	@Autowired
	private ProductService pservice;
	
	@Resource
	private ProductRepository prepo;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView productListPage() {
		ModelAndView mav = new ModelAndView("mechanicproduct-list");
		ArrayList<Product> productList = (ArrayList<Product>) pservice.findAllProduct();
		mav.addObject("productList", productList);
		return mav;
	}
	@RequestMapping(value = "/usagerecord/{partNumber}", method = RequestMethod.GET)
	public ModelAndView viewRecordUsage(@PathVariable String partNumber) {
		ModelAndView mav = new ModelAndView("product-usage-record");
		ArrayList<Transaction> p1 = tService.findTransactionByProduct(Integer.parseInt(partNumber));
		mav.addObject("p1", p1);
		return mav;
	} 
	
	@RequestMapping(value="/search", method = RequestMethod.GET)	
	 public ModelAndView showSearchListPage() {
		
		
		ModelAndView mav =new ModelAndView("product-search");
		return mav;
	}
	
	@RequestMapping(value="/search", method = RequestMethod.POST)	
	 public ModelAndView searchListPag(@ RequestParam ("searchtext") String searchtext,
			 @RequestParam("select") String select
			) {
		
		
		ModelAndView mav =new ModelAndView("product-search");
		
		
		ArrayList<Product> productList = pservice.searchProducts(select,searchtext);
		
		mav.addObject("productList",productList);
	
		return mav;
	}
	

}
