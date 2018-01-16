package sg.edu.iss.team1.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.edu.iss.team1.model.Product;
import sg.edu.iss.team1.model.Transaction;
import sg.edu.iss.team1.repository.ProductRepository;
import sg.edu.iss.team1.service.ProductService;
import sg.edu.iss.team1.service.TransactionService;
import sg.edu.iss.team1.validator.ProductValidator;

@RequestMapping(value ="/admin/products")
@Controller
public class adminProductController {
	
	@Autowired
	private ProductService pservice;
	
	@Autowired
	private TransactionService tService;
	
	@Autowired
	private ProductValidator pValidator;
	
	@Resource
	private ProductRepository prepo;
	
	@InitBinder("product")
	private void initProductBinder(WebDataBinder binder) {
		binder.addValidators(pValidator);
	}
	
	

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView productListPage() {
		ModelAndView mav = new ModelAndView("adminproduct-list");
		ArrayList<Product> productList = (ArrayList<Product>) pservice.findAllProduct();
		mav.addObject("productList", productList);
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newProductPage() {
		Product p = new Product();
		ModelAndView mav = new ModelAndView("product-new", "product", p);
		return mav;
	}
	@RequestMapping(value = "/create",method=RequestMethod.POST)
	public ModelAndView newProductPage(@ModelAttribute @Valid Product product,BindingResult result,final RedirectAttributes redirectAttributes)
	{
		if(result.hasErrors()) {
			return new ModelAndView("product-new");
		}
		ModelAndView mav = new ModelAndView();
		String message = "New Product" + product.getPartNumber() + "was successfully created";
		
		pservice.createProduct(product);
		
		mav.setViewName("redirect:/admin/products/list");
		redirectAttributes.addFlashAttribute("message",message);
		return mav;
	}
	
	@RequestMapping(value = "/edit/{partNumber}", method = RequestMethod.GET)
	public ModelAndView editProductPage(@PathVariable String partNumber) 
	{
		ModelAndView mav = new ModelAndView("product-edit");
		Product product = pservice.findProduct(Integer.parseInt(partNumber));
		mav.addObject("product",product);
		return mav;
	}
	
	@RequestMapping(value = "/edit/{partNumber}", method = RequestMethod.POST)
	public ModelAndView editProductPage(@ModelAttribute Product product,BindingResult result,@PathVariable String partNumber,final RedirectAttributes redirectAttributes)
	{
		if(result.hasErrors()) {
			return new ModelAndView("product-edit");
		}		
		ModelAndView mav = new ModelAndView("redirect:/admin/products/list");
		pservice.changeProduct(product);
        String message="Product is successfully updated!";
        redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	
	@RequestMapping(value = "/delete/{partNumber}", method = RequestMethod.GET)
	public ModelAndView deleteProduct(@PathVariable String partNumber, final RedirectAttributes redirectAttributes)
	{

		ModelAndView mav = new ModelAndView("redirect:/admin/products/list");
		Product product = pservice.findProduct(Integer.parseInt(partNumber));
		pservice.removeProduct(product);
		return mav;
	}
	
	
	@RequestMapping(value = "/detail/{partNumber}", method = RequestMethod.GET)
	public ModelAndView showProductDetailPage(@PathVariable String partNumber) 
	{
		ModelAndView mav = new ModelAndView("product-detail");
		Product product = pservice.findProduct(Integer.parseInt(partNumber));
		mav.addObject("product",product);
		return mav;
	}
	
//	@RequestMapping(value = "/reorder", method = RequestMethod.GET)
//	public ModelAndView reorderListPage() {
//		ModelAndView mav = new ModelAndView("reorder-list");
//		ArrayList<Product> pList = pservice.lowQty();
//		mav.addObject("reorderList", pList);
//		return mav;	
//		
//	}
	
	@RequestMapping(value = "/reorder", method = RequestMethod.GET)
	public ModelAndView reorderListPage() {
		ModelAndView mav = new ModelAndView("reorder-list");

		int nItems = pservice.lowQty().size();
		ArrayList<Product> pList = pservice.lowQty();

		int nSuppliers = pservice.suppliersLowQty().size();
		ArrayList<String> sList = pservice.suppliersLowQty();

		ArrayList<ArrayList<Product>> x = new ArrayList<ArrayList<Product>>(nSuppliers);

		for (int i = 0; i < nSuppliers; i++) {
			ArrayList<Product> p1List = new ArrayList<Product>();
			for (int j = 0; j < nItems; j++) {
				if (pList.get(j).getSupplierName().equals(sList.get(i))) {
					p1List.add(pList.get(j));
				}
			}
			x.add(p1List);
		}
		mav.addObject("reorderList", x);
		mav.addObject("supplierList", sList);
		return mav;
	}
	@RequestMapping(value = "/usagerecord/{partNumber}", method = RequestMethod.GET)
	public ModelAndView viewRecordUsage(@PathVariable String partNumber) {
		ModelAndView mav = new ModelAndView("product-usage-record");
		ArrayList<Transaction> p1 = tService.findTransactionByProduct(Integer.parseInt(partNumber));
		mav.addObject("p1", p1);
		return mav;
	} 
}
