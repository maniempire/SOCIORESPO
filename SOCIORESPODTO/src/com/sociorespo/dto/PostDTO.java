package com.sociorespo.dto;

public class PostDTO {
	
	
	private String postTags = null;
	private boolean shareFacebook ;
	private boolean shareTwitter;
	private boolean shareLinkedIn;
	private boolean tagInsert;
	private String tagDate;
	private int userId = 0;
	private String content= null;
	

	public String getPostTags() {
		return postTags;
	}

	public void setPostTags(String postTags) {
		this.postTags = postTags;
	}

	public boolean isShareFacebook() {
		return shareFacebook;
	}

	public void setShareFacebook(boolean shareFacebook) {
		this.shareFacebook = shareFacebook;
	}
	
	public boolean isShareTwitter() {
		return shareTwitter;
	}

	public void setShareTwitter(boolean shareTwitter) {
		this.shareTwitter = shareTwitter;
	}

	public boolean isShareLinkedIn() {
		return shareLinkedIn;
	}

	public void setShareLinkedIn(boolean shareLinkedIn) {
		this.shareLinkedIn = shareLinkedIn;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	

}
