package service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import dto.Blog;
import dto.User;
import dto.UserList;

public class BlogDAO {
	//*************************************************************************
	//********************Index of Methods in this class***********************
	//*************************************************************************
	//*************************************************************************
	//1) List getBlogPosts()
	//   This returns a List of Blogs with all the blogs in the BLOG table. This will
	//   soon be depricated and replaced with a more generic model. 
	//2) List getBlogPosts(String BlogName)	
	//3) Blog getSingleBlogPosts(String number)
	//   Takes a number and returns the blog post that this number is associated
	//   with i.e. the Key in the SQL database that lists those blog posts.
	//4) List reverseBlogOrder(List bList)
	//   Blogs are displayed from latests to last. However they are stored from 
	//   with the oldest at the top, so this reverses the ordering so they can be 
	//   taken from the database and 
	//5) void addNewBlogPost(Blog blog)
	//   This takes a Blog object as an input and puts it in the BLOG table.
	//   This is an older method to develop the functionality and soon to be depricated
	//   replaced by a more generic function. 
	//*************************************************************************
	//*************************************************************************
	
	
	//public BlogDAO(){
	//do we need a blog creator, first post should do this job.......... do not add to index. 	
	public void createNewBlog(String blogName){
		
	}
	


	public List getBlogPosts(){
		List<Blog> blogList =null; // create a list to put all the blog posts in.
		Blog blog = new Blog();   //instantiate a blog object.
		
		//*************************************************************
		Configuration configuration = new Configuration();   
	    ServiceRegistry serviceRegistry;
	    configuration.configure(); 
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();	
	    SessionFactory  sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//*************************************************************
		Query query = session.createQuery("from BLOG");
		 blogList = (List<Blog>) query.list();
		//*************************************************************		
		session.getTransaction().commit();		
		session.close();
		return blogList;
	}
	
	//************************************************************
	
	 	public Blog getSingleBlogPosts(String number){
	 		List<Blog> blogList =null; // create a list to put all the blog posts in.
			Blog blog = new Blog();  //instantiate a blog object.
		  		
		//*************************************************************
		Configuration configuration = new Configuration();   
	    ServiceRegistry serviceRegistry;
	    configuration.configure(); 
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();	
	    SessionFactory  sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//*************************************************************
		Query query = session.createQuery("from BLOG where aKey ="+number);
		 blogList = (List<Blog>) query.list();
		//*************************************************************		
		session.getTransaction().commit();		
		session.close();
		blog = blogList.get(0);
		return blog;
	}
	 
	//************************************************************
	
	public List reverseBlogOrder(List bList){
		Collections.reverse(bList);
		return bList;
		
	}
	
	public void addNewBlogPost(Blog blog){
		 Blog b =  new Blog();
		 b=blog;
		 b.setInsertDate(new Date());
		Configuration configuration = new Configuration();   
	    ServiceRegistry serviceRegistry;
	    configuration.configure(); 
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();	
	    SessionFactory  sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(b);
		session.getTransaction().commit();
		session.close();
		
	}
	
		
}
