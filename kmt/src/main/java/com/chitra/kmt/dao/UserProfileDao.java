package com.chitra.kmt.dao;

import java.util.List;

import com.chitra.kmt.model.UserProfile;

public interface UserProfileDao {
	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
	

}
