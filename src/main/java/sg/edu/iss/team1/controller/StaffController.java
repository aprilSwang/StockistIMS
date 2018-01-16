package sg.edu.iss.team1.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.team1.validator.LoginValidator;


@Controller
@RequestMapping(value = "/staff")
public class StaffController {
	
	@Autowired
	private LoginValidator lValidator;

	@InitBinder("user")
	private void initCourseBinder(WebDataBinder binder) {
		binder.addValidators(lValidator);
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home/login";

	}
	
}
