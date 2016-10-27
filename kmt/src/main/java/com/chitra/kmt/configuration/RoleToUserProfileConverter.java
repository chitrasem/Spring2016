package com.chitra.kmt.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.chitra.kmt.model.UserProfile;
import com.chitra.kmt.service.UserProfileService;


@Component
public class RoleToUserProfileConverter implements Converter<Object, UserProfile>
{
	@Autowired
	UserProfileService userProfileService;
	
	/*
     * Gets UserProfile by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public UserProfile convert(Object element) {
        Integer id = Integer.parseInt((String)element);
        UserProfile profile= userProfileService.findByid(id);
        System.out.println("Profile : "+profile);
        return profile;
    }

}
