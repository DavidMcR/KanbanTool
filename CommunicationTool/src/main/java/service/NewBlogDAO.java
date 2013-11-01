package service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import dto.Blog;
import dto.Item;
import dto.TableList;
import dto.User;
//void addNewBlog(String blogName)
public class NewBlogDAO {
	
	public void addNewBlog(String blogName){
		//*****************this needs substantial amendment to work with the new regime***********************
		//**************************************24/08/13******************************************************
		//Table list can be turned to something usefull parking this but leaving it untouched as it may come in handy in the 
		//next few days D.McR 24/08/13
		
		TableList tl = new TableList();//this calls the XXXXX
		tl.setItemName(blogName);//this sets the name in the XXXXX to the TableList object 
		Configuration configuration = new Configuration();   
	    ServiceRegistry serviceRegistry;
	    configuration.configure(); 
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();	
	    SessionFactory  sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(tl);
		session.getTransaction().commit();
		
		session.close();
		
	}
	
	
	
	public void addNewBlog(String name, String type){	
		//This adds a blog name only to the Item table
		//Does not as of yet search to see if the name can be added. 
		Item item = new Item();
		item.setName(name);
		item.setType(type);
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
		
	}
	
	public String addNewBlog(String itemName, int theKey){
		TableList tl = new TableList();//this calls the XXXXX
		//tl.setItemName(itemName);//this sets the name in the XXXXX to the TableList object
		Configuration configuration = new Configuration();   
	    ServiceRegistry serviceRegistry;
	    configuration.configure(); 
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();	
	    SessionFactory  sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//*************************************************************
		//This adds the new items name to the Table_List data base. Once this is done the blog will have to be created. 
		Query query = session.createQuery("update TABLE_LIST set itemName = :itemNameParameter where aKey = :aKeyNumber");
		query.setParameter("itemNameParameter", itemName );
		query.setParameter("aKeyNumber", theKey);
		//*************************************************************	
		int result = query.executeUpdate();
		session.getTransaction().commit();
		
		Query query2 = session.createQuery("from TABLE_LIST where aKey = :aKeyNumber");
		query2.setParameter("aKeyNumber", theKey);
		session.getTransaction().commit();
		
		tl = (TableList) query2.list();
		String tableNameOfNewItem = tl.getTableName();
		session.close();
		return tableNameOfNewItem;
	}
	
	public void populateBlogListForTesting(){
		//This method just populates the TableList with a load of blogs so that testing can be done with limited
		//time spent adding things to MySQL
		TableList tl = new TableList();//this calls the XXXXX
		//tl.setItemName(itemName);//this sets the name in the XXXXX to the TableList object
		for (int i=1; i<20;i++){
		String tableName = "Blog"+i;
		tl.setTableName(tableName);
		Configuration configuration = new Configuration();   
	    ServiceRegistry serviceRegistry;
	    configuration.configure(); 
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();	
	    SessionFactory  sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//*************************************************************
		session.save(tl);
		//*************************************************************
		session.getTransaction().commit();
		
		session.close();
		}
		
	}
	
 	public int getFirstFreeTable(){
 		
 		//This searches the database for the first item name that is free. It then returns the akey number
 		//of that row. 
 		List<TableList> tableList =null; // create a list to put all the blog posts in.
		TableList tl = new TableList();  //instantiate a blog object.
	  	int aKeyOfFirstFreeItem=  2147483647;	
	//*************************************************************
	Configuration configuration = new Configuration();   
    ServiceRegistry serviceRegistry;
    configuration.configure(); 
    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();	
    SessionFactory  sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	
	//*************************************************************
	//Query query = session.createQuery("from TABLE_LIST where aKey = (select min(aKey) from TABLE_LIST where itemName =\'\')");
	Query query = session.createQuery("from TABLE_LIST where aKey = (select min(aKey) from TABLE_LIST where itemName =null)");
	//Query query = session.createQuery("from TABLE_LIST");
	//query.setParameter("queryParameter", "''");
	 tableList = (List<TableList>) query.list();
	 //List a = query.list();
	//*************************************************************		
	session.getTransaction().commit();		
	session.close();
	if (tableList !=null){
	//if (a !=null){
	//System.out.println("This is the result of the query "+tableList.get(0).getTableName());
		System.out.println("This is the result of the query "+tableList.get(0).getaKey());
		aKeyOfFirstFreeItem =tableList.get(0).getaKey();
		//System.out.println("This is the result of the query "+a.get(0));
	}else{System.out.println("fuck it, not working");}
	return aKeyOfFirstFreeItem;
}

}
