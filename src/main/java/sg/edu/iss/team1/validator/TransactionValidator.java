package sg.edu.iss.team1.validator;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.edu.iss.team1.model.Product;
import sg.edu.iss.team1.model.Transaction;
import sg.edu.iss.team1.service.ProductService;

@Component
public class TransactionValidator implements Validator {

	@Autowired
	ProductService pservice;

	@Override
	public boolean supports(Class<?> arg0) {
		return Transaction.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		Date today = new Date();
		Transaction transaction = (Transaction) arg0;
		Product product = pservice.findProduct(transaction.getPartNumber());

		if (transaction.getQuantity() > product.getQuantity()) {
			arg1.reject("quantity", "There is no stock for this amount of quantity");
			arg1.rejectValue("quantity","","There is no stock for this amount of quantity");
		}

		if (Integer.valueOf(transaction.getQuantity()) <= 0) {
			arg1.reject("quantity", "Quantity can't be less than 0");
			arg1.rejectValue("quantity","", "Quantity can't be less than 0");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "transactionDate","", "Select usage date.");
		
		if (transaction.getTransactionDate()!=null && transaction.getTransactionDate().compareTo(today) > 0) {
			arg1.reject("transactionDate", "Date cannot exceed today's date.");
			arg1.rejectValue("transactionDate","", "Date cannot exceed today's date.");
		}
	}

}
