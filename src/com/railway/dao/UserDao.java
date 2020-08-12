package com.railway.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.railway.entites.Booking;
import com.railway.entites.Train;
import com.railway.managers.BookingManager;

public class UserDao {
	private static List<Booking> bookedTrains = new ArrayList<>();
	public long authenticate(String email, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectrailway", "root",
				"majji@007"); Statement stmt = conn.createStatement();) {
			String query = "Select user_id from User where email = '" + email + "' and password = '" + password + "'";
			System.out.println("query: " + query);
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				System.out.println(rs.getLong("user_id"));
				return rs.getLong("user_id");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}

	public Booking createBooking(String email, String password, Train train) {
		long userid = authenticate(email, password);
		System.out.println(train.getId() + " train id");
		int pnr = (int) (train.getId() + 100 + Math.random() * 2000) + 1000;
		System.out.println(train.getId() + " train id" + pnr);
		Booking booking = BookingManager.getInstance().createBooking(train.getFrom(), train.getTo(), train.getName(),
				train.getId(), userid, pnr, train.getFare(), train.getArrivalTime(), train.getDepartureTime());
		int train_no = train.getId();
		String from = train.getFrom();
		String to = train.getTo();
		Time arrivalTime = train.getArrivalTime();
		Time departureTime = train.getDepartureTime();
		double fare = train.getFare();

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectrailway", "root",
				"majji@007"); Statement stmt = conn.createStatement();) {
			String query = "INSERT INTO booking (`train_no`, `from`, `to`, `departure_time`, `arrival_time`, `user_id`, `fare`, `pnr_No`)"
					+ " values( " + train_no + ",'" + from + "','" + to + "','" + arrivalTime + "','" + departureTime
					+ "'," + userid + "," + fare + " ," + pnr + ")";
			System.out.println("query: " + query);
			stmt.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return booking;

	}

	public  List<Booking> checkStatus(long userId) {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectrailway", "root",
				"majji@007"); Statement stmt = conn.createStatement();) {
			String query = "select b.train_no,b.from,b.to,b.departure_time,b.arrival_time,b.pnr_No,b.fare,t.name from booking b join train t where  t.train_no=b.train_no  "
					+ " and   b.user_id=" + userId;
			System.out.println("query: " + query);
			ResultSet rs = stmt.executeQuery(query);
			bookedTrains.clear();
			while (rs.next()) {
				int pnrNo = rs.getInt("pnr_No");
				String trainName = rs.getString("name");
				long train_no = rs.getInt("train_no");
				String from = rs.getString("from");
				String to = rs.getString("to");
				Time arrivalTime = rs.getTime("arrival_time");
				Time departureTime = rs.getTime("departure_time");
				double fare = rs.getDouble("fare");
				Booking booking = BookingManager.getInstance().createBooking(from, to, trainName, train_no, userId,
						pnrNo, fare, departureTime, arrivalTime);
				bookedTrains.add(booking);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookedTrains;
	}
}
