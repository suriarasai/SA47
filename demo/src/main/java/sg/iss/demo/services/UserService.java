package sg.iss.demo.services;

import java.util.ArrayList;

import sg.iss.demo.model.User;

public interface UserService {
	
	ArrayList<User> findAllUsers();

	User findUserById(Long id);

	ArrayList<User> findUsersByCriteria(User u);

	int createUser(User u);

	int updateUser(User u);

	int removeUser(User u);

}
