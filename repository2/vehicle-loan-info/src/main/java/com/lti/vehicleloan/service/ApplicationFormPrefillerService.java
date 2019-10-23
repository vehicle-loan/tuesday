package com.lti.vehicleloan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.vehicleloan.dao.GenericDao;
import com.lti.vehicleloan.entity.UserCredentials;
import com.lti.vehicleloan.entity.UserPersonalDetails;

@Service
public class ApplicationFormPrefillerService implements ApplicationFormPrefillerInterface {
	
	@Autowired
	private GenericDao genericDao;
	
	public UserPersonalDetails getUserPersonalDetails(int userId) {
		
		UserPersonalDetails userPersonalDetails =(UserPersonalDetails) genericDao.fetchById(UserPersonalDetails.class, userId);
		return userPersonalDetails;
	}
	
public String getEmail(int userId) {
	
		UserCredentials userCredentials = (UserCredentials) genericDao.fetchById(UserCredentials.class, userId);
		String email = userCredentials.getEmail();
		return email;
	}
}
