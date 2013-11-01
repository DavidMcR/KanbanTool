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
import dto.Blog;
import dto.CreateBlogDTO;
import dto.CreateItemDTO;
import dto.Item;
import dto.User;
import dto.UserList;

//*************************************************************************
//********************Index of Methods in this class***********************
//*************************************************************************
//*************************************************************************
//This is a series of methods to allow the creation of new blogs. 
//It is accessed by the "http://<name>/createnewblog" url
//1) String showBlog()
//This methods creates a blank table when the URL is accessed. 
//It is esentially an administrative tool.
//2) String showPage(ModelMap model)
//This is the GET method that loads the page
//3) String postPage(@ModelAttribute("blogName")
//This is the POST page that takes the details form the Form and creates 
//a new Blog or Forum. 
//**** *********************************************************************
@Controller
@RequestMapping("/createnewblog")
public class BlogPostController {
	
	
	
	//This methods creates a blank table when the URL is accessed. It is esentially an administrative tool. 
	@RequestMapping(value="/createtable", method = RequestMethod.GET)
	public String showBlog(){
		ItemDAO dao = new ItemDAO();
		dao.createNewTable();
		return "CreateItemTable";
	    }
	//this method takes the blog name from the form and creates a blog. 
	//this gives the illusion of creating a new blog, it merely adds a new row to the bottom of the sql table
	//with the blog name and no entries. This then can be used by the system to get the names of all the blogs. 
	@RequestMapping( method = RequestMethod.GET)
	public String showPage(ModelMap model){
		CreateBlogDTO dto = new CreateBlogDTO();
		model.addAttribute("itemName", dto);
		return "CreateBlogPage";
	    }

	//This is the POST page that takes the details form the Form and creates 
	//a new Blog or Forum. 
	@RequestMapping( method = RequestMethod.POST)
	public String postPage(@ModelAttribute("blogName")
	CreateBlogDTO blogName, ModelMap model){
		ItemDAO dao = new ItemDAO();
		NewBlogDAO newBlog = new NewBlogDAO();
		model.addAttribute("itemName", blogName);
		System.out.println(blogName.getItemName()+"              "+blogName.getType());
		newBlog.addNewBlog(blogName.getItemName(), blogName.getType());
		return "CreateBlogPage";
	    }

}
