package controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.xml.bind.JAXBException;
import org.xml.sax.SAXException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.BeautyCompetition;
import repositories.Repository;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	Repository collection;
	public void init(ServletConfig config) throws ServletException {

			collection= Repository.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/RegistrationPage.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String lastName = request.getParameter("lastName");
		String age = request.getParameter("age");
		String city = request.getParameter("city");
		
		if (name == null || name.isEmpty() || lastName == null || lastName.isEmpty() || 
				age == null || age.isEmpty() || city == null || city.isEmpty()) {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			writer.print("<html><body><p>Не са въведени всички полета! </p></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("/RegistrationPage.jsp");
			rd.include(request, response);
		}
		else {
			BeautyCompetition comp = new BeautyCompetition(name, lastName, age, city);
			collection.addParticipant(comp);
			
			Cookie myCookie = new Cookie("ip","ip");
			myCookie.setMaxAge(15); 
			response.addCookie(myCookie);
			response.sendRedirect("show");
		}
			
	}	

}