package it.corso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.UserDao;
import it.corso.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao dao;
	
	
	@Override
	public boolean checkUser(User user) {
		List<User> users = (List<User>) dao.findAll();
		for(User u : users) {
			if(u.getUser().equals(user.getUser()) && u.getPassword().equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}
	
	
}
