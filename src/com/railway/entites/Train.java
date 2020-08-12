package com.railway.entites;

import java.sql.Time;

public class Train {
	@Override
	public String toString() {
		return "Train [id=" + id + ", name=" + name + ", from=" + from + ", to=" + to + ", arrivalTime=" + arrivalTime
				+ ", departureTime=" + departureTime + ", fare=" + fare + "]";
	}

	private int id;
	private String name;
	private String from;
	private String to;
	private Time arrivalTime;
	private Time departureTime;
	private double fare;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public Time getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Time getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

}




