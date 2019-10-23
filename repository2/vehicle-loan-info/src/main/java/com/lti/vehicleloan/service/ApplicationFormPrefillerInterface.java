package com.lti.vehicleloan.service;

import com.lti.vehicleloan.entity.UserPersonalDetails;

public interface ApplicationFormPrefillerInterface {

	public UserPersonalDetails getUserPersonalDetails(int userId);
	public String getEmail(int userId);
}
