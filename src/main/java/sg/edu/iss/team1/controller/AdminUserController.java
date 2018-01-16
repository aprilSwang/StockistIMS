
package sg.edu.iss.team1.controller;

import java.util.ArrayList;
import java.util.List;

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


import sg.edu.iss.team1.exception.UserNotFound;
import sg.edu.iss.team1.model.User;
import sg.edu.iss.team1.repository.UserRepository;
import sg.edu.iss.team1.service.UserService;
import sg.edu.iss.team1.validator.UserValidator;

@RequestMapping(value = "/administrator/user")
@Controller

public class AdminUserController  {

	@Autowired
	UserService uservice;
	@Autowired
	private UserValidator uValidator;

	@InitBinder("user")
	private void initUserBinder(WebDataBinder binder) {
		binder.addValidators(uValidator);
	
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView userListPage() {
		ModelAndView mav = new ModelAndView("user-list");
		ArrayList<User> userList = (ArrayList<User>) uservice.findAllUsers();
		mav.addObject("userList", userList);
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newUserPage() {
		User u = new User();
		ModelAndView mav = new ModelAndView("user-new", "user", u);
		//mav.addObject("supplier", sservice.createSupplier(u));
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewUser(@ModelAttribute @Valid User user, BindingResult result,
			final RedirectAttributes redirectAttributes) throws UserNotFound {
		
		if (result.hasErrors())
		return new ModelAndView("user-new");

		ModelAndView mav = new ModelAndView();
		String message = "New User was successfully created.";

		uservice.createUser(user);
		mav.setViewName("redirect:/administrator/user/list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;

	}
	@RequestMapping(value = "/edit/{userID}", method = RequestMethod.GET)
	public ModelAndView editUserPage(@PathVariable String userID) {
		ModelAndView mav = new ModelAndView("user-edit");
		int userIDD=Integer.parseInt(userID);
		User user=uservice.findUser(userIDD);
		mav.addObject("user", user);
		return mav;
	}

	@RequestMapping(value = "/edit/{userID}", method = RequestMethod.POST)
	public ModelAndView editSupplierPage(@ModelAttribute User user, BindingResult result,
			@PathVariable String userID,final RedirectAttributes redirectAttributes)  {


		ModelAndView mav = new ModelAndView("redirect:/administrator/user/list");
		uservice.changeUser(user);
		String message = "User list was successfully updated.";
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value = "/delete/{userID}", method = RequestMethod.GET)
	public ModelAndView deleteUserPage(@PathVariable String userID, 
			final RedirectAttributes redirectAttributes){

		ModelAndView mav = new ModelAndView("redirect:/administrator/user/list");
		int uuserID=Integer.parseInt(userID);
		User user=uservice.findUser(uuserID);
		uservice.removeUser(user);
		String message = "User was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	
}