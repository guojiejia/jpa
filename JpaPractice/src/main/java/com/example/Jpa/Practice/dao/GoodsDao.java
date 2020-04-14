package com.example.Jpa.Practice.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Jpa.Practice.entity.Goods;
@Repository
public interface GoodsDao extends JpaRepository<Goods,Integer>, JpaSpecificationExecutor<Goods>{

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update goods set price = :price, version = version + 1 where goods_id = :goodsId and version = :version", nativeQuery = true)
	int updateGoodsPriceByGoodsId(@Param("price") String price, @Param("goodsId") Long goodsId, @Param("version") Long version);
}
