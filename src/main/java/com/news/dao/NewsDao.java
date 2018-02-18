package com.news.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.news.entity.News;

@Repository
public interface NewsDao {

	List<News> getLimitNews(@Param("begin") Integer begin ,@Param("size") Integer size,@Param("catid") Integer catid,@Param("newsid")  Integer newsid);

	Integer addnews(News news);

	Integer changenews(News news);

	Integer deletebyid(Integer id);
	
}
