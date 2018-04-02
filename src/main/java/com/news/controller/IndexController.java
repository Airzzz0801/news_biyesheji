package com.news.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.news.entity.Catalog;
import com.news.entity.News;
import com.news.service.CatalogService;
import com.news.service.NewsService;

@Controller
public class IndexController {
	private Integer size = 10;
	
	@Resource
	NewsService newsService;
	@Resource
	CatalogService catalogService;
	@RequestMapping("index")
	public String toindex(HttpServletRequest request,ModelMap map){
		List<News> news = newsService.getLimitNews(null,size,null,null);
		List<News> tongzhi = newsService.getLimitNews(null,size,3,null);
		List<News> rencai = newsService.getLimitNews(null,size,4,null);
		List<News> xueshu = newsService.getLimitNews(null,size,5,null);
		List<Catalog> catalogs = catalogService.getAllCatalogs();
		map.put("news", news);
		map.put("tongzhi", tongzhi);
		map.put("catalogs", catalogs);
		map.put("rencai", rencai);
		map.put("xueshu", xueshu);
		return"index";
	}
	@RequestMapping("test")
	public String totest() {
		return "test";
	}
/*	 @RequestMapping("/testResponseEntity")
	    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
	        byte[] body=null;
	        ServletContext sc=session.getServletContext();
	        InputStream in=sc.getResourceAsStream("/images/黑色沙漠第十五职业-兰觉醒.mp4");
	        body=new byte[in.available()];
	        in.read(body);

	        HttpHeaders headers=new HttpHeaders();
	        headers.add("Content-Disposition","attachment;filename=黑色沙漠第十五职业-兰觉醒.mp4");

	        HttpStatus statusCode=HttpStatus.OK;

	        ResponseEntity<byte[]> response=new ResponseEntity<byte[]>(body,headers,statusCode);
	        return response;
	    }*/
	    
	    @RequestMapping("/download")
	    public ResponseEntity<byte[]> ResponseEntity(HttpSession session,HttpServletRequest request) throws IOException {
	        String file = request.getParameter("download");
	    	byte[] body=null;
	        ServletContext sc=session.getServletContext();
	        InputStream in=sc.getResourceAsStream("/download/"+file);
	        body=new byte[in.available()];
	        in.read(body);

	        HttpHeaders headers=new HttpHeaders();
	        headers.add("Content-Disposition","attachment;filename="+file);

	        HttpStatus statusCode=HttpStatus.OK;

	        ResponseEntity<byte[]> response=new ResponseEntity<byte[]>(body,headers,statusCode);
	        return response;
	    }
}
