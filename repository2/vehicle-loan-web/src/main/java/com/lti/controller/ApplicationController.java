package com.lti.controller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.lti.vehicleloan.dto.ApplicationFormDTO;
import com.lti.vehicleloan.entity.UserCredentials;
import com.lti.vehicleloan.entity.UserDocuments;
import com.lti.vehicleloan.entity.UserPersonalDetails;
import com.lti.vehicleloan.service.ApplicationFormService;
import com.lti.vehicleloan.service.ApplicationFormServiceInterface;



@Controller
public class ApplicationController {
	
	@Autowired
	private ApplicationFormServiceInterface applicationFormService;

	@RequestMapping(path="/application-form.lti" , method=RequestMethod.POST)
	public String applicationForm(ApplicationFormDTO applicationForm,Map Model) throws Exception {
		
		UserPersonalDetails userPersonalDetails = new UserPersonalDetails(); 
		userPersonalDetails.setName(applicationForm.getFirstName()+" "+applicationForm.getLastName());
		userPersonalDetails.setGender(applicationForm.getGender());
		userPersonalDetails.setAge(applicationForm.getAge());
		userPersonalDetails.setTypeOfEmployement(applicationForm.getTypeOfEmployment());
		userPersonalDetails.setYearlySalary(applicationForm.getSalary());
		userPersonalDetails.setExistingEmi(applicationForm.getExistingEmi());
		userPersonalDetails.setMobileNumber(applicationForm.getMobileNumber());
		//userPersonalDetails.setUserCredentials(userCredentials);
		
		
		MultipartFile aadharCard = applicationForm.getAadharCard();
		/*System.out.println(aadharCard);
		InputStream is = aadharCard.getInputStream();
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		while(true) {
			int x = is.read();
			if(x == -1) break;
			os.write(x);
		}
		byte[] b = os.toByteArray();*/
		//Blob panCard = applicationForm.getPanCard();
		//Blob salarySlip = applicationForm.getSalarySlip();
		//Blob photo = applicationForm.getPhoto();
		
		UserDocuments userDocuments = new UserDocuments();
		userDocuments.setAadhaarCard(aadharCard.getBytes());
		userDocuments.setPanCard(aadharCard.getBytes());
		userDocuments.setSalarySlip(aadharCard.getBytes());
		userDocuments.setBankDetails(aadharCard.getBytes());
		userPersonalDetails.setUserDocuments(userDocuments);

	//	applicationFormService.saveUserCredentials(userCredentials);
		applicationFormService.saveUserPersonalDetails(userPersonalDetails);
		//applicationFormService.saveUserDocuments(userDocuments);

		return "success.jsp";
	}
}
