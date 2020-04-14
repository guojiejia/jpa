package com.example.Jpa.Practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.Jpa.Practice.entity.User;
import com.example.Jpa.Practice.service.JpaPracticeService;

@Controller
public class JpaPracticeController {
	@Autowired
	private JpaPracticeService  jpaPracticeService;
	
	@RequestMapping("get_user_info")
	public User getUserInfo(String userId) {
		User user = jpaPracticeService.findUserByUserId(userId);
		return user;
	}
	@PostMapping("update_goods_item_by_goodsId")
	public int updateGoodsPriceByGoodsId(String price, Long goodsId, Long version) {
		return jpaPracticeService.updateGoodsPriceByGoodsId(price, goodsId, version);
	}
} 
