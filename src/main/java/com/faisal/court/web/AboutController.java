package com.faisal.court.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutController {
	
	@Value("#{messageSource.getMessage('admin.email',null,'en')}")
	private String email;
	
	@RequestMapping("/about")
	public String courtReservation(Map<String,Object> map){
		map.put("email", email);
		return "about"; 
	}
	

}
