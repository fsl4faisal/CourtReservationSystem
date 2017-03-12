package com.faisal.court.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.faisal.court.domain.Reservation;

@Service
public interface ReservationService {
	public List<Reservation> query(String courtName);
}
