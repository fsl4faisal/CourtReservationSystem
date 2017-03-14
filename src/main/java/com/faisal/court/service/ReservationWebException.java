package com.faisal.court.service;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class ReservationWebException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String textMessage;
	Date date;
	String message;
	
	public ReservationWebException(String textMessage,Date date,String message){
		this.textMessage=textMessage;
		this.date=date;
		this.message=message;
	}
	public ReservationWebException(){}
}
