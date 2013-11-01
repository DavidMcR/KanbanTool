package service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import dto.ActiveItems;
import dto.Blog;
import dto.Item;

public class ItemDAO {
	//*************************************************************************
	//********************Index of Methods in this class***********************
	//*************************************************************************
	//1)void addPost(Item item)
	//This takes in an Item entity (from the DTO folder) and saves it to the database.
	//The item will have a field named Type that should identify it as either
	//forum or a blog. 
	//void createNewTable() DDEEAADD
	//2)List getBlogNames(String itemType)
	//This selects all the names Distinct name of an Item type, either blog or forum
	//3)List getItemPosts(String blogName)
	//This selects all the rows associated with a single name. 
	//4)Item getSingleItemPosts(String number)
	//This gets a single blog post by taking in its row number and returning
	//the row.
	//5)void addComment(Item item, String commentColumn, int index)
	//this takes the comment String from the service class and
 	//an index number and adds them to the row, the index is used to 
 	//to work out which is the next empty comment. 
	//6)List getBlogPosts()
	//This returns the whole table
	//7)Blog getSingleBlogPosts(String number)
	//selects a single row from the table. 
	//9)List reverseBlogOrder(List bList)
	//reverses the order of the table
	//10)void addNewBlogPost(Blog blog)
	//adds a new entry to the table. 
	//*************************************************************************
	//*************************************************************************
	
	
	
	
	//(1)This takes in an Item entity (from the DTO folder) and saves it to the database.
	//The item will have a field named Type that should identify it as either
	//forum or a blog. 
	public void addPost(Item item){
		item.setInsertDate(new Date());
		//*************************************************************************
		//********************Hibernate Code***************************************
		//*************************************************************************
		Configuration configuration = new Configuration();   
	    ServiceRegistry serviceRegistry;
	    configuration.configure(); 
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();	
	    SessionFactory  sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(item);
		session.getTransaction().commit();
		session.close();
		//******************end Hibernate*******************************************		
	}
	
	

	//do we need a blog creator, first post should do this job.......... do not add to index. 	
	public void createNewTable(){
		Item item = new Item();
		
		item.setName("first blog name");
		item.setType("blog");
		item.setUserId("first user");
		item.setUserTextEntry("this is the first user text entry");
		item.setInsertDate(new Date());
		//*************************************************************************
		//********************Hibernate Code***************************************
		//*************************************************************************
		Configuration configuration = new Configuration();   
	    ServiceRegistry serviceRegistry;
	    configuration.configure(); 
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();	
	    SessionFactory  sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(item);
		session.getTransaction().commit();
		session.close();
		//******************end Hibernate*******************************************	
	}
	


	//(2)This selects all the names Distinct name of an Item type, either blog or forum
	public List getBlogNames(String itemType){
		ActiveItems activeItems = new ActiveItems();//this might need deleting. D 27/08/13
		List<ActiveItems> listActiveItems = null;

		
		//********************Hibernate Code***********************************
		Configuration configuration = new Configuration();   
	    ServiceRegistry serviceRegistry;
	    configuration.configure(); 
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();	
	    SessionFactory  sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("select distinct itemName from ITEM where type = :itype");
		query.setParameter("itype", itemType);
		List<String> item =(List<String>) query.list();
		session.getTransaction().commit();		
		session.close();
		//*************************end hibernate code**************************
		return item;
	}
	//*************************************************************************
	
	//(3)This selects all the rows associated with a single name. 
	public List getItemPosts(String blogName){
		Item item = new Item();
		List<Item> listItem = null;

		
		//********************Hibernate Code***********************************
		Configuration configuration = new Configuration();   
	    ServiceRegistry serviceRegistry;
	    configuration.configure(); 
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();	
	    SessionFactory  sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from ITEM where itemName = :nameToFind");
		query.setParameter("nameToFind", blogName);
		listItem = (List<Item>) query.list();
		session.getTransaction().commit();		
		session.close();
		//*************************end hibernate code**************************
		return listItem;
	}	

	
	
	//(4)This gets a single blog post by taking in its row number and returning
	//the row.
 	public Item getSingleItemPosts(String number){
 		List<Item> itemList =null; // create a list to put all the blog posts in.
		Item item = new Item();  //instantiate a blog object.
	  		
	//*************************************************************
	Configuration configuration = new Configuration();   
    ServiceRegistry serviceRegistry;
    configuration.configure(); 
    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();	
    SessionFactory  sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	
	//*************************************************************
	Query query = session.createQuery("from ITEM where aKey ="+number);
	 itemList = (List<Item>) query.list();
	//*************************************************************		
	session.getTransaction().commit();		
	session.close();
	item = itemList.get(0);
	return item;
}
 
 	//(5)this takes the comment String from the service class and
 	//an index number and adds them to the row, the index is used to 
 	//to work out which is the next empty comment. 
	public void addComment(Item item, String commentColumn, int index){
		item.setInsertDate(new Date());
		//*************************************************************************
		//********************Hibernate Code***************************************
		//*************************************************************************
 		List<Item> itemList =null; // create a list to put all the blog posts in.	  		
	   //*************************************************************
	    Configuration configuration = new Configuration();   
        ServiceRegistry serviceRegistry;
        configuration.configure(); 
        serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();	
        SessionFactory  sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    Session session = sessionFactory.openSession();
	    String s = "comment"+index;
    	session.beginTransaction();
	   //*************************************************************
	   Query query = session.createQuery("update ITEM set "+s+" ='"+item.getComment1()+"' where aKey ="+item.getaKey());
       int result = query.executeUpdate();
       query = session.createQuery("update ITEM set commentIndex ='"+index+"' where aKey ="+item.getaKey());
       result = query.executeUpdate();
	   //*************************************************************		
	   session.getTransaction().commit();		
	   session.close();
}
	
	//(6)This returns the whole table
	public List getBlogPosts(){
		List<Item> blogList =null; // create a list to put all the blog posts in.
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
		Query query = session.createQuery("from ITEM");
		 blogList = (List<Item>) query.list();
		//*************************************************************		
		session.getTransaction().commit();		
		session.close();
		return blogList;
	}
	
	//(7)selects a single row from the table. 
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
	 
	//(9)reverses the order of the table
	public List reverseBlogOrder(List bList){
		Collections.reverse(bList);
		return bList;
		
	}
	//(10)adds a new entry to the table.  
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
