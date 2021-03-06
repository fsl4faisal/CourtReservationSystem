package com.faisal.court.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.faisal.court.domain.Player;
import com.faisal.court.domain.Reservation;
import com.faisal.court.domain.ReservationValidator;
import com.faisal.court.domain.SportType;
import com.faisal.court.service.ReservationService;

@Controller
@RequestMapping("/reservationForm")
@SessionAttributes("reservation")
public class ReservationFormController {

	@Autowired
	private ReservationService reservationService;

	@Autowired
	private ReservationValidator reservationValidator;

	@ModelAttribute("sportTypes")
	public List<SportType> populateSportTypes() {
		return reservationService.getAllSportTypes();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(@RequestParam(required = false, value = "username") String username, Model model) {
		Reservation reservation = new Reservation();
		reservation.setPlayer(new Player(username, null));

		model.addAttribute("reservation", reservation);
		return "reservationForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("reservation") Reservation reservation, BindingResult result,
			SessionStatus status,Model model) {
		System.out.println("From SubmitForm(value of reservation):" + reservation);
		reservationValidator.validate(reservation, result);
		if (result.hasErrors()) {
			model.addAttribute("reservation",reservation);
			return "reservationForm";
		}else{
			reservationService.make(reservation);
			return "redirect:reservationForm";
		}
	}

}
