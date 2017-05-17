package colarinhobranco.web.news;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import colarinhobranco.controller.ControllerBase;
import colarinhobranco.controller.ListNewsController;
import colarinhobranco.controller.SaveCommentController;
import colarinhobranco.controller.ShowNewsController;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/")
public class DispatcherServlet extends HttpServlet {
	Map<String, String[]> ContextObject;
	ControllerBase applicationController;
	private String imagesFolder;

	@Override
	public void init() {
		// setImagesFolder(getServletContext().getInitParameter("images-folder"));
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContextObject = new HashMap<String, String[]>();
		request.setCharacterEncoding("UTF-8");

		if (request.getParameterMap().size() > 0) {
			for (Map.Entry<String, String[]> par : request.getParameterMap().entrySet()) {
				ContextObject.put(par.getKey(), par.getValue());
			}
		}

		switch (request.getServletPath()) {
		case "/":
			applicationController = new ListNewsController(ContextObject);
			atualizaRequisicao(applicationController.run(), request);
			request.getRequestDispatcher("/pages/news/list.jsp").forward(request, response);
			break;

		case "/news/list":
			applicationController = new ListNewsController(ContextObject);
			atualizaRequisicao(applicationController.run(), request);
			request.getRequestDispatcher("/pages/news/list.jsp").forward(request, response);
			break;

		case "/news/show":
			if (request.getMethod().equals("GET"))
				applicationController = new ShowNewsController(ContextObject);
			else
				applicationController = new SaveCommentController(ContextObject);
			atualizaRequisicao(applicationController.run(), request);
			request.getRequestDispatcher("/pages/news/show.jsp").forward(request, response);
			break;

		}

	}

	public void atualizaRequisicao(Map<String, Object> atributos, HttpServletRequest request) {
		if (atributos.size() > 0) {
			for (Map.Entry<String, Object> atrib : atributos.entrySet()) {
				request.setAttribute(atrib.getKey(), atrib.getValue());
			}
		}
	}

	public void setImagesFolder(String imagesFolder) {
		this.imagesFolder = imagesFolder;
	}
}
