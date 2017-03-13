package com.faisal.court.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.faisal.court.domain.Reservation;
import com.faisal.court.domain.SportType;

@Service
public interface ReservationService {
	public List<Reservation> query(String courtName);
	public List<Reservation> getAllReservations();
	public void make(Reservation reservation) throws ReservationNotAvailableException;	
	public List<SportType> getAllSportTypes();
	public SportType getSportType(int sportTypeId);
}
