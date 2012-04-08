package com.sociorespo.web.actionform;

import java.util.List;

import org.apache.struts.action.ActionForm;

public class DebateActionForm extends ActionForm{
	
	private List debateListView;
	private List userListView;
	
	/*private String debateComment=null;
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
	}*/

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

	
	

}
