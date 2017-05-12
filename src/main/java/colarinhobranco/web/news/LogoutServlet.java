package colarinhobranco.web.news;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import colarinhobranco.dao.UserDao;
import colarinhobranco.daoimpl.UserDaoImpl;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

private UserDao userDao = new UserDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Cookie cookie = new Cookie("TOKEN", null);
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/login.jsp");
		requestDispatcher.forward(req, resp);
		
		//super.doGet(req, resp);
	}
}
