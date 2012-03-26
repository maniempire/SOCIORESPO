package com.sociorespo.web.actionform;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.sociorespo.dto.HomeDTO;

public class HomeActionForm extends ActionForm {
	
	private String postTags = null;
	private ArrayList userTags = null;
	
	
	private HomeDTO homeDTO =null;
	

	

	public String getPostTags() {
		return postTags;
	}

	public void setPostTags(String postTags) {
		this.postTags = postTags;
	}

	public ArrayList getUserTags() {
		return userTags;
	}

	public void setUserTags(ArrayList userTags) {
		this.userTags = userTags;
	}

//	public List getUserTags() {
//		return userTags;
//	}
//
//	public void setUserTags(List userTags) {
//		this.userTags = userTags;
//	}

	public HomeDTO getHomeDTO() {
		return homeDTO;
	}

	public void setHomeDTO(HomeDTO homeDTO) {
		this.homeDTO = homeDTO;
	}
	
	
	

}
