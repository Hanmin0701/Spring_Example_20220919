package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.dao.UsedGoodsDAO;
import com.example.lesson02.model.UsedGoods;

@Service
public class UsedGoodsBO {
	@Autowired // Spring bean을 주입 받음 (Dependency Injection)
	private UsedGoodsDAO usedGoodsDAO;
	
	// input 과 out을 잘 정의하고 알아야 한다.
	// input: X (Controller가 아무것도 안준다. - Ex01에서)
	// output: List<UsedGoods>
	public List<UsedGoods> getUsedGoodsList() {
		return usedGoodsDAO.selectUsedGoodsList();
		
	// 다른 방법 2.
//		List<UsedGoods> UsedGoodsList = usedGoodsDAO.selectUsedGoodsList();
//		return usedGoodsList;
	}
}
