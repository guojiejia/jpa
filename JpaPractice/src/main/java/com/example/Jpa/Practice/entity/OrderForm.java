package com.example.Jpa.Practice.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Table(name = "order_form")
public class OrderForm {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "order_form_id", unique=true, nullable=false)
	private int orderFormId;

	// 默认创建时间
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time")
    @CreationTimestamp
    private Date createTime;
	//@ManyToOne(cascade = CascadeType.ALL , fetch =FetchType.EAGER , optional = false)
	//@JoinColumn(name = "user_id" )
	//private User user;

	@OneToMany(targetEntity = OrderDetail.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "order_form_id")
	private Set<OrderDetail> ordersDetailList = new HashSet<OrderDetail>();
}
