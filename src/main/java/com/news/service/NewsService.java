package com.news.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.news.dao.NewsDao;
import com.news.entity.News;

@Service
public class NewsService {

	@Resource
	NewsDao newsDao;

	public List<News> getLimitNews(Integer begin,Integer size, Integer catid, Integer newsid) {
		// TODO Auto-generated method stub
		return newsDao.getLimitNews(begin,size,catid,newsid);
	}

	public Integer addnews(News news) {
		// TODO Auto-generated method stub
		return newsDao.addnews(news);
		
	}

	public Integer changenews(News news) {
		// TODO Auto-generated method stub
		return newsDao.changenews(news);
	}

	public Integer deletebyid(Integer id) {
		// TODO Auto-generated method stub
		return newsDao.deletebyid(id);
	}
}
