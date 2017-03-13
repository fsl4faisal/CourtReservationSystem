package com.faisal.court.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import com.faisal.court.domain.SportType;
import com.faisal.court.domain.SportTypeEditor;
import com.faisal.court.service.ReservationService;


public class ReservationWebBindingInitializer implements WebBindingInitializer {
	
	private ReservationService reservationService;
	
	@Autowired
	public ReservationWebBindingInitializer(ReservationService reservationService) {
		this.reservationService=reservationService;
	}
	
	@Override
	public void initBinder(WebDataBinder binder, WebRequest request) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(SportType.class, new SportTypeEditor(reservationService));
	}

}
