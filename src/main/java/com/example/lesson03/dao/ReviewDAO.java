package com.example.lesson03.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.model.Review;

@Repository
public interface ReviewDAO {
	// 예제 ex01
	public Review selectReview(int id);
	
	// 예제 ex02_1
	public int insertReview(Review review);
	
	// 예제 ex02_2
	public int insertReviewAsField(
			@Param("storeId") int storeId, 
			@Param("menu") String menu, 
			@Param("userName") String userName,
			@Param("point") Double point, 
			@Param("review") String review);
}
