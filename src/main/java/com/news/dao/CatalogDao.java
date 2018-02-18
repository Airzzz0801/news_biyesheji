package com.news.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.news.entity.Catalog;

@Repository
public interface CatalogDao {

	List<Catalog> getAllCatalogs();

}
