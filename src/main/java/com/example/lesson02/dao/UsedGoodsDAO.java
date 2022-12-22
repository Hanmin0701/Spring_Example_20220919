package com.example.lesson02.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.lesson02.model.UsedGoods;

@Repository
public interface UsedGoodsDAO {
	// input: X (Service(BO)가 아무것도 안준다. - Ex01에서)
	// output: List<UsedGoods>
	public List<UsedGoods> selectUsedGoodsList();
}