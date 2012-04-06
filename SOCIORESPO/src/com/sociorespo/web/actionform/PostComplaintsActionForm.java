package com.sociorespo.web.actionform;

import java.util.List;

import org.apache.struts.action.ActionForm;

public class PostComplaintsActionForm extends ActionForm{
	
	private String postComplaints = null;
	private String complaintTitle = null;
	
	private List complaintsList;
	
	
	public String getPostComplaints() {
		return postComplaints;
	}
	public void setPostComplaints(String postComplaints) {
		this.postComplaints = postComplaints;
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
	
	
	

}
