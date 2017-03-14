package com.faisal.court.web;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.faisal.court.domain.Reservation;
import com.faisal.court.service.ReservationService;
import com.faisal.court.service.ReservationWebException;

@Controller
@RequestMapping("/reservationSummary*")
public class ReservationSummaryController {
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String generateSummary(@RequestParam(required=true,value="date") String selectedDate,Model model){
		List<Reservation> reservations=java.util.Collections.emptyList();
		try{
			Date summaryDate=new SimpleDateFormat("yyyy-MM-dd").parse(selectedDate);
			reservations=reservationService.findByDate(summaryDate);
		}catch(java.text.ParseException ex){
			StringWriter sw=new StringWriter();
			PrintWriter pw=new PrintWriter(sw);
			ex.printStackTrace(pw);
			throw new ReservationWebException("Invalid date format for reservation summary",new Date(),sw.toString());
		}
		model.addAttribute("reservations",reservations);
		return "reservationSummary";
	}
	
}
