package com.railway.managers;

import java.sql.Time;
import java.util.List;

import com.railway.dao.BookingDao;
import com.railway.entites.Booking;
import com.railway.entites.Train;

public class BookingManager {
	private static BookingManager instance = new BookingManager();
	private static BookingDao dao = new BookingDao();

	private BookingManager() {

	}

	public static BookingManager getInstance() {
		return instance;
	}

	public Train createTrain(int id, String name, String from, String to ,Time arrivalTime,Time  departureTime,double fare) {
		Train train = new Train();
		train.setId(id);
		train.setName(name);
		train.setFrom(from);
		train.setTo(to);
		train.setArrivalTime(arrivalTime);
		train.setDepartureTime(departureTime);
		train.setFare(fare);
		return train;
	}

	
	public Booking createBooking(String from, String to, String trainName, long trainNo,
			 long userId,int pnr,double price,Time departure_time,Time arrival_time ) {
		
		Booking booking = new Booking();
		booking.setTrainName(trainName);
		booking.setPrice(price);
		booking.setPnr( pnr);
		booking.setFrom(from);
		booking.setTo(to);
		booking.setUserId(userId);
		booking.setTrainNo(trainNo);
		booking.setArrival_time(arrival_time);
		booking.setDeparture_time(departure_time);
//		booking.setDate(date);
		return booking;
	}

	

	public List<Train> viewAvialabliTrains(String from, String to, String date) {
		System.out.println("manager");
			
		return dao.getAvilableTrains(from, to, date);

	}
	public Train getTrain(int id) {
		return dao.getTrain(id);
	}
	public void cancelTicket() {

	}

	public void cheekTicketStatus() {

	}

}
