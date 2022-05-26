package controllers;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Student;
import repository.Repository;

@WebServlet("/profile")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Repository repository;
	
	public void init(ServletConfig config) throws ServletException {
		repository = Repository.getInstance();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Student loggedStudent =  (session != null)?(Student)session.getAttribute("loggedStudent"):null;
		if (loggedStudent != null) {
			response.sendRedirect("/index.jsp");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/StudentProfile.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
