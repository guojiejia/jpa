package com.example.Jpa.Practice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="ordersDetail")
public class OrderDetail {
	
	@Id
	@Column(name = "id" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  id;
	
	@OneToOne(targetEntity = Goods.class)
	@JoinColumn(name = "item_id")
	private Goods item;
	
	@Column(name="item_num")
	private int itemNum;
	
	@ManyToOne(targetEntity = Order.class)
	@JoinColumn(name = "order_id" )
	private Order order;
}
