package it.corso.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.UserDao;
import it.corso.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao dao;
	@Autowired
	HttpSession session;
	
	@Override
	public boolean checkUser(User user) {
		List<User> users = (List<User>) dao.findAll();
		for(User u : users) {
			if(u.getUser().equals(user.getUser()) && u.getPassword().equals(user.getPassword())) {
				if(session.getAttribute("user") == null || user.getId() != ((User) session.getAttribute("user")).getId()) {
					session.setAttribute("user", user);
				}
				return true;
			}
		}
		return false;
	}
	
	
}
