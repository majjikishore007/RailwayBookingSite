package com.railway.managers;

import java.util.List;

import com.railway.dao.UserDao;
import com.railway.entites.Booking;
import com.railway.entites.Train;

public class PaymentManager {
	private static PaymentManager instance = new PaymentManager();
	private static UserDao dao = new UserDao();

	public static PaymentManager getInstance() {
		return instance;
	}

	private PaymentManager() {

	}

	public Booking cheekOut(String email, String password, Train train) {
		
		return dao.createBooking( email, password,  train);
	}
	public List<Booking> checkStatus(long userId) {
		return dao.checkStatus(userId);
	}
}
