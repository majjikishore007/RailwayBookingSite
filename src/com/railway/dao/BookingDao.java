package com.railway.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.railway.entites.Train;
import com.railway.managers.BookingManager;

public class BookingDao {

	private static List<Train> trainsAvl = new ArrayList<>();
	public List<Train> getAvilableTrains(String from, String to, String date) {
				
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectrailway", "root",
				"majji@007"); Statement stmt = conn.createStatement();) {
			String query = "SELECT t.name, t.train_no from train t where t.source ='" + from + "'  and t.destination ='"
					+ to + "'";
			System.out.println("query: " + query);
			ResultSet rs = stmt.executeQuery(query);
			trainsAvl.clear();
			while (rs.next()) {
				String name = rs.getString("name");
				int train_no = rs.getInt("train_no");

				Train train = BookingManager.getInstance().createTrain(train_no, name, from, to, null, null,0);

				trainsAvl.add(train);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return trainsAvl;

	}

	public Train getTrain(int id) {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectrailway", "root",
				"majji@007"); Statement stmt = conn.createStatement();) {
			String query = "SELECT t.name, t.source,t.destination, t.arrival_time,t.departure_time ,t.fare from train t where t.train_no= "
					+ id + " ;";
			System.out.println("query: " + query);
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String name = rs.getString("name");
				String from = rs.getString("source");
				String to = rs.getString("destination");
				Time arrivalTime = rs.getTime("arrival_time");
				Time departureTime = rs.getTime("departure_time");
				double fare=rs.getDouble("fare");
				Train train = BookingManager.getInstance().createTrain(id, name, from, to, arrivalTime, departureTime,fare);
				return train;
			}
		

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
