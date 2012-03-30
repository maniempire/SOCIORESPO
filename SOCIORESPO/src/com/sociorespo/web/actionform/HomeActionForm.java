package com.sociorespo.web.actionform;

import java.util.List;

import org.apache.struts.action.ActionForm;

//import com.sociorespo.dto.HomeDTO;

public class HomeActionForm extends ActionForm {
	
	private String postTags = null;
	private String content = null;
	private boolean shareFacebook;
	private boolean shareTwitter;
	private boolean shareLinkedIn;
	private List userTags = null;
	private List tagList = null;
	
	//private HomeDTO homeDTO =null;
	

	public String getPostTags() {
		return postTags;
	}

	public void setPostTags(String postTags) {
		this.postTags = postTags;
	}
	
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List getUserTags() {
		return userTags;
	}

	public void setUserTags(List userTags) {
		this.userTags = userTags;
	}

	/*public String getShareFacebook() {
		return shareFacebook;
	}

	public void setShareFacebook(String shareFacebook) {
		this.shareFacebook = shareFacebook;
	}*/

	
	/*public HomeDTO getHomeDTO() {
		return homeDTO;
	}*/

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

	public List getTagList() {
		return tagList;
	}

	public void setTagList(List tagList) {
		this.tagList = tagList;
	}

	/*public void setHomeDTO(HomeDTO homeDTO) {
		this.homeDTO = homeDTO;
	}*/
	
	
	

}
