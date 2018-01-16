package sg.edu.iss.team1.service;

import java.util.ArrayList;

import sg.edu.iss.team1.model.Role;
import sg.edu.iss.team1.model.User;

public interface UserService {

	ArrayList<User> findAllUsers();

	User findUser(int userID);

	User createUser(User user);

	User changeUser(User user);

	void removeUser(User user);

	ArrayList<Role> findRolesForUser(int userID);

	ArrayList<String> findRoleNamesForUser(int userID);
	
	User authenticate(String uname, String pwd);

}