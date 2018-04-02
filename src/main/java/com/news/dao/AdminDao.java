package com.news.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.news.entity.Admin;

@Repository
public interface AdminDao {

	List<Admin> getAllAdmins();

	Admin findByUsername(String username);

}
