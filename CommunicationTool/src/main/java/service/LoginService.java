 package service;

import java.util.HashMap;
import java.util.List;

import dto.User;
//*************************************************************************
//********************Index of Methods in this class***********************
//*************************************************************************
//1)LoginService()
//This checks that the username matches the password. 
//2)boolean authenticate(String userId, String password)
//this sets the userBean with the login details
//3)User getUserDetails()
//getter for user. 
public class LoginService {
	HashMap<String, String> users = new HashMap<String, String>();
	User user = new User();
	List userList;
	
	
	 
	public LoginService(){
		UserDAO model = new UserDAO();       
		userList = model.getUserList();
	}
	
	//This checks that the username matches the password.
	public boolean authenticate(String userId, String password){
		boolean passwordValid, userExists = false;
		String storedPassword = null;		
		for (int i=0; i<userList.size();i++){ 
			User u = (User) userList.get(i);
			if (u.getUserId().equals(userId)){
				userExists=true;
				storedPassword = u.getPassword();
				
				user.setPassword(u.getPassword());
				user.setUserId(u.getUserId());
				user.setUserId(u.getUserRole());}
				//break;
				}
		

		if (password==null|| password.trim()==("")){
			return false;
		}else if(userExists && storedPassword.equals(password.trim())){
			return true;
			}
		else		
		{return false;}
	}

	
	public User setUserBean(String userName,String password,String userId){
		List userList;
		User user = new User();
		user.setPassword(password);
		user.setUserId(userName);
		user.setUserId(userId);
		return user;
	}
	
	//getter for user
	public User getUserDetails(){
		return user;
		
	}

}
