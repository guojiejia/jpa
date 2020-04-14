package com.example.Jpa.Practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Jpa.Practice.dao.GoodsDao;
import com.example.Jpa.Practice.dao.UserDao;
import com.example.Jpa.Practice.entity.Goods;
import com.example.Jpa.Practice.entity.User;

@Service
public class JpaPracticeService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private GoodsDao goodsDao;
	
	public User findUserByUserId (String userId){
		User user = new User();
		user = userDao.findUserByUserId(userId);
		return user;
	}
	
	public int updateGoodsPriceByGoodsId(String price, Long goodsId, Long version) {
		return goodsDao.updateGoodsPriceByGoodsId(price, goodsId, version);
	}
}
