package com.faisal.court.domain;

import java.beans.PropertyEditorSupport;

import com.faisal.court.service.ReservationService;

public class SportTypeEditor extends PropertyEditorSupport{
	
	
	private ReservationService reservationService;
	
	public SportTypeEditor(ReservationService reservationService){
		System.out.println("Initializing SportTypeEditor");
		this.reservationService=reservationService;
	}
	
	public void setAsText(String text) throws IllegalArgumentException{
		System.out.println("Running setTextAs from SportsType");
		int sportTypeId=Integer.parseInt(text);
		SportType sportType=reservationService.getSportType(sportTypeId);
		setValue(sportType);
	}
	
}
