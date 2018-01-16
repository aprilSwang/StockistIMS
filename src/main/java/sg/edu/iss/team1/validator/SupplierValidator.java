package sg.edu.iss.team1.validator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.edu.iss.team1.model.Supplier;
import sg.edu.iss.team1.service.SupplierService;



@Component
public class SupplierValidator implements Validator {

	@Autowired
	SupplierService sservice;
	@Override
	public boolean supports(Class<?> team) {
		return Supplier.class.isAssignableFrom(team);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		Supplier supplier = (Supplier) arg0;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "supplierName", "error.supplier.supplierName.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "email", "error.supplier.email.empty");
		
	
		System.out.println(supplier.toString());
	}

}
