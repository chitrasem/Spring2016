package com.chitra.kmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chitra.kmt.dao.UserDao;
import com.chitra.kmt.model.User;
 
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
 
    @Autowired
    private UserDao dao;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
 
    public User findById(int id) {
        return dao.findById(id);
    }
 
    public User findBySso(String sso) {
        return dao.findBySSO(sso);
    }

	public void save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.save(user);
		
		
	}

	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	public void deleteUserById(int id) {
		dao.deleteUserById(id);
		
	}
 
}
