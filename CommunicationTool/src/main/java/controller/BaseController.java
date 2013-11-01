package controller;
 
import java.util.List;
import java.util.Random;

//import service.UserDAO;




import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import service.BlogDAO;
import service.LoginService;
import service.NewBlogDAO;
import service.UserDAO; 
import dto.Blog;
import dto.CreateBlogDTO;
import dto.User;



@Controller
@RequestMapping("/")
@SessionAttributes("userId")
public class BaseController { 
	//*************************************************************************
	//********************Index of Methods in this class***********************
	//*************************************************************************
	//*************************************************************************
	//1) String welcome(ModelMap model)
	//This is a basic landing page for testing and development. 
	//2)String welcomeName(@PathVariable String name, ModelMap model)
	//This is a basic landing page for testing and development. 
	//3) login(@ModelAttribute("user") User user, BindingResult result)                                
	//this takes in user details form a form, checks if they work 
	//and passes the user to a new page.
	//5) ModelAndView showContacts()
	//6) String forWork()
	//*************************************************************************


	@RequestMapping(value="/login", method = RequestMethod.POST)
	
	public String login(@ModelAttribute("user") 
										User user, ModelMap model/*BindingResult result*/) {		
		LoginService ls = new LoginService(); 
		boolean correctName = ls.authenticate(user.getUserId(), user.getPassword());
		if (correctName){
			model.addAttribute(user.getUserId());
		return "redirect:displayoptions";}
		else {
		return "login";}
	
		
 
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
		return "login"; 
 
	}
	@RequestMapping(value="/newblog", method = RequestMethod.GET)
	public String newblog() {
		return "newblog"; 
 
	}
	@RequestMapping(value="/newblog", method = RequestMethod.POST)
	
	public String createnewblog(@ModelAttribute("create") 
										CreateBlogDTO create, ModelMap model/*BindingResult result*/) {
		model.addAttribute("newblog", create);
		
		NewBlogDAO blogDAO = new NewBlogDAO();
		blogDAO.addNewBlog(create.getItemName(), create.getType());
		int numberOfFirstFree = blogDAO.getFirstFreeTable();
		System.out.println("!!!!!!!!!!!!!!!!!"+ create.getItemName()+ create.getType());
		return "newblog";
	}
	

	
	@RequestMapping(value="/control", method = RequestMethod.GET)
	public String forWork() {
		return "ProjectControlPage"; 
		
	} 
 
}