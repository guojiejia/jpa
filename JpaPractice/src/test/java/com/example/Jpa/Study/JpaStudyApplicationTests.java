package com.example.Jpa.Study;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Jpa.Practice.JpaPracticeApplication;
import com.example.Jpa.Practice.dao.itemDao;
import com.example.Jpa.Practice.dao.orderDao;
import com.example.Jpa.Practice.dao.orderDetailDao;
import com.example.Jpa.Practice.dao.userDao;
import com.example.Jpa.Practice.entity.Goods;
import com.example.Jpa.Practice.entity.Order;
import com.example.Jpa.Practice.entity.OrderDetail;
import com.example.Jpa.Practice.entity.User;
import com.example.Jpa.Practice.service.JpaPracticeService;


@SpringBootTest(classes = JpaPracticeApplication.class)
class JpaStudyApplicationTests {
	
	@Autowired
	private userDao userdao;
	@Autowired
	private itemDao itemDao;
	@Autowired
	private orderDetailDao orderDetailDao;
	
	@Autowired
	private JpaPracticeService jpaStudyServiceTest;
	
	@Autowired
	private orderDao ordersDao;
	
	@Test
	public void saveOrderDetail() {
		User x = new User();
		x.setUsername("testUserName");
		x.setSex("nan");
		x.setAdress("dalian");
		x.setBirthday("1993-02-02");
		userdao.save(x);
		
		Goods item1 = new Goods();
		item1.setName("茄子");
		item1.setDetail("非常好吃！！");
		item1.setPrice("50");
		item1.setCreateTime(new Date());
		itemDao.save(item1);
		
		Goods item2 = new Goods();
		item2.setName("西瓜");
		item2.setDetail("非常好吃！！");
		item2.setPrice("500");
		item2.setCreateTime(new Date());
		itemDao.save(item2);
		
		Order newOrder = new Order();
		newOrder.setCreateTime(new Date());
		newOrder.setUser(x);
		ordersDao.save(newOrder);
		
		OrderDetail newOrdersDetail1 = new OrderDetail();
		newOrdersDetail1.setItem(item1);
		newOrdersDetail1.setOrder(newOrder);
		newOrdersDetail1.setItemNum(5);
		OrderDetail newOrdersDetail2 = new OrderDetail();
		newOrdersDetail2.setItem(item2);
		newOrdersDetail2.setOrder(newOrder);
		newOrdersDetail2.setItemNum(5);
		
		orderDetailDao.save(newOrdersDetail1);
		orderDetailDao.save(newOrdersDetail2);
	}
	
	@Test
	public void findAllOrderDetail() {
		Optional<Order> newOrder = ordersDao.findById(1);		
		List<OrderDetail> findAllByOrder = orderDetailDao.findAllByOrder(newOrder);
		for(OrderDetail item : findAllByOrder) {
			System.out.println(item.getItem());
		}
		
	}
	
	
	public void testService () {
		List<OrderDetail> findDetails = jpaStudyServiceTest.findDetails(1);
		for(OrderDetail item : findDetails) {
			System.out.println(item.getItem());
		}
	}

//	@Test
//	public void findItemInfo() {
//		List<item> findAll = itemDao.findAll();		
//		System.out.println(findAll.toArray());
//	}
}
