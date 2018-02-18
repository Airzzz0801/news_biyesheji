package com.news.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.news.dao.CatalogDao;
import com.news.entity.Catalog;

@Service
public class CatalogService {
		
	@Resource
	CatalogDao catalogdao;
	
	public List<Catalog> getAllCatalogs() {
		return catalogdao.getAllCatalogs();
	}

}
