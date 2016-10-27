package com.chitra.kmt.service;

import java.util.List;

import com.chitra.kmt.model.UserProfile;

public interface UserProfileService {
	
	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findByid(int id);

}
