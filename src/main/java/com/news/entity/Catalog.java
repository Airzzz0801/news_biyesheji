package com.news.entity;

import java.util.List;

public class Catalog {

	private int catalogid;
	private String catalogname;
	private List<News> news;
	
	public List<News> getNews() {
		return news;
	}
	public void setNews(List<News> news) {
		this.news = news;
	}
	public int getCatalogid() {
		return catalogid;
	}
	public void setCatalogid(int catalogid) {
		this.catalogid = catalogid;
	}
	public String getCatalogname() {
		return catalogname;
	}
	public void setCatalogname(String catalogname) {
		this.catalogname = catalogname;
	}
	
}
