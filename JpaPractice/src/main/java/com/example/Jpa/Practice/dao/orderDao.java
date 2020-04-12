package com.example.Jpa.Practice.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.Jpa.Practice.entity.Order;
import com.example.Jpa.Practice.entity.User;

@Repository
public interface orderDao extends JpaRepository<Order,Integer>  , JpaSpecificationExecutor<Order> {
	public List<Optional<Order>> findAllByUser (Optional<User> user);
}
