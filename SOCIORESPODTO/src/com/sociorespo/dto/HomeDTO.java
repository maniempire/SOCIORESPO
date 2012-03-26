package com.sociorespo.dto;

import java.util.Date;

public class HomeDTO {

	
	private String postTags = null;
	private boolean tagInsert;
	private String tagDate;
	private int userId = 0;
	private HomeDTO userTags;
	
	

	public String getPostTags() {
		return postTags;
	}

	public void setPostTags(String postTags) {
		this.postTags = postTags;
	}

	
	public boolean isTagInsert() {
		return tagInsert;
	}

	public void setTagInsert(boolean tagInsert) {
		this.tagInsert = tagInsert;
	}

	public String getTagDate() {
		return tagDate;
	}

	public void setTagDate(String string) {
		this.tagDate = string;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public HomeDTO getUserTags() {
		return userTags;
	}

	public void setUserTags(HomeDTO userTags) {
		this.userTags = userTags;
	}


	
	
	
}
