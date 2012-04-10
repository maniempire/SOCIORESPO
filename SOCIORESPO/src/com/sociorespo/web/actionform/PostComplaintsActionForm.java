package com.sociorespo.web.actionform;

import java.util.List;

import org.apache.struts.action.ActionForm;

public class PostComplaintsActionForm extends ActionForm{
	
	private String postComplaint = null;
	private String complaintTitle = null;
	private String complaintTitleText = null;
	private String complaintTitleSelect = null;
	
	private boolean shareFacebook;
	private boolean shareTwitter;
	private boolean shareLinkedIn;
	
	private List complaintsList;
	
	private List userComplaintsList;
	
	
	public List getUserComplaintsList() {
		return userComplaintsList;
	}
	public void setUserComplaintsList(List userComplaintsList) {
		this.userComplaintsList = userComplaintsList;
	}
	public String getPostComplaint() {
		return postComplaint;
	}
	public void setPostComplaint(String postComplaint) {
		this.postComplaint = postComplaint;
	}
	public String getComplaintTitle() {
		return complaintTitle;
	}
	public void setComplaintTitle(String complaintTitle) {
		this.complaintTitle = complaintTitle;
	}
	
	public List getComplaintsList() {
		return complaintsList;
	}
	public void setComplaintsList(List complaintsList) {
		this.complaintsList = complaintsList;
	}
	
	
	public String getComplaintTitleSelect() {
		return complaintTitleSelect;
	}
	public void setComplaintTitleSelect(String complaintTitleSelect) {
		this.complaintTitleSelect = complaintTitleSelect;
	}
	public String getComplaintTitleText() {
		return complaintTitleText;
	}
	public void setComplaintTitleText(String complaintTitleText) {
		this.complaintTitleText = complaintTitleText;
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
	
	
	

}
