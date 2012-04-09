package com.sociorespo.dto;

import java.util.List;

public class PostDTO {
	
	
	private String postTags = null;
	private boolean shareFacebook ;
	private boolean shareTwitter;
	private boolean shareLinkedIn;
	private boolean tagInsert;
	private String tagDate;
	private int userId = 0;
	private String firstName=null;
	private String lastName = null;
	
	private String content= null;
	private String complaintTitle = null;
	private String postComplaint = null;
	private String debateContent = null;
	private String debateDate= null;
	private String debateTitle = null;
	
	private String complaintUser = null;
	

	public String getComplaintUser() {
		return complaintUser;
	}

	public void setComplaintUser(String complaintUser) {
		this.complaintUser = complaintUser;
	}

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getComplaintTitle() {
		return complaintTitle;
	}

	public void setComplaintTitle(String complaintTitle) {
		this.complaintTitle = complaintTitle;
	}

	public String getPostComplaint() {
		return postComplaint;
	}

	public void setPostComplaint(String postComplaint) {
		this.postComplaint = postComplaint;
	}

	public String getDebateContent() {
		return debateContent;
	}

	public void setDebateContent(String debateContent) {
		this.debateContent = debateContent;
	}

	public String getDebateDate() {
		return debateDate;
	}

	public void setDebateDate(String debateDate) {
		this.debateDate = debateDate;
	}

	public String getDebateTitle() {
		return debateTitle;
	}

	public void setDebateTitle(String debateTitle) {
		this.debateTitle = debateTitle;
	}

	

	
	

}
