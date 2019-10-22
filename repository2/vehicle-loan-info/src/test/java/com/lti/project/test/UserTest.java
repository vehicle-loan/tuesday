package com.lti.project.test;

import org.junit.Test;

import com.lti.vehicleloan.dao.GenericDao;
//import com.lti.vehicleloan.entity.GenderEnum;
//import com.lti.vehicleloan.entity.GenderEnum.gender;
import com.lti.vehicleloan.entity.UserCredentials;
import com.lti.vehicleloan.entity.UserPersonalDetails;

public class UserTest {
	
	@Test
	public void adduser() {
		UserCredentials uc = new UserCredentials();
		uc.setEmail("arathy@lti.com");
		uc.setPassword("abc@123");
		GenericDao dao = new GenericDao();
		dao.upsert(uc);
	}
	
	@Test
	public void addPersonalDetailsTest() {
		
		UserPersonalDetails upd = new UserPersonalDetails();
		upd.setName("arun");
		upd.setAge(35);
		upd.setExistingEmi(35000);
		upd.setYearlySalary(2000000);
		upd.setGender("Male");
		upd.setTypeOfEmployement("Salaried");
		//upd.setUserCredentials(uc);
		
	
		GenericDao dao = new GenericDao();
		dao.upsert(upd);
		
	}

}
