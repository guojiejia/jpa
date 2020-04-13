package com.example.Jpa.Practice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Table(name="ordersDetail")
public class OrderDetail implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  id;
	
	@Column(name="number")
	private int number = 1;
	
	@OneToOne
	@JoinColumn(name="goods_id", referencedColumnName="goods_id")
	private Goods goods;
	
	//@ManyToOne(targetEntity = OrderForm.class , cascade = CascadeType.ALL , fetch = FetchType.LAZY ,optional = true)
	//@JoinColumn(name = "order_form_id" )
	//private OrderForm orderForm;
}
