package filters;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/show")
public class AccessFilter extends HttpFilter {
       
	private static final long serialVersionUID = 1L;


	public AccessFilter() {
        super();
    }

	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest rq = (HttpServletRequest)request;
		HttpServletResponse rp = (HttpServletResponse)response;
		
		Cookie cookies[] = rq.getCookies();
		boolean ifExist = false;
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("myCookie")) {
					ifExist = true;
				}
			}		
		}
			
    	if (!ifExist) {
    		PrintWriter out = response.getWriter().append("<html><body><h3>Nqmate dostap!</h3></body></html>");
		} else {
    		chain.doFilter(request, response);
		}	
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}
