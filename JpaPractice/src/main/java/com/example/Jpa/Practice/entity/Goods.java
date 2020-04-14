package com.example.Jpa.Practice.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="goods")
public class Goods implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "goods_id", unique=true, nullable=false)
	private Long goodsId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "colour")
	private String colour;
	
	@Column(name = "detail")
	private String detail;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "version")
	private Long version = (long) 1;
}
