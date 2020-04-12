package com.example.Jpa.Practice.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.Jpa.Practice.entity.OrderForm;
import com.example.Jpa.Practice.entity.OrderDetail;

@Repository
public interface OrderDetailDao extends JpaRepository<OrderDetail,Integer>  , JpaSpecificationExecutor<OrderDetail> {
//	public List<OrderDetail> findAllByOrder (Optional<Order> order );
}
