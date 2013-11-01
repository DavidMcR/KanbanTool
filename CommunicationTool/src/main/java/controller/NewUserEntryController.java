package controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import service.UserDAO;
import dto.User;
import dto.UserList;
//*************************************************************************
//********************Index of Methods in this class***********************
//*************************************************************************
//*************************************************************************
//This produces a page that displays all the users in the Users table
//It also allows new users to be created. 
//1) String showContacts(ModelMap model)
//This is the GET method that sends that gets the users from the database 
//and sends them to the JSP via the ModelMap
//2) String addContact(@ModelAttribute("user") User user, ModelMap model)
//This gets the new user infromation from the Form on the page and sends 
//it back to the page. 
//*************************************************************************

@Controller
@RequestMapping("/contacts")
public class NewUserEntryController {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String showContacts(ModelMap model){
		UserDAO ud = new UserDAO();       
		List userList = ud.getUserList();
		User user = new User();
		//user.setUserId("nickers");
		model.addAttribute("user", user);
		model.addAttribute("userList", userList);
		return "userEntry";
	    }	

	@RequestMapping(method = RequestMethod.POST)
	public String addContact(@ModelAttribute("user")
	User user, ModelMap model){
		model.addAttribute(user);
		System.out.println("user id "+user.getUserId());
		UserDAO ud = new UserDAO(); 
		ud.addNewUser(user);
		List userList = ud.getUserList();
		model.addAttribute(userList);
		return "userEntry";
	}


}
