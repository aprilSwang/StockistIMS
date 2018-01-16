package sg.edu.iss.team1.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sg.edu.iss.team1.model.Product;
import sg.edu.iss.team1.model.Transaction;
import sg.edu.iss.team1.service.CustomerService;
import sg.edu.iss.team1.service.ProductService;
import sg.edu.iss.team1.service.TransactionService;
import sg.edu.iss.team1.validator.TransactionValidator;

@Controller
@RequestMapping(value = "/admin/transaction")
public class AdminTransactionController {

	@Autowired
	TransactionService tservice;

	@Autowired
	ProductService pservice;

	@Autowired
	CustomerService cservice;

	@Autowired
	private TransactionValidator tValidator;

	@InitBinder("transaction")
	private void initCourseBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		binder.addValidators(tValidator);
	}
	
	@ModelAttribute("tid")
	public int tid() {
		return (int) tservice.count()+1;
	}
	
	@ModelAttribute("pnumlist")
	public ArrayList<String> pnumlist(){
		return (ArrayList<String>) pservice.findAllPartNumbers();
	}
	
	@ModelAttribute("cnamelist")
	public ArrayList<String> cnamelist(){
		return (ArrayList<String>) cservice.findAllCustomerNames();
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView transactionListPage() {
		ModelAndView mav = new ModelAndView("transaction-list");
		ArrayList<Transaction> transactionList = (ArrayList<Transaction>) tservice.findAllTransaction();
		mav.addObject("transactionList", transactionList);
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newStudentPage() {
		// Transaction t = new Transaction();

		ModelAndView mav = new ModelAndView("transaction-new");
		// addition
		int tid = (int) tservice.count() + 1;
		mav.addObject("tid", tid);

		ArrayList<String> pnumlist = (ArrayList<String>) pservice.findAllPartNumbers();
		mav.addObject("pnumlist", pnumlist);
		ArrayList<String> cnamelist = (ArrayList<String>) cservice.findAllCustomerNames();
		mav.addObject("cnamelist", cnamelist);
		mav.addObject("transaction", new Transaction());
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewStudent(@ModelAttribute @Valid Transaction transaction, BindingResult result, final RedirectAttributes redirectAttributes, HttpSession session) {

		if (result.hasErrors())
			return new ModelAndView("transaction-new");

		ModelAndView mav = new ModelAndView();

		String message = "New Transaction" + transaction.getTransactionID() + " was successfully created.";

		tservice.createTransaction(transaction);
		Product p = new Product();
		p = pservice.findProduct(transaction.getPartNumber());
		p.setQuantity(p.getQuantity() - transaction.getQuantity());
		pservice.changeProduct(p);
		redirectAttributes.addFlashAttribute("message", message);
		mav.setViewName("redirect:/admin/transaction/list");

		return mav;
	}
}