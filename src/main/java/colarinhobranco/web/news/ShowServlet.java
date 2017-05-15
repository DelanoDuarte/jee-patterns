package colarinhobranco.web.news;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import colarinhobranco.dao.CommentDao;
import colarinhobranco.dao.NewsDao;
import colarinhobranco.daoimpl.CommentDaoImpl;
import colarinhobranco.daoimpl.NewsDaoImpl;
import colarinhobranco.model.Comment;
import colarinhobranco.model.News;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/news/show")
public class ShowServlet extends HttpServlet {

	private NewsDao newsDao = new NewsDaoImpl();
	private CommentDao commentDao = new CommentDaoImpl();
	Integer newsId = 0;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		newsId = new Integer(request.getParameter("newsId"));

		request.setAttribute("news", newsDao.get(newsId));

		request.setAttribute("comments", commentDao.buscarCommentariosPorPost(newsId));

		request.getRequestDispatcher("/pages/news/show.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String commentPost = request.getParameter("comment");
		News news = newsDao.get(newsId);

		Comment comment = new Comment(commentPost, news);

		try {
			commentDao.salvar(comment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/pages/news/show.jsp").forward(request, response);

	}

}