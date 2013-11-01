import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import dto.User;


public class UserDAO {
	User u = new User();   //this creates a new user pojo.
	
	private String firstUserName(){
	String userName = "fanny adams";
	
	return userName;
	}
	
	

}
