package com.example.Jpa.Study.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.Jpa.Study.entity.User;


@Repository
public interface userDao extends JpaRepository<User,Integer>  , JpaSpecificationExecutor<User>{
}
