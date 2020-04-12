package com.example.Jpa.Practice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.Jpa.Practice.entity.Goods;
@Repository
public interface GoodsDao extends JpaRepository<Goods,Integer>  , JpaSpecificationExecutor<Goods>{

}
