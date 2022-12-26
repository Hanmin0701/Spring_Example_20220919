package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.dao.UsedGoodsDAO;
import com.example.lesson03.dao.ReviewDAO;
import com.example.lesson03.model.Review;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewDAO reviewDAO;
	
	public Review getReivew(int id) {
		return reviewDAO.selectReview(id);
	}
	
	// ex02_1
	// input: Review 객체
	// output: int(인서트가 성공된 행 수) 
	public int addReview(Review review) {
		return reviewDAO.insertReview(review);
	}
	
	// ex02_2
	// point가 null이여서 굳이 정확하게 할 필요가 없다. (default가 3.5)
	// addReviewAsField(4, "콤비네이션R", "이한민", 5.0, "역시 맛있따!");
	public int addReviewAsField(int storeId, String menu, String userName, Double point, String review) {
		return reviewDAO.insertReviewAsField(storeId, menu, userName, point, review);
	}
}
