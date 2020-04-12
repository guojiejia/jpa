package com.example.Jpa.Practice.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "user_id", unique=true, nullable=false)
	private String userId;

	@Column(name = "name")
	private String name;

	@Column(name = "birthday")
	private Date birthday;

	@Column(name = "level")
	private Integer level;

	@Column(name = "sex")
	private Boolean sex = false;

	@Column(name = "address")
	private String address;
	
	@Column(name = "phone_num")
	private String phoneNum;
	
	@OneToMany(targetEntity = OrderForm.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Set<OrderForm> orderList;
}
