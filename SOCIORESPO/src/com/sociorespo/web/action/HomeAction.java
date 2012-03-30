package com.sociorespo.web.action;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sociorespo.bl.PostBL;
import com.sociorespo.dto.PostDTO;
import com.sociorespo.dto.ProfileDTO;
import com.sociorespo.web.actionform.HomeActionForm;

public class HomeAction extends Action{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		
		String nextPage = null;
		HttpSession session = null;
		ActionErrors errors = new ActionErrors();
		
		HomeActionForm homeActionForm = (HomeActionForm) form;
		PostBL homeBL = null;
		PostDTO postDTO = null;
		ProfileDTO profileDTO = null;
		
		session = request.getSession(true);
		
		String userSessionId = session.getAttribute("USERID").toString();
		int userId = Integer.parseInt(userSessionId);
				
		session = request.getSession(true);
		homeBL = new PostBL();
		postDTO = new PostDTO();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
				
		postDTO.setUserId(userId);
		postDTO.setContent(homeActionForm.getContent());
		postDTO.setShareFacebook(homeActionForm.isShareFacebook());
		postDTO.setShareTwitter(homeActionForm.isShareTwitter());
		postDTO.setShareLinkedIn(homeActionForm.isShareLinkedIn());
		postDTO.setTagDate(dateFormat.format(date));
		
		if(homeActionForm.getContent()!=null){
			postDTO = homeBL.getinsertTag(postDTO);
		}else{
			nextPage= "HOMETAGS";
		}
		
		
		if(postDTO != null){
			//if(postDTO.isTagInsert()==true ){
				List tagList=new ArrayList();
				tagList = homeBL.getTagList(postDTO);
				
				homeActionForm.setTagList(tagList);
				
				nextPage= "HOMETAGS";
			//}
		}
		//nextPage= "HOMETAGS";
		return mapping.findForward(nextPage);
	}

}
