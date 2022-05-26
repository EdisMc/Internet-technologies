package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Student;
import repository.Repository;


@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Repository repository;
	
	
   
    @Override
	public void init(ServletConfig config) throws ServletException {
		repository.getInstance();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String facultyNumber = request.getParameter("faculty-number");
		String name = request.getParameter("faculty-name");
		String course = request.getParameter("course");
		String specialty = request.getParameter("specialty");
		String language = request.getParameter("language");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if (facultyNumber.isEmpty() || facultyNumber == null || name.isEmpty() || name == null || course.isEmpty() 
				|| course == null || specialty.isEmpty() || specialty == null || language.isEmpty() || language == null) {
			out.print("<p> Не сте въвели всички полета. </p>");
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.include(request, response);
		} else {
			Student student = new Student(facultyNumber, name, course, specialty, language);
			if (repository.getStudentByFN(facultyNumber) == null) {
				repository.addStudent(student);
				//response.sendRedirect("profile");

				HttpSession oldSession = request.getSession(false);
				if (oldSession != null) {
					oldSession.invalidate();
				}
				
				HttpSession newSession = request.getSession();
				newSession.setAttribute("loggedStudent", student);
				
				RequestDispatcher rd = request.getRequestDispatcher("/StudentProfile.jsp");
				rd.forward(request, response);
			} else {
				out.print("<p> Студентът вече се е регистрирал </p>");
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.include(request, response);
			}
		}
	}

}
