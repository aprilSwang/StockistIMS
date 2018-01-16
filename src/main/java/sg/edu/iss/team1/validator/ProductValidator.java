package sg.edu.iss.team1.validator;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.edu.iss.team1.model.Product;
import sg.edu.iss.team1.service.ProductService;

@Component
public class ProductValidator implements Validator {

	@Autowired
	ProductService pservice;

	@Override
	public boolean supports(Class<?> arg0) {
		return Product.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		
		Product p = (Product) arg0;

		ArrayList<Product> al = pservice.findAllProduct();
		boolean IsPresence = false;

		for (Product product : al) {
			if (product.getPartNumber() == p.getPartNumber())
				IsPresence = true;
		}

		if (IsPresence == true) {
			errors.reject("partNumber");
			errors.rejectValue("partNumber", "error.product.partNumber", "the partnumber exits");
		}
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "partNumber", "error.product.partNumber.empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "unitPrice", "error.product.unitPrice.empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantity", "error.product.quantity.empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "error.product.description.empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "color", "error.product.color.empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dimension", "error.product.dimension.empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "manufacturer", "error.product.manufacturer.empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "reorderLevel", "error.product.reorderLevel.empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "minReorderQnty", "error.product.minReorderQnty.empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shelfLocation", "error.product.shelfLocation.empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "supplierName", "error.product.supplierName.empty",
					"name is empty");

			System.out.println(p.toString());
		}

	
}
