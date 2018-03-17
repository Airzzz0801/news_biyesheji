package com.news.controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.ObjectInputStream.GetField;
import java.nio.file.Path;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebParam.Mode;
import javax.print.attribute.Size2DSyntax;
import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.news.common.Pager;
import com.news.common.uploadzp;
import com.news.entity.Catalog;
import com.news.entity.News;
import com.news.service.CatalogService;
import com.news.service.NewsService;
import com.sun.mail.iap.Literal;

@Controller
public class BrowseNewsPagingController {
	
	@Resource
	CatalogService catalogservice;
	@Resource
	NewsService newsservice;
	@RequestMapping("list")
	@ResponseBody
	public List<News> getby(HttpServletRequest request){
		List<News> news = newsservice.getnewsby(request.getParameter("sort"),request.getParameter("order"));
		return news;
	}
	@RequestMapping("browseNewsPaging")
	public String tocatalognews(HttpServletRequest request,ModelMap map){
		Pager pager = new Pager(Integer.parseInt(request.getParameter("curragePage")), newsservice.getLimitNews(null,null, Integer.parseInt(request.getParameter("catalogid")), null).size(),Integer.parseInt(request.getParameter("catalogid")));
		map.put("curragePage",pager.getCurrentPage());
		map.put("totalPage", pager.getTotalPage());
		map.put("catalog", pager.getCatalogid());
		map.put("newsid", request.getParameter("newsid"));
		List<Catalog> catal = catalogservice.getAllCatalogs();
		List<News> news = newsservice.getLimitNews((pager.getCurrentPage()-1)*pager.getPageSize(),pager.getPageSize(),Integer.parseInt(request.getParameter("catalogid")),null);
		List<News> news1;
		if(request.getParameter("newsid")==null)
			news1 = newsservice.getLimitNews(null,1, Integer.parseInt(request.getParameter("catalogid")), null);
		else news1 = newsservice.getLimitNews(null,1,null,Integer.valueOf(request.getParameter("newsid")));
		String news2 = new String();
		try {
			FileInputStream in = new FileInputStream(request.getServletContext().getRealPath("/images")+"//"+news1.get(0).getNews());
			InputStreamReader inp = new InputStreamReader(in,"utf-8");
			BufferedReader br = new BufferedReader(inp); 
	        String line = null; 
	        while ((line = br.readLine()) != null) { 
	            news2 += line; 
	            news2 += "\r\n"; // 补上换行符 
	        } 
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("catalogs", catal);
		map.put("news", news);
		map.put("news1", news1.get(0));
		map.put("text", news2);
		return"browseNewsPaging";
	}
	
	@RequestMapping("changeNews")
	public String changeNews(@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn,@RequestParam(required = false,defaultValue = "10",value = "size")Integer size,ModelMap map)
	{
//		List<News> news = newsservice.getLimitNews(null,30,null,null);
//		map.put("news", news);
		//引入分页查询，使用PageHelper分页功能  
	    //在查询之前传入当前页，然后多少记录  
	    PageHelper.startPage(pn,size);  
	    //startPage后紧跟的这个查询就是分页查询  
	    List<News> emps = newsservice.getAllNews();  
	    //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以  
	    PageInfo pageInfo = new PageInfo<>(emps,5);  
	    //pageINfo封装了分页的详细信息，也可以指定连续显示的页数  
	    map.put("pageInfo",pageInfo);  
		return "admin";
	}
	
	@RequestMapping("addNew")
	public String addNew(ModelMap map){
		List<Catalog> catalogs = catalogservice.getAllCatalogs();
		map.put("catalogs", catalogs);
		return "addNew";
	}
	
	@RequestMapping("addNew_success")
	public String addNew_success(@RequestParam("file") MultipartFile file ,HttpServletRequest request,ModelMap map){
		News news = new News();
		String path = request.getSession().getServletContext().getRealPath("/images");
		String image1 = new String(new String().valueOf(System.currentTimeMillis()));
		File targetFile = new File(path,image1+".jpg");
		if(!targetFile.exists()){
			targetFile.mkdirs();
		}
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Catalog catalog1 =new Catalog();
		String news1 = request.getParameter("news");
		try{
			InputStream in = new ByteArrayInputStream(news1.getBytes("utf-8"));
			OutputStream os = new FileOutputStream(path+"//"+image1+".eee");
			//文件拷贝    
			byte flush[]  = new byte[1024];
			int len = 0;
			while(0<=(len=in.read(flush))){
				os.write(flush, 0, len);
			}
			//关闭流的注意 先打开的后关
			os.close();
			in.close();
			news.setFlag(request.getParameter("flag"));
			catalog1.setCatalogid((Integer.valueOf(request.getParameter("catalog"))));
			news.setImage(image1+".jpg");
			news.setOrigin(request.getParameter("origin"));
			news.setNewsname(request.getParameter("newsname"));
			news.setCatalog(catalog1);
			java.util.Date date = new java.util.Date();
			Timestamp timeStamp = new Timestamp(date.getTime());
			news.setDate(timeStamp);
			news.setNews(image1+".eee");
		}catch(Exception e){
			e.printStackTrace();
			return "addNew_error";
		}
		if(newsservice.addnews(news)!=null){
			return "addNew_success";
		}else return"addNew_error";
	}
	
	@RequestMapping("changeNew_success")
	public String changeNew_success(@RequestParam("file") MultipartFile file ,HttpServletRequest request,ModelMap map){
		News news = new News();
		String image1 = new String(new String().valueOf(System.currentTimeMillis()));
		String path = request.getSession().getServletContext().getRealPath("/images");
		String image = request.getParameter("image");
		if (file!=null) {
		File targetFile = new File(path,image1+".jpg");
		if(!targetFile.exists()){
			targetFile.mkdirs();
		}
		try {
			file.transferTo(targetFile);
			image = image1+".jpg";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		}
		Catalog catalog1 =new Catalog();
		String news1 = request.getParameter("news");
		try{
			InputStream in = new ByteArrayInputStream(news1.getBytes("utf-8"));
			OutputStream os = new FileOutputStream(path+"//"+image1+".eee");
			//文件拷贝    
			byte flush[]  = new byte[1024];
			int len = 0;
			while(0<=(len=in.read(flush))){
				os.write(flush, 0, len);
			}
			//关闭流的注意 先打开的后关
			os.close();
			in.close();
		}catch(Exception e){
			e.printStackTrace();
			return "changeNew_error";
		}
		news.setFlag(request.getParameter("flag"));
		news.setId(Integer.valueOf(request.getParameter("id")));
		catalog1.setCatalogid((Integer.valueOf(request.getParameter("catalog"))));
		news.setImage(image);
		news.setOrigin(request.getParameter("origin"));
		news.setNewsname(request.getParameter("newsname"));
		news.setCatalog(catalog1);
		Date d1 = new Date(request.getParameter("time"));
		news.setDate(d1);
		news.setNews(image1+".eee");
		try {
			Integer aString = newsservice.changenews(news);
				return "changeNew_success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return"changeNew_error";
		}
	}
	
	@RequestMapping("changeNew")
	public String changeNew(HttpServletRequest request,ModelMap map)
	{
		List<News> news = newsservice.getLimitNews(null, 1, null, Integer.valueOf(request.getParameter("newsid")));
		map.put("newsname", news.get(0).getNewsname());
		List<Catalog> catalogs = catalogservice.getAllCatalogs();
		map.put("catalogs", catalogs);
		String news2 = new String();
		try {
			FileInputStream in = new FileInputStream(request.getServletContext().getRealPath("/images")+"//"+news.get(0).getNews());
			InputStreamReader inp = new InputStreamReader(in,"utf-8");
			BufferedReader br = new BufferedReader(inp); 
	        String line = null; 
	        while ((line = br.readLine()) != null) { 
	            news2 += line; 
	            news2 += "\r\n"; // 补上换行符 
	        } 
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("newsid", news.get(0).getId());
		map.put("news", news2);
		map.put("date", news.get(0).getDate());
		map.put("flag", news.get(0).getFlag());
		map.put("image",news.get(0).getImage());
		map.put("origin", news.get(0).getOrigin());
		map.put("catalog", news.get(0).getCatalog().getCatalogid());
		return "changeNew";
	}
	
	@RequestMapping("deleteNew")
	public String deleteNew(HttpServletRequest request)
	{
		Integer id = Integer.valueOf(request.getParameter("newsid"));
		try {
			newsservice.deletebyid(id);
			return "deleteNew_success";
		} catch (Exception e) {
			return"deleteNew_error";
		}
	}
}
