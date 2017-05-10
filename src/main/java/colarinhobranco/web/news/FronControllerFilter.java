package colarinhobranco.web.news;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import colarinhobranco.dao.UserDao;
import colarinhobranco.daoimpl.UserDaoImpl;
import colarinhobranco.model.User;

import javax.servlet.http.Cookie;

/**
 * Servlet Filter implementation class FronControllerFilter
 */
@WebFilter(filterName = "FrontControllerFilter", urlPatterns = { "/pages/*", "/*" })
public class FronControllerFilter implements Filter {

	private final String TOKEN = "TOKEN";
	private final String loginPath = "/login";

	
	/**
	 * Default constructor.
	 */
	public FronControllerFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		
		String path = req.getServletPath();
		
		if (!checkToken(req) || validaToken(req, req.getRequestedSessionId()))
		{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(loginPath);
			requestDispatcher.forward(request, response);
		}
		else
		{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
			requestDispatcher.forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		
		UserDaoImpl dao = new UserDaoImpl();
		//List<User> users = dao.findAll();
		//if (users.size() == 0)
		//{
			User user = new User();
			user.setLogin("user");
			user.setSenha("1234");
			dao.save(user);
		//}
		
	}
	
	
	private boolean checkToken(HttpServletRequest req)
	{
		boolean hasToken = false;
		
		for (Cookie c : req.getCookies())
		{
			hasToken = c.getName().equals(TOKEN) ? true : false;
			System.out.println("nome " + c.getName() + ", valor: " + c.getValue());
			if (hasToken)
				break;
		}
		
		return hasToken;
	}
	
	private boolean validaToken(HttpServletRequest req, String valor)
	{	
		boolean tokenOk = false;
		
		for (Cookie c : req.getCookies())
		{
			tokenOk = c.getName().equals(req.getRequestedSessionId()) ? true : false;
			if (tokenOk)
				break;
		}
		return tokenOk;
	}

}
