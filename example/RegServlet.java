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
import models.User;
import repositories.UserCollection;
 
@WebServlet("/reg")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserCollection collection;
 
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		collection=UserCollection.getInstance();
	}
 
	/**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String name=request.getParameter("name");
		String username=request.getParameter("pname");
		String pass=request.getParameter("pass");
		String rust=request.getParameter("rust");
		String kg=request.getParameter("kg");
		PrintWriter out =response.getWriter();
		if(name==null || name.isEmpty() || username==null||username.isEmpty()||pass==null||pass.isEmpty()||rust==null||rust.isEmpty()||kg==null||kg.isEmpty()) {
			out.print("<p style='color:red' Empty fields are not allowed </p>");
			RequestDispatcher re=request.getRequestDispatcher("reg.jsp");
			re.include(request, response);
 
		}else {
			int r =Integer.parseInt(rust);
			int k=Integer.parseInt(kg);
			User user=new User(name,username,pass,r,k);
			collection.addUser(user);
			HttpSession session=request.getSession(false);
			session.setAttribute("user", user);
			out.print("<p style='color:red' Successfully registered user </p>");
			RequestDispatcher re=request.getRequestDispatcher("log.jsp");
			re.include(request, response);
 
		}
 
	}
 
}
