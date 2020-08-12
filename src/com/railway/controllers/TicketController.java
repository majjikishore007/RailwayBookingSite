package com.railway.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.railway.entites.Train;
import com.railway.managers.BookingManager;
import com.railway.managers.UserManager;
import com.railway.utill.StringUtil;

/**
 * Servlet implementation class TicketController
 */

@WebServlet(urlPatterns = { "/ticketController", "/ticketController/search" })
public class TicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TicketController() {
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

		if (request.getServletPath().contains("search")) {
			System.out.println("servletpath search .. " + request.getServletPath());
			String from = request.getParameter("from");
			String to = request.getParameter("to");
			String date =request.getParameter("date");
				System.out.println("date "+date);
			String uid = request.getParameter("uid");
				System.out.println(Integer.parseInt(uid)+" userId ....");

			List<Train> trainsAvl = BookingManager.getInstance().viewAvialabliTrains(from, to, date);
			System.out.println("length " + trainsAvl.size());
				System.out.println(trainsAvl);
			request.setAttribute("trains", trainsAvl);
			dispatcher = request.getRequestDispatcher("/viewavl.jsp");
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
