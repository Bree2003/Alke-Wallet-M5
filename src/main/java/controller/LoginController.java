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


public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get parameters
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDAO userDAO = new UserDAOImpl();
		RequestDispatcher dispatcher = null; 
		
		//get the user
		User user = userDAO.loginUser(email, password);
		
		if(user != null) {
			// create session for the user, We set true so that one is created if it does not find one
			HttpSession session = request.getSession(true);
			// keep the id of the user
			session.setAttribute("id", user.getId());
			response.sendRedirect("home");
		} else {	
			request.setAttribute("status", "failed");
			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
