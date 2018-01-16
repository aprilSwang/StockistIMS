package sg.edu.iss.team1.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.edu.iss.team1.model.User;
import sg.edu.iss.team1.service.UserService;
import sg.edu.iss.team1.validator.UserValidator;

@Controller
@RequestMapping(value = "/home")
public class CommonController {

	@Autowired
	private UserService uService;

	@Autowired
	private UserValidator uValidator;
	
	@InitBinder("user")
	private void initProductBinder(WebDataBinder binder) {
		binder.addValidators(uValidator);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String logic(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute @Valid User user, BindingResult result, HttpSession session) {
		ModelAndView mav = new ModelAndView("login");
		if (result.hasErrors())
			return mav;
		UserSession us = new UserSession();
		if (user.getName() != null && user.getPassword() != null) {
			User u = uService.authenticate(user.getName(), user.getPassword());
			us.setUser(u);
			us.setSessionId(session.getId());
						
			mav = new ModelAndView("redirect:/admin/transaction/list");
		} else {
			return mav;
		}
		session.setAttribute("USERSESSION", us);
		
		return mav;
	}

}


