package com.example.Jpa.Practice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="item")
public class Goods {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name" )
	private String name;
	
	@Column(name = "detail" )
	private String detail;
	
	@Column(name = "price" )
	private String price;
	
	@Column(name = "createTime" )
	private Date createTime;
}
