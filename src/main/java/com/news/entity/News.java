package com.news.entity;

import java.sql.Blob;
import java.util.Date;

public class News {

private int id;
private String newsname;
private String news;
private Date date;
private String flag;
private String image;
private String origin;
private Catalog catalog;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNewsname() {
	return newsname;
}
public void setNewsname(String newsname) {
	this.newsname = newsname;
}

public String getNews() {
	return news;
}
public void setNews(String news) {
	this.news = news;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}

public String getFlag() {
	return flag;
}
public void setFlag(String flag) {
	this.flag = flag;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public String getOrigin() {
	return origin;
}
public void setOrigin(String origin) {
	this.origin = origin;
}
public Catalog getCatalog() {
	return catalog;
}
public void setCatalog(Catalog catalog) {
	this.catalog = catalog;
}

}
