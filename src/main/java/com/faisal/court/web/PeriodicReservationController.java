package com.faisal.court.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.util.WebUtils;

import com.faisal.court.domain.PeriodicReservation;
import com.faisal.court.domain.PeriodicReservationValidator;
import com.faisal.court.domain.Player;
import com.faisal.court.domain.SportType;
import com.faisal.court.service.ReservationService;

@Controller
@RequestMapping("/periodicReservationForm")
@SessionAttributes("reservation")
public class PeriodicReservationController {

	@Autowired
	private ReservationService reservationService;

	@Autowired
	PeriodicReservationValidator periodicReservationValidator;

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) {
		PeriodicReservation reservation = new PeriodicReservation();
		reservation.setPlayer(new Player());
		model.addAttribute("reservation", reservation);
		return "reservationCourtForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("reservation") PeriodicReservation reservation, BindingResult result, SessionStatus status,
			@RequestParam("_page") int currentPage, Model model) {

		Map<Integer, String> pageForms = new HashMap<Integer, String>();
		pageForms.put(0, "reservationCourtForm");
		pageForms.put(1, "reservationTimeForm");
		pageForms.put(2, "reservationPlayerForm");

		if (request.getParameter("_cancel") != null) {
			return pageForms.get(currentPage);
		} else if (request.getParameter("_finish") != null) {
			periodicReservationValidator.validate(reservation, result);
			if (!result.hasErrors()) {
				reservationService.makePeriodic(reservation);
				status.setComplete();
				return "redirect:reservationSuccess";
			} else {
				return pageForms.get(currentPage);
			}
		} else {
			int targetPage = WebUtils.getTargetPage(request, "_target", currentPage);
			if (targetPage < currentPage) {
				return pageForms.get(targetPage);
			}
			switch (currentPage) {
			case 0:
				periodicReservationValidator.validateCourt(reservation, result);
				break;
			case 1:
				periodicReservationValidator.validateTime(reservation, result);
				break;
			case 2:
				periodicReservationValidator.validatePlayer(reservation, result);
				break;
			}
			if (!result.hasErrors()) {
				return pageForms.get(targetPage);
			} else {
				return pageForms.get(currentPage);
			}
		}
	}

	@ModelAttribute("periods")
	public Map<Integer, String> periods() {
		Map<Integer, String> periods = new HashMap<Integer, String>();
		periods.put(1, "Daily");
		periods.put(2, "Weekly");
		return periods;
	}

	@ModelAttribute("sportTypes")
	public List<SportType> populateSportTypes() {
		return reservationService.getAllSportTypes();
	}
}
