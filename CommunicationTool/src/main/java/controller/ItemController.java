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
import service.UserDAO;
import dto.Blog;
import dto.Item;
import dto.User;
import dto.UserList;

//*************************************************************************
//********************Index of Methods in this class***********************
//*************************************************************************
//*************************************************************************
//1) String showBlog()
//This is a GET method that sends the infromation to the Blog Post 
//2)String showIndividualBlog(@PathVariable String blogPostNumber, ModelMap model)
//This is a GET that takes the {blogPostNumber} from the URL.
//3) String showNamedBlog(@PathVariable String blogName, ModelMap model)
//This get the blogs name from the URL and shows the blogs JSP.
//4) String postToBlog(@ModelAttribute("item") Item item, ModelMap model)
//This is the POST method for the blog page.
//5) String individualBlogGet()
//This is the GET method for the individual blog post(*****depricated****)
//6) String individualBlog(@PathVariable String blogPostNumber, ModelMap model)
//This is the GET method for an individual post
//7) String postComment(@ModelAttribute("item") Item item, ModelMap model)
//This is the POST method that allows users to comment on individual posts.
//8) String showNamedForum(@PathVariable String forumName, ModelMap model)
//This is the GET method to load a named forum on the first view, 
//9) String postForumThread(@ModelAttribute("item") Item item, ModelMap model)
//this is the POST method for the forum page.
//10)String individualForum(@PathVariable String forumPostNumber, ModelMap model)
//This is the GET method for an individual forum post page.
//11)String postForumComment(@ModelAttribute("item") Item item, ModelMap model)
//This is the post for an individual forum post page, i.e. allows the user to add a 
//comment to a forum post. 
//*************************************************************************
@Controller
@RequestMapping("/")
public class ItemController {
	
	//(1)This is a GET method that sends the infromation to the Blog Post 
	@RequestMapping(value="/blogpost", method = RequestMethod.GET)
	public String showBlog(){
		return "BlogPage";
	    }
	//(2)This is a GET that takes the {blogPostNumber} from the URL.
	@RequestMapping(value="/blogpost/{blogPostNumber}", method = RequestMethod.GET)
	public String showIndividualBlog(@PathVariable String blogPostNumber, ModelMap model){
		BlogDAO blogdao = new BlogDAO();
		//******************************************
		Blog singleBlogPost = new Blog();
		singleBlogPost = blogdao.getSingleBlogPosts(blogPostNumber);
		//******************************************


		model.addAttribute("testAttribute", singleBlogPost);
		return "BlogPage";
	    }
	
	//(3)This get the blogs name from the URL and shows the blogs JSP.
	@RequestMapping(value="/blog/{blogName}", method = RequestMethod.GET)
	public String showNamedBlog(@PathVariable String blogName, ModelMap model){
		String nameOfBlog = blogName;
		ItemDAO dao = new ItemDAO();
		List<Item> listItem = null;
		Item item = new Item();
		dao.addPost(item);
		listItem = dao.getItemPosts(blogName);
		listItem = dao.reverseBlogOrder(listItem);
		model.addAttribute("listItem", listItem);
		model.addAttribute(item);
		model.addAttribute("nameOfBlog",nameOfBlog);
		item.setName(blogName);
		return "BlogName";
	    }
	
	//(4)//This is the POST method for the blog page.
	@RequestMapping(value="/blog/{blogName}", method = RequestMethod.POST)
	public String postToBlog(@ModelAttribute("item") Item item, ModelMap model) {
		ItemDAO dao = new ItemDAO();
		List<Item> listItem = null;
		String nameOfBlog = item.getName();

		dao.addPost(item);
		
		item.setName(item.getName());
		model.addAttribute(item);
		listItem = dao.getItemPosts(item.getName());//trying to just pull out the items with a blog name
		listItem = dao.reverseBlogOrder(listItem);
		model.addAttribute("listItem", listItem);
		model.addAttribute("nameOfBlog",nameOfBlog);
		
		return "BlogName"; 
 
	}	
	
	//depricated?
	/*@RequestMapping(value="/blog/blogpost", method = RequestMethod.GET)
	public String individualBlogGet(){
		return "ItemBlogPage";
	    }*/
	
	
	//(6)This is the GET method for an individual post
	@RequestMapping(value="/blog/blogpost/{blogPostNumber}", method = RequestMethod.GET)
	public String individualBlog(@PathVariable String blogPostNumber, ModelMap model){
		//BlogDAO blogdao = new BlogDAO();
		ItemDAO itemdao =  new ItemDAO();
		//******************************************
		Item item = new Item();
		Blog singleBlogPost = new Blog();
		item = itemdao.getSingleItemPosts(blogPostNumber);
		model.addAttribute(item);//This stopped the page blowing up!
		model.addAttribute("listItem", item);
		return "ItemBlogPage";
	    }
	
	//(7)This is the POST method that allows users to comment on individual posts.
	@RequestMapping(value="/blog/blogpost/{blogPostNumber}", method = RequestMethod.POST)
	public String postComment(@ModelAttribute("item") Item item, ModelMap model) {
		ItemDAO dao = new ItemDAO();
		List<Item> listItem = null;
		String nameOfBlog = item.getName();
		item.setName(item.getName());
		item.setItemName(item.getItemName());
		item.setaKey(item.getaKey());		
		int index = item.getCommentIndex();
		if ((Integer)index ==(null)||index ==0){
			item.setCommentIndex(1);
			index =1;
		}else{item.setCommentIndex(index +1);
		index++;}
		
		model.addAttribute(item); 		
		model.addAttribute("nameOfBlog",nameOfBlog);		
		dao.addComment(item, "one", index);
		Item i = dao.getSingleItemPosts(Integer.toString(item.getaKey()));
		model.addAttribute("listItem", i);
		return "ItemBlogPage"; 
 
	}	
	
	
	//(8)This is the GET method to load a named forum on the first view, 
	@RequestMapping(value="/forum/{forumName}", method = RequestMethod.GET)
	public String showNamedForum(@PathVariable String forumName, ModelMap model){
		String nameOfForum = forumName;
		ItemDAO dao = new ItemDAO();
		List<Item> listItem = null;
		Item item = new Item();
		listItem = dao.getItemPosts(forumName);
		model.addAttribute("listItem", listItem);
		model.addAttribute(item);
		model.addAttribute("nameOfForum",nameOfForum);
		item.setName(forumName);
		return "ForumName";
	    }
	
	//(9)this is the POST method for the forum page.
	@RequestMapping(value="/forum/{forumName}", method = RequestMethod.POST)
	public String postForumThread(@ModelAttribute("item") Item item, ModelMap model) {
		ItemDAO dao = new ItemDAO();
		List<Item> listItem = null;
		String nameOfForum = item.getName();
		listItem = dao.getItemPosts(item.getName());//trying to just pull out the items with a blog name
		item.setName(item.getName());
		model.addAttribute(item);
		model.addAttribute("listItem", listItem);
		model.addAttribute("nameOfForum",nameOfForum);
		dao.addPost(item);		
		return "ForumName"; 
 
	}	
	
	
	//(10)This is the GET method for an individual forum post page.
	@RequestMapping(value="/forum/forumpost/{forumPostNumber}", method = RequestMethod.GET)
	public String individualForum(@PathVariable String forumPostNumber, ModelMap model){
		BlogDAO blogdao = new BlogDAO();
		ItemDAO itemdao =  new ItemDAO();
		//******************************************
		Item item = new Item();
		item = itemdao.getSingleItemPosts(forumPostNumber);
		model.addAttribute("item", item);
		return "ForumPage";
	    }
	
	
	//(11)This is the post for an individual forum post page, i.e. allows the user to add a 
	//comment to a forum post. 
	@RequestMapping(value="/forum/forumpost/{forumPostNumber}", method = RequestMethod.POST)
	public String postForumComment(@ModelAttribute("item") Item item, ModelMap model) {
		ItemDAO dao = new ItemDAO();
		List<Item> listItem = null;
		String nameOfForum = item.getName();
		
		//listItem = dao.getItemPosts(item.getItemName());//trying to just pull out the items wihth a blog name
		item.setName(item.getName());
		item.setItemName(item.getItemName());
		item.setaKey(item.getaKey());
		int index = item.getCommentIndex();
		if ((Integer)index ==(null)||index ==0){
			item.setCommentIndex(1);
			index =1;
		}else{item.setCommentIndex(index +1);
		index++;}
		
		model.addAttribute(item); 
		
		model.addAttribute("listItem", listItem);
		model.addAttribute("nameOfBlog",nameOfForum);		
		dao.addComment(item, "one", index);
		
		return "ItemBlogPage"; 
 
	}	


}
