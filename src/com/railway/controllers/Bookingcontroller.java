package com.railway.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.railway.entites.Booking;
import com.railway.managers.PaymentManager;

/**
 * Servlet implementation class Bookingcontroller
 */

@WebServlet(urlPatterns = { "/Booking", "/Booking/status" })
public class Bookingcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Bookingcontroller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		if (request.getServletPath().contains("/Booking")) {
			HttpSession session = request.getSession();
//			long userId=(long) session.getAttribute("userId");
			if (request.getSession().getAttribute("userId") != null) {

//			     request.setAttribute("user", userId);
				dispatcher = request.getRequestDispatcher("/searchtrains.jsp");

			}
		}
		if (request.getServletPath().contains("status")) {
			System.out.println(request.getServletPath() + "status ");
			String uid = request.getParameter("uid");
			System.out.println(Integer.parseInt(uid) + " userId ....");
			long userId = Long.parseLong(uid);
			List<Booking>bookedTrains = PaymentManager.getInstance().checkStatus(userId);
			if (bookedTrains != null) {
		
				System.out.println(bookedTrains);
				request.setAttribute("booking", bookedTrains);
				dispatcher = request.getRequestDispatcher("/bill.jsp");
			}

		}

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
