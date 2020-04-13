package com.example.Jpa.Practice.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.Jpa.Practice.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>{
	public User findUserByUserId(String userId);
}