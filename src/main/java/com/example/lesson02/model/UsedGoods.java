package com.example.lesson02.model;

import java.util.Date;

// model, DTO, VO, domain, entity = 부르는 이름이 많다.(하지만 미세한 차이가 있다.) => 회사마다 명칭이 다르다.
public class UsedGoods {
	// 필드
	private int id; // null을 확인 하므로써 Integer, int 구분해서 넣기
	private int sellerId;
	private String title;
	private String description;
	private int price;
	private String pictureUr1;
	private Date createdAt;
	private Date updatedAt;
	
	// getters, setters
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getSellerId() {
		return sellerId;
	}
	
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getPictureUr1() {
		return pictureUr1;
	}
	
	public void setPictureUr1(String pictureUr1) {
		this.pictureUr1 = pictureUr1;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
