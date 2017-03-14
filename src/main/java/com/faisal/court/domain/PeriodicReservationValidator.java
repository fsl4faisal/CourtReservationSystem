package com.faisal.court.domain;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PeriodicReservationValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return PeriodicReservation.class.isAssignableFrom(clazz);
	}
	
	
	@Override
	public void validate(Object target, Errors errors) {
		validateCourt(target,errors);
		validateTime(target,errors);
		validatePlayer(target,errors);
	}
	
	public void validateCourt(Object target,Errors errors){
		ValidationUtils.rejectIfEmpty(errors, "courtName", "required.courtName");
	}
	
	public void validateTime(Object target,Errors errors){
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fromDate", "required.fromDate");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"toDate","required.toDate");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"period","required.period");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"hour","required.hour");
	}
	
	public void validatePlayer(Object target,Errors errors){
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"player.name","required.playerName");
	}

}
