package com.example.Jpa.Study.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.Jpa.Study.entity.Goods;
@Repository
public interface itemDao extends JpaRepository<Goods,Integer>  , JpaSpecificationExecutor<Goods>{

}
