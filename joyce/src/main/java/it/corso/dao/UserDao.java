package it.corso.dao;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.User;

public interface UserDao extends CrudRepository<User, Integer>{

}
