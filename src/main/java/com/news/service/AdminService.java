package com.news.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.news.dao.AdminDao;
import com.news.entity.Admin;

@Service
public class AdminService {
@Resource
	AdminDao adminDao;
	public List<Admin> getAllAdmins() {
		return adminDao.getAllAdmins();
	}
	public Admin findByUsername(String username) {
		// TODO 自动生成的方法存根
		return adminDao.findByUsername(username);
	}

}
