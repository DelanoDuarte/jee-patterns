package colarinhobranco.dao;

import java.util.List;

import colarinhobranco.model.User;

public interface UserDao {

public User save(User user);
	
	public User get(Integer id);
	
	public List<User> findAll();

}
