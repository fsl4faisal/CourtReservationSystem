package com.faisal.court.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.faisal.court.service.ReservationService;

@Controller
public class ReservationSuccessController {

	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping("/reservationSuccess")
	public String successPage(){
		return "reservationSuccess";
	}
}
