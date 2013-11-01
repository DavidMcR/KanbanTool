package service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import dto.User;
//1)List getUserList()
//this gets the full user table
//2)void addNewUser(User us)
//this adds the User us to the table
public class UserDAO {
	
	//(1)this gets the full user table
	public List getUserList(){
			User u = new User();
			List<User> users; 
			
			Configuration configuration = new Configuration();
	   	    ServiceRegistry serviceRegistry;
	   	    configuration.configure();
	   	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();	
		    SessionFactory  sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			//*************************************************************
			Query query = session.createQuery("from USER_DETAILS");
			 users = (List<User>) query.list();
			//*************************************************************		
			session.getTransaction().commit();		
			session.close();

	   	    String name = (users.get(0)).getUserRole();
			
			return users;
		}
	
	//(2)this adds the User us to the table
	public void addNewUser(User us){
		 User u = new User();
		 u = us; 
		u.setPassword(us.getPassword());
		u.setUserId(us.getUserId());
		u.setUserRole(us.getUserRole());
		Configuration configuration = new Configuration();   
	    ServiceRegistry serviceRegistry;
	    configuration.configure(); 
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();	
	    SessionFactory  sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
		
		session.close();
		
	}
	}
