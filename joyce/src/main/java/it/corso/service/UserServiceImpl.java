package it.corso.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.UserDao;
import it.corso.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao dao;
	
	List<User> users = new ArrayList<>();
	
	@Override
	public void getUsers() {
		users = (List<User>) dao.findAll();
	}
	
	@Override
	public boolean checkUser(User user) {
		
		for(User u : users) {
			if(u.getName() == user.getName() && u.getPassword() == user.getPassword()) {
				return true;
			}
		}
		return false;
	}
	
	
}
