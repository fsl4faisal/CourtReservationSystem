package com.faisal.court.domain;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ReservationValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return Reservation.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("Inside ReservationValidator");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "courtName", "required.courtName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date", "required.date");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hour", "required.hour");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "player.name", "required.playerName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sportType.name", "required.sportType");

		Reservation reservation = (Reservation) target;
		Date date = reservation.getDate();
		int hour = reservation.getHour();

		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				if (hour < 8 || hour > 22)
					errors.reject("invalid.holidayHour");
			} else {
				if (hour < 9 || hour > 21)
					errors.reject("invalid.weekdayHour");
			}

		}

	}

}
