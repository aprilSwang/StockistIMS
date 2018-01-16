
package sg.edu.iss.team1.controller;

import java.util.ArrayList;

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

import sg.edu.iss.team1.exception.UserNotFound;
import sg.edu.iss.team1.model.Supplier;
import sg.edu.iss.team1.repository.SupplierRepository;
import sg.edu.iss.team1.service.SupplierService;
import sg.edu.iss.team1.validator.SupplierValidator;


@RequestMapping(value = "/administrator/supplier")
@Controller

public class AdminSupplierController  {
   
	@Autowired
	SupplierService sservice;
	
	@Autowired
	private SupplierValidator sValidator;

	@InitBinder("supplier")
	private void initUserBinder(WebDataBinder binder) {
		binder.addValidators(sValidator);
	}	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView supplierListPage() {
		ModelAndView mav = new ModelAndView("supplier-list");
		ArrayList<Supplier> supplierList = (ArrayList<Supplier>) sservice.findallSupplier();
		mav.addObject("supplierList", supplierList);
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newSupplierPage() {
		Supplier u = new Supplier();
		ModelAndView mav = new ModelAndView("supplier-new", "supplier", u);
		//mav.addObject("supplier", sservice.createSupplier(u));
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewSupplier(@ModelAttribute  @Valid Supplier supplier, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		
		if (result.hasErrors()) {
			return new ModelAndView("supplier-new");
		}

		ModelAndView mav = new ModelAndView();
		String message = "New Supplier" + supplier.getSupplierID() + "was successfully created.";

		sservice.createSupplier(supplier);
		mav.setViewName("redirect:/administrator/supplier/list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;

	}
	@RequestMapping(value = "/edit/{supplierID}", method = RequestMethod.GET)
	public ModelAndView editSupplierPage(@PathVariable String supplierID) {
		ModelAndView mav = new ModelAndView("supplier-edit");
		int supplierIDD=Integer.parseInt(supplierID);
		Supplier supplier=sservice.findSupplier(supplierIDD);
		mav.addObject("supplier", supplier);
		return mav;
	}

	@RequestMapping(value = "/edit/{supplierID}", method = RequestMethod.POST)
	public ModelAndView editSupplierPage(@ModelAttribute @Valid Supplier supplier, BindingResult result,
			@PathVariable String supplierID,final RedirectAttributes redirectAttributes)  {
		// if (result.hasErrors())
		// return new ModelAndView("new-product");

		ModelAndView mav = new ModelAndView("redirect:/administrator/supplier/list");
		sservice.changeSupplier(supplier);
		String message = "Supplier list was successfully updated.";
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value = "/delete/{supplierID}", method = RequestMethod.GET)
	public ModelAndView deleteSupplierPage(@PathVariable String supplierID, 
			final RedirectAttributes redirectAttributes) throws UserNotFound{

		ModelAndView mav = new ModelAndView("redirect:/administrator/supplier/list");
		int ssuplierID=Integer.parseInt(supplierID);
		Supplier supplier=sservice.findSupplier(ssuplierID);
		sservice.removeSupplier(supplier);
		String message = "Supplier was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	
}