package colarinhobranco.web.news;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import colarinhobranco.commands.CommandFrontController;

/**
 * Servlet implementation class FrontControllerServlet
 */
@WebServlet("/*")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CommandFrontController commandFrontController = null;

	public FrontControllerServlet() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		commandFrontController = (CommandFrontController) Class
				.forName("colarinhobranco.web.news." + request.getParameter("command")).newInstance();

		commandFrontController.dispatcher(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String page = request.getRequestURI();
			System.out.println(page);

			processRequest(request, response);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
