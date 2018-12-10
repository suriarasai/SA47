package sg.iss.demo.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sg.iss.demo.model.User;
import sg.iss.demo.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	UserRepository urepo;

	@Override
	public ArrayList<User> findAllUsers() {
		ArrayList<User> ulist = (ArrayList<User>)urepo.findAll();
		return ulist;
	}

	@Override
	public User findUserById(Long id) {
		return urepo.findById(id).get();
	}

	@Override
	public ArrayList<User> findUsersByCriteria(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createUser(User u) {
		urepo.save(u);
		return 0;
	}

	@Override
	public int updateUser(User u) {
		urepo.saveAndFlush(u);
		return 0;
	}

	@Override
	public int removeUser(User u) {
		urepo.delete(u);
		return 0;
	}

}
