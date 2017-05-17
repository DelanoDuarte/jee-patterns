package colarinhobranco.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import colarinhobranco.dao.CommentDao;
import colarinhobranco.dao.NewsDao;
import colarinhobranco.daoimpl.CommentDaoImpl;
import colarinhobranco.daoimpl.NewsDaoImpl;
import colarinhobranco.model.Comment;
import colarinhobranco.model.News;

public class ShowNewsController implements ControllerBase
{

	private Map<String, String[]> contextObjectIn;
	private Map<String, Object> contextObjectOut;
	private NewsDao newsDao;
	private CommentDao comDao;
	
	public ShowNewsController(Map<String, String[]> contextObject)
	{
		this.contextObjectIn = contextObject;
		this.newsDao = new NewsDaoImpl();
		this.comDao = new CommentDaoImpl();
		
	}
	
	@Override
	public Map<String, Object> run() 
	{
		contextObjectOut = new HashMap<String, Object>();
		int id = Integer.parseInt(contextObjectIn.get("newsId")[0]);
		
		contextObjectOut.put("news", newsDao.get(id));
		contextObjectOut.put("comments", comDao.buscarCommentariosPorPost(id));
		
		return contextObjectOut;

	}

}
