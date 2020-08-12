package com.railway.utill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class SendSms {
	public static void main(String[] args) {
		// Prepare Url
		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;
		// Send SMS API
		String mainUrl = "http://indianrailapi.com/api/v2/TrainBetweenStation/apikey/03f05ab290c2d1901211797eef250077/From/Mumbai CST/To/Bhubaneswar";

		try {
			// prepare connection
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			// reading response
			String response;
			while ((response = reader.readLine()) != null)
				// print response
				System.out.println(response);
			// finally close connection
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
