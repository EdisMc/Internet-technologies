package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Participant;
import repositories.PartRepository;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PartRepository repository;

	
    public RegistrationServlet() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException {
    	repository = PartRepository.getInstance(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String fideID = request.getParameter("id");
		String nameSch = request.getParameter("nameSch");
		String nameNom = request.getParameter("nameNom");
		String vote = request.getParameter("vote");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if (fideID == null || fideID.isEmpty() || nameSch == null || nameSch.isEmpty() || nameNom == null || nameNom.isEmpty()) {
			out.print("<html><body><p>Не сте въвели всички полета! </p></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.include(request, response);
		} else {
			Participant participant = new Participant(fideID, nameSch, nameNom, vote);
			repository.addParticipant(participant);
			
			Cookie cookie = new Cookie("myCookie", "1");
			cookie.setMaxAge(60*60);
			response.addCookie(cookie);
			
			response.sendRedirect("show");
			
		}
	}

}
