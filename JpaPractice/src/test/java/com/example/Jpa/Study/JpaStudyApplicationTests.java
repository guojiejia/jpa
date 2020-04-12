package com.example.Jpa.Study;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Jpa.Practice.JpaPracticeApplication;
import com.example.Jpa.Practice.dao.GoodsDao;
import com.example.Jpa.Practice.dao.OrderFormDao;
import com.example.Jpa.Practice.dao.OrderDetailDao;
import com.example.Jpa.Practice.dao.UserDao;
import com.example.Jpa.Practice.entity.Goods;
import com.example.Jpa.Practice.entity.OrderForm;
import com.example.Jpa.Practice.entity.OrderDetail;
import com.example.Jpa.Practice.entity.User;
import com.example.Jpa.Practice.service.JpaPracticeService;


@SpringBootTest(classes = JpaPracticeApplication.class)
class JpaStudyApplicationTests {

	@Autowired
	private GoodsDao goodsDao;

	@Autowired
	private OrderDetailDao orderDetailDao;
	
	@Autowired
	private OrderFormDao orderFormDao;
	
	@Autowired
	private UserDao userdao;
	
	@Autowired
	private JpaPracticeService jpaPracticesServiceTest;
	
	@Test
	public void addUser() {
		// goods_book
		Goods g0 = new Goods();
		g0.setColour("red");
		g0.setDetail("good0 details");
		g0.setGoodsId((long) 123);
		g0.setName("book");
		g0.setPrice("998");
		goodsDao.save(g0);
		
		// goods_book
		Goods g1 = new Goods();
		g1.setColour("green");
		g1.setDetail("good1 details");
		g1.setGoodsId((long) 456);
		g1.setName("pc");
		g1.setPrice("1020");
		goodsDao.save(g1);
		
		// orderDetail_od0
		OrderDetail od0 = new OrderDetail();
		od0.setGoods(g0);
		od0.setNumber(4);
		orderDetailDao.save(od0);
		
		// orderDetail_od1
		OrderDetail od1 = new OrderDetail();
		od1.setGoods(g1);
		od1.setNumber(5);
		orderDetailDao.save(od1);
		
		// orderForm_o0
		OrderForm o0 = new OrderForm();
		o0.setOrderFormId(1234);
		Set<OrderDetail> ordersDetailList0 = new HashSet<OrderDetail>();
		ordersDetailList0.add(od0);
		ordersDetailList0.add(od1);
		o0.setOrdersDetailList(ordersDetailList0);
		orderFormDao.save(o0);
		
		// orderForm_o1
		OrderForm o1 = new OrderForm();
		o1.setOrderFormId(2345);
		Set<OrderDetail> ordersDetailList1 = new HashSet<OrderDetail>();
		ordersDetailList1.add(od0);
		ordersDetailList1.add(od1);
		o1.setOrdersDetailList(ordersDetailList1);
		orderFormDao.save(o1);
		
		// user_u0
		User u0 = new User();
		u0.setAddress("u0的地址");
		u0.setBirthday((java.util.Date) new Date());
		u0.setLevel(1);
		u0.setName("u0");
		Set<OrderForm> ordersList = new HashSet<OrderForm>();
		ordersList.add(o0);
		ordersList.add(o1);
		u0.setOrderList(ordersList);
		u0.setPhoneNum("187-0938-9837");
		u0.setSex(true);
		u0.setUserId("u0_id");
		u0.setId((long) 0);
		userdao.save(u0);
		System.out.println("test over !");
	}
	
//	@Test
//	public void findAllOrderDetail() {
//		Optional<Order> newOrder = orderFormDao.findById(1);		
//		List<OrderDetail> findAllByOrder = orderDetailDao.findAllByOrder(newOrder);
//		for(OrderDetail item : findAllByOrder) {
//			System.out.println(item.getItem());
//		}
//		
//	}
}
