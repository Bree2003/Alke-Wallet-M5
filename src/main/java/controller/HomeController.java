package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;


import java.io.IOException;

import dao.UserDAO;
import dao.UserDAOImpl;


/**
 * Servlet implementation class HomeController
 */
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	RequestDispatcher dispatcher = null;
	UserDAO userDAO = new UserDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// bring the user save in the session
		HttpSession session = request.getSession(false);

		// if not exists session
		if(session == null) {
			//redirect to login
			response.sendRedirect("login.jsp");
		} else {
			// bring the user id
			Object id = session.getAttribute("id");
			
			// if not exists id
			if(id == null) {
				//redirect login
				response.sendRedirect("login");
			} else {
						
				int id2 = (int) session.getAttribute("id");
				User user = userDAO.getUserByID(id2);
				session.setAttribute("user", user);
				dispatcher = request.getRequestDispatcher("home.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get parameters
				String operation = request.getParameter("operation");
				Double amount = Double.parseDouble(request.getParameter("amount"));
				
				int isSuccessful;
				
				// get session
				HttpSession session = request.getSession(false);
				int id = (int) session.getAttribute("id");
				
				// obtener usuario
				User user = (User) session.getAttribute("user");
		
				//saber si es depositar o retirar
				if(operation.equals("deposit")) {
					isSuccessful = userDAO.depositMoney(amount, id);
					if(isSuccessful > 0) {
						session.setAttribute("status", "success");
						response.sendRedirect("home");
					} else {
						session.setAttribute("status", "failed");
						response.sendRedirect("home");
					}
				} else if (operation.equals("withdraw")) {
					if(user.getBalance() >= amount) {
						isSuccessful = userDAO.withdrawMoney(amount, id);
						if(isSuccessful > 0) {
							session.setAttribute("status", "success");
							response.sendRedirect("home");
						} else {
							session.setAttribute("status", "failed");
							response.sendRedirect("home");
						}
					} else {
						session.setAttribute("status", "failed");
						response.sendRedirect("home");
					}
					
				}
	}
			
		
		
		
	


}
