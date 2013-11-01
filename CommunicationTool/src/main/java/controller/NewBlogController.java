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
import service.NewBlogDAO;
import service.UserDAO;
import dto.Blog;
import dto.CreateBlogDTO;
import dto.CreateItemDTO;
import dto.User;
import dto.UserList;
////////////////////////////////////////////////////////////

@Controller
@RequestMapping("/createblog")
public class NewBlogController {
	
	
    //This takes a item name and checks to see if there is a table name to associate it with,
	//if so it adds the item to the Table List database and creates the table it is associated with.  
	/*@RequestMapping(method = RequestMethod.POST)
	public String addBlogName(@ModelAttribute("blogName")
	CreateItemDTO blogName, ModelMap model){
		model.addAttribute("blogName", blogName);
		NewBlogDAO blogDAO = new NewBlogDAO();
		int numberOfFirstFree = blogDAO.getFirstFreeTable();

		return "CreateBlogPage";
	}*/

	@RequestMapping( method = RequestMethod.GET)
	public String showPage(ModelMap model){
		CreateBlogDTO itemName = new CreateBlogDTO();
		//model.addAttribute("blogName", blogName);
		return "CreateBlogPage";
	    }
	
	//This allows users to add both the table name and the item name to the 
	@RequestMapping(value="/admin",method = RequestMethod.POST)
	public String addTable(@ModelAttribute("itemName")
	CreateBlogDTO itemName, ModelMap model){
		model.addAttribute("itemName", itemName);
		//NewBlogDAO blogDAO = new NewBlogDAO();
		return "CreateBlogPage"; 
	}

	
	//This calls a method that populates a blank SQL table with some TableNames for testing. 
	@RequestMapping(value="/populate", method = RequestMethod.GET)
	public String populate(){
		NewBlogDAO blogDAO = new NewBlogDAO();
		blogDAO.populateBlogListForTesting();
		return "PopulateTableList";
	    }
	
	
	
	
}
