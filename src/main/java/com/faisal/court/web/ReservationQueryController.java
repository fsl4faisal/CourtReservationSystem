package com.faisal.court.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.faisal.court.domain.Reservation;
import com.faisal.court.service.ReservationService;

@Controller
@RequestMapping("/reservationQuery")
public class ReservationQueryController {
	
	private ReservationService reservationService;
	
	@Autowired
	public void ReservationServiceController(ReservationService reservationService){
		this.reservationService=reservationService;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String setupForm(Map<String, Object> map){
		//List<Reservation> reservations=java.util.Collections.emptyList();
		List<Reservation> reservations=reservationService.getAllReservations();
		map.put("reservations", reservations);
		//model.addAttribute("reservations", reservationService.getAllReservations());
		//this one is the page name--below one
		return "reservationQuery";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submitForm(@RequestParam("courtName") String courtName, Map<String, Object> map){
		List<Reservation> reservations=java.util.Collections.emptyList();
		if(courtName!=null){
			reservations=reservationService.query(courtName);
		}
		map.put("reservations", reservations);
		//model.addAttribute("reservations", reservations);
		return "reservationQuery";
	}
	
	
}
