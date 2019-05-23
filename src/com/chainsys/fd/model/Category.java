package com.chainsys.fd.model;

/**
 * @author rich2110
 *This class contains category information 
 */
public class Category {
	private int categoryId;
	private String categoryName;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String name) {
		this.categoryName = name;
	}
}
