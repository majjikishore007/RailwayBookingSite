package com.railway.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.railway.managers.UserManager;
import com.railway.utill.StringUtil;

/**
 * Servlet implementation class Authintation
 */
@WebServlet(urlPatterns = { "/auth", "/auth/login", "/auth/logout" })
public class Authintation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Authintation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("servletpath in authintication " + request.getServletPath());

		if (!request.getServletPath().contains("logout")) {
//			login
			request.getRequestDispatcher("/login.jsp").forward(request, response);

		}

		else {
//			logout
			System.out.println("logout");
			request.getSession().invalidate();
			request.getRequestDispatcher("/welcome.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		if (request.getServletPath().contains("/auth")) {
			System.out.println("servletpath  " + request.getServletPath());
			System.out.println("inside do get userId" + request.getSession().getAttribute("userId"));

			System.out.println(request.getParameter("email") + "  " + request.getParameter("password"));
			String email = request.getParameter("email");
			String password = StringUtil.encodePassword(request.getParameter("password"));

			Long userId = UserManager.getInstance().authenticate(email, password);
			System.out.println("userID " + userId);
			if (userId != -1) {
				System.out.println("userID   inside session " + userId);
				HttpSession session = request.getSession();
				session.setAttribute("userId", userId);

				if (request.getSession().getAttribute("userId") != null) {

//				     request.setAttribute("user", userId);
					dispatcher = request.getRequestDispatcher("/Booking");

				}	
					
			}
		}
		dispatcher.forward(request, response);
	}

}
