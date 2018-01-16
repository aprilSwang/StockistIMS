package sg.edu.iss.team1.validator;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.edu.iss.team1.model.User;
import sg.edu.iss.team1.service.UserService;

@Component
public class UserValidator implements Validator {

	@Autowired
	UserService uservice;

	@Override
	public boolean supports(Class<?> team) {
		return User.class.isAssignableFrom(team);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		User user = (User) arg0;

		/*
		 * if (user.equals(null)) { ValidationUtils.rejectIfEmpty(errors, "name",
		 * "error.user.name.empty"); ValidationUtils.rejectIfEmpty(errors, "password",
		 * "error.user.password.empty"); }
		 */

		boolean isUser = false;

		ArrayList<User> us = uservice.findAllUsers();

		ValidationUtils.rejectIfEmpty(errors, "name", "error.user.name.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "error.user.password.empty");

		for (User user2 : us) {
			if (user2.getName().equals(user.getName())) {
				isUser = true;
				if ((user2.getName().equals(user.getName()) && user2.getPassword().equals(user.getPassword()))) {
					break;

				} else if (user2.getName().equals(user.getName())
						&& !(user2.getPassword().equals(user.getPassword()))) {
					errors.reject("password");
					errors.rejectValue("password", "errors.user.password", "The password is incorrect!");
					break;
				}

			}

//			if (user.getName().equals("a")) {
//				errors.reject("name");
//				errors.rejectValue("name", "errors.user.name", "The username is incorrect!");
//				break;
//			}
		}

		System.out.println(user.toString());
	}
}