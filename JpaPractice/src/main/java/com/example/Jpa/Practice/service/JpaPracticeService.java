package com.example.Jpa.Practice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Jpa.Practice.dao.OrderDetailDao;
import com.example.Jpa.Practice.dao.OrderFormDao;
import com.example.Jpa.Practice.dao.UserDao;
import com.example.Jpa.Practice.entity.OrderForm;
import com.example.Jpa.Practice.entity.OrderDetail;
import com.example.Jpa.Practice.entity.User;

@Service
public class JpaPracticeService {

	@Autowired
	private UserDao userDao;
	
	public List<User> findUserByUserId (String userId){
		List<User> userList = new ArrayList<User>();
		userList = userDao.findUserByUserId(userId);

		return userList;
	}
}
