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

import service.BlogDAO;
import service.ItemDAO;
import service.NewBlogDAO;
import service.UserDAO;
import dto.ActiveItems;
import dto.Blog;
import dto.CreateItemDTO;
import dto.Item;
import dto.User;
import dto.UserList;


/**
 * @author David
 *
 */

//*************************************************************************
//********************Index of Methods in this class***********************
//*************************************************************************
//*************************************************************************
//This is a controller to display the blogs and forums that have been created
//It produces a simple JSP (DisplayOptions) that has a series of links on it
//that can be clicked to take the user to the selected Blog\Forum.
//1)String showPage(ModelMap model)
//The ModelMap posts the information to the web page
//The list of the names of blogs and forums is pulled from the table
//and assigned to lists that are sent to the page. 
//*************************************************************************
@Controller
@RequestMapping("/displayoptions")
public class DisplayOptionsController {
	

	@RequestMapping( method = RequestMethod.GET)
	public String showPage(ModelMap model){
		model.addAttribute("attribute", "hello");
		Item item = new Item();
		ItemDAO dao = new ItemDAO();
		List<String> blogList= (List<String>) dao.getBlogNames("blog");
		List<String> forumList= (List<String>) dao.getBlogNames("forum");		
		model.addAttribute("forumList", forumList);
		model.addAttribute("blogList", blogList);
		return "DisplayOptions"; 
	    }

}
