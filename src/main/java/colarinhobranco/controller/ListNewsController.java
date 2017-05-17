package colarinhobranco.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import colarinhobranco.dao.NewsDao;
import colarinhobranco.daoimpl.NewsDaoImpl;
import colarinhobranco.model.News;

public class ListNewsController implements ControllerBase
{
	private Map<String, String[]> contextObjectIn;
	private Map<String, Object> contextObjectOut;
	private NewsDao dao;
	
	public ListNewsController(Map<String, String[]> contextObject)
	{
		this.contextObjectIn = contextObject;
		this.dao = new NewsDaoImpl();
	}

	@Override
	public Map<String, Object> run() 
	{
		contextObjectOut = new HashMap<String, Object>();
		
		List<News> news = dao.findAll();
		contextObjectOut.put("news", news);
		return contextObjectOut;

	}

}
