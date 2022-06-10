package filters;

import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter("/registration")
public class ipChecker extends HttpFilter {
       
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		//HttpServletResponse res = (HttpServletResponse) response;
		
		boolean flag = false;
		Cookie[] cookies = req.getCookies();
		if (cookies!=null) {
			for (Cookie c:cookies) {
				if(c.getName().equals("ip")) {
					request.getRemoteAddr();
				}
			}
		}
		
		if (flag) {
			RequestDispatcher rd = request.getRequestDispatcher("/show");
			rd.include(request, response);
		}
		else {
			chain.doFilter(request, response);
		}
		
	}

	
}
