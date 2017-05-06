/**
 * 
 */
package colarinhobranco.commands;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Delano Jr
 *
 */
public class CommandSaveServlet implements CommandFrontController {

	@Override
	public void dispatcher(HttpServletRequest request, HttpServletResponse response) {

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/news/save");

		try {
			requestDispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
