package com.railway.entites;

import java.sql.Time;

public class Booking {
	private String date;
	private long userId;
	

	private String trainName;
	private long trainNo;
	private String from;
	private String to;
	private int pnr;
	private double price;
	private Time departure_time;
	private Time arrival_time;

	public int getPnr() {
		return pnr;
	}

	public void setPnr(int pnr) {
		this.pnr = pnr;
	}

	public long getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(long trainNo) {
		this.trainNo = trainNo;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Time getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(Time departure_time) {
		this.departure_time = departure_time;
	}

	public Time getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(Time arrival_time) {
		this.arrival_time = arrival_time;
	}
	@Override
	public String toString() {
		return "Booking [date=" + date + ", userId=" + userId + ", trainName=" + trainName + ", trainNo=" + trainNo
				+ ", from=" + from + ", to=" + to + ", pnr=" + pnr + ", price=" + price + ", departure_time="
				+ departure_time + ", arrival_time=" + arrival_time + "]";
	}
}
