package colarinhobranco.controller;

import java.util.HashMap;
import java.util.Map;

import colarinhobranco.dao.CommentDao;
import colarinhobranco.dao.NewsDao;
import colarinhobranco.daoimpl.CommentDaoImpl;
import colarinhobranco.daoimpl.NewsDaoImpl;
import colarinhobranco.model.Comment;
import colarinhobranco.model.News;

public class SaveCommentController implements ControllerBase
{
	private Map<String, String[]> contextObjectIn;
	private Map<String, Object> contextObjectOut;
	private NewsDao newsDao;
	private CommentDao comDao;
	
	public SaveCommentController(Map<String, String[]> contextObject)
	{
		this.contextObjectIn = contextObject;
		this.newsDao = new NewsDaoImpl();
		this.comDao = new CommentDaoImpl();
		
	}

	@Override
	public Map<String, Object> run() 
	{
		
		int id = Integer.parseInt(contextObjectIn.get("newsId")[0]);
		News news = newsDao.get(id);
		
		Comment comment = new Comment();
		comment.setComment(contextObjectIn.get("comment")[0]);
		comment.setNews(news);
		comDao.salvar(comment);
		
		return new HashMap<String, Object>();
	}

}
