package com.lti.vehicleloan.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.vehicleloan.dao.GenericDao;
import com.lti.vehicleloan.entity.UserCredentials;
import com.lti.vehicleloan.entity.UserPersonalDetails;
import com.lti.vehicleloan.entity.VehicleDetails;

public class App{

	public static void main(String[] args) {
		
	ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");

	
	GenericDao dao = (GenericDao) context.getBean("up");
	
	UserCredentials uc = new UserCredentials();
	uc.setPassword("micheal@123");
	uc.setEmail("micheal@lti");
	UserPersonalDetails u = (UserPersonalDetails)dao.fetchById(UserPersonalDetails.class, 3);
	uc.setUserPersonalDetails(u);
	//dao.upsert(uc);


	UserPersonalDetails upd = new UserPersonalDetails();
	upd.setName("Anuja");
	upd.setAge(32);
	upd.setExistingEmi(53434);
	upd.setYearlySalary(653465);
	upd.setGender("Female");
	upd.setTypeOfEmployement("Salaried");
	dao.upsert(upd);
	
	VehicleDetails v = new VehicleDetails();
	v.setVehicleId(3);
	v.setCarMake("Honda");
	v.setCarModel("Amaze");
	v.setEx_Showroom_Price(423234.0);
	v.setOn_Road_Price(5345.0);
	UserPersonalDetails ud  =(UserPersonalDetails) dao.fetchById(UserPersonalDetails.class, 2);
	v.setUserPersonalDetails(ud);
	//dao.upsert(v);
	
	}
}
