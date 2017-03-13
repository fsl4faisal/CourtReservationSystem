package com.faisal.court.service;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class ReservationNotAvailableException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String courtName;
	private Date date;
	private int hour;
	
	public ReservationNotAvailableException(){}
	
	public ReservationNotAvailableException(String courtName, Date date, int hour) {
		super();
		this.courtName = courtName;
		this.date = date;
		this.hour = hour;
	}

	public String getCourtName() {
		return courtName;
	}

	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}
	
	
}
