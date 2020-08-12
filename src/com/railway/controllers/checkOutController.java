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

import com.railway.entites.Booking;
import com.railway.entites.Train;
import com.railway.managers.BookingManager;
import com.railway.managers.PaymentManager;
import com.railway.utill.StringUtil;

/**
 * Servlet implementation class checkOutController
 */

@WebServlet(urlPatterns = { "/checkOutController", "/checkOutController/checkout" ,"/checkOutController/confirm"})
public class checkOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public checkOutController() {
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
		System.out.println(request.getServletPath());
		String tid = request.getParameter("tid");
		System.out.println("trainid   " + tid);
		
		if (request.getServletPath().contains("checkout")) {
			if (tid != null) {
				int trainNo = Integer.parseInt(tid);
				Train train = BookingManager.getInstance().getTrain(trainNo);
				
				System.out.println(train);
					List<Train>t=new ArrayList<>();
					t.add(train);

				request.setAttribute("train", t);
				dispatcher = request.getRequestDispatcher("/checkout.jsp");
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
		RequestDispatcher dispatcher = null;
		System.out.println("billing "+request.getServletPath());
		String tid = request.getParameter("tid");
		System.out.println("trainid   " + tid);
		int trainNo = Integer.parseInt(tid);
		Train train = BookingManager.getInstance().getTrain(trainNo);
		if (request.getServletPath().contains("confirm")) {
			String email = request.getParameter("email");
			String password = StringUtil.encodePassword(request.getParameter("password"));
				System.out.println(email+"bill payment "+password);
					Booking booking=PaymentManager.getInstance().cheekOut(email, password, train);
					
					List<Booking>b=new ArrayList<>();
					b.add(booking);
					System.out.println(booking);
					System.out.println(b);
					request.setAttribute("booking", b);
			dispatcher = request.getRequestDispatcher("/bill.jsp");
		}
		dispatcher.forward(request, response);
	}

}
