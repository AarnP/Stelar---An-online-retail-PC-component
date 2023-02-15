package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.User;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogInServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("logout")) {
			HttpSession session = request.getSession();
			session.removeAttribute("user");
			response.sendRedirect("home.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get username + password from request parameter
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			// go to DB and get USER with username + password
			UserDAO userDAO = new UserDAO();
			User user;

			user = userDAO.getUserByUsernameAndPassword(username, password);

			// Get session (request Cookie JSESSION)
			HttpSession session = request.getSession();
			// Nhet user vo trong session (tomcat)
			session.setAttribute("user", user);

			// If username and password exist in DB, redirect SUCCESS
			if (user != null) {
//			request.setAttribute("user", user);
				RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
				dispatcher.forward(request, response);
				// response.sendRedirect("LogInSuccess.jsp");
			} else {
				response.sendRedirect("LogInFail.jsp");
			}
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
