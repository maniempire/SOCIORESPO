package com.sociorespo.web.actionform;

import java.util.List;

import org.apache.struts.action.ActionForm;

public class DebateActionForm extends ActionForm{
	
	private List debateListView;
	private List userListView;
	
	private boolean shareFacebook;
	private boolean shareTwitter;
	private boolean shareLinkedIn;
	
	private String debateComment=null;
	private String debateTitle=null;
	
	

	public String getDebateComment() {
		return debateComment;
	}

	public void setDebateComment(String debateComment) {
		this.debateComment = debateComment;
	}
	

	public String getDebateTitle() {
		return debateTitle;
	}

	public void setDebateTitle(String debateTitle) {
		this.debateTitle = debateTitle;
	}

	public List getDebateListView() {
		return debateListView;
	}

	public void setDebateListView(List debateListView) {
		this.debateListView = debateListView;
	}

	public List getUserListView() {
		return userListView;
	}

	public void setUserListView(List userListView) {
		this.userListView = userListView;
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
