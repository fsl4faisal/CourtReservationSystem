package com.faisal.court.domain;

import java.util.Date;

public class PeriodicReservation {
	private String courtName;
	private Date fromDate;
	private Date toDate;
	private int period;
	private int hour;
	private Player player;
	private SportType sportType;
	
	public String getCourtName() {
		return courtName;
	}
	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public PeriodicReservation(){}
	public SportType getSportType() {
		return sportType;
	}
	public void setSportType(SportType sportType) {
		this.sportType = sportType;
	}
	@Override
	public String toString() {
		return "PeriodicReservation [courtName=" + courtName + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", period=" + period + ", hour=" + hour + ", player=" + player + ", sportType=" + sportType + "]";
	}
	public PeriodicReservation(String courtName, Date fromDate, Date toDate, int period, int hour, Player player,
			SportType sportType) {
		super();
		this.courtName = courtName;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.period = period;
		this.hour = hour;
		this.player = player;
		this.sportType = sportType;
	}
	
	
	
	
}
