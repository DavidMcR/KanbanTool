package dto;

import java.util.List;
import java.util.HashMap;



public class UserList {

	HashMap<String, String> userList = new HashMap<String, String>();

	public HashMap<String, String> getUserList() {
		return userList;
	}

	public void setUserList(HashMap<String, String> users) {
		this.userList = users;
	}


}
