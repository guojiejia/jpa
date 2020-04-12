package com.example.Jpa.Practice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Jpa.Practice.dao.orderDao;
import com.example.Jpa.Practice.dao.orderDetailDao;
import com.example.Jpa.Practice.dao.userDao;
import com.example.Jpa.Practice.entity.Order;
import com.example.Jpa.Practice.entity.OrderDetail;
import com.example.Jpa.Practice.entity.User;

@Service
public class JpaPracticeService {

	@Autowired
	private orderDetailDao orderDetailDao;
	
	@Autowired
	private userDao userDao;
	
	@Autowired
	private orderDao orderDao;
	
	public List<OrderDetail> findDetails (Integer userId){
		List<OrderDetail> listOrdersDetail = new ArrayList<OrderDetail>();
		Optional<User> user = userDao.findById(userId);
		List<Optional<Order>> listOrder = orderDao.findAllByUser(user);
		for (Optional<Order> item : listOrder) {
			listOrdersDetail.addAll(orderDetailDao.findAllByOrder(item));
		}
		return listOrdersDetail;		
	}
	
//	public List<ordersDetail> editoOrderDetails(Integer userId){
//		
//		return null;
//	}
	

}
