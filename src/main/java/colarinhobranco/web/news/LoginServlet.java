package colarinhobranco.web.news;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import colarinhobranco.model.User;


import colarinhobranco.dao.UserDao;
import colarinhobranco.daoimpl.UserDaoImpl;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private UserDao userDao = new UserDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/login.jsp");
		requestDispatcher.forward(req, resp);
		
		//super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		User user = (User) userDao.get(req.getParameter("login"));
		if (user != null)
		{
			if (user.getSenha().equals(req.getParameter("senha")))
			{ 
				Cookie cookie; 
				cookie = new Cookie("TOKEN", req.getRequestedSessionId());
				resp.addCookie(cookie);

				
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("/news/list");
				requestDispatcher.forward(req, resp);
			}
		}
		else
		{
			doGet(req, resp);
		}
		
	}
	
	private boolean checkToken(HttpServletRequest req)
	{
		boolean hasToken = false;
		
		for (Cookie c : req.getCookies())
		{
			hasToken = c.getName().equals("TOKEN") ? true : false;
			if (hasToken)
				break;
		}
		
		return hasToken;
	}
	
	
	private Cookie getToken(HttpServletRequest req)
	{
		Cookie token = null;
		
		for (Cookie c : req.getCookies())
		{
			token = c.getName().equals("TOKEN") ? c : null;
			if (token != null)
				break;
		}
		
		return token;
	}
}
