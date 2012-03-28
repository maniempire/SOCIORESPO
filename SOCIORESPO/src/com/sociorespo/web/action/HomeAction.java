package com.sociorespo.web.action;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

import com.sociorespo.bl.HomeBL;
import com.sociorespo.dto.HomeDTO;
import com.sociorespo.web.actionform.HomeActionForm;

public class HomeAction extends Action{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		
		String nextPage = null;
		HttpSession session = null;
		ActionErrors errors = new ActionErrors();
		
		HomeActionForm homeActionForm = (HomeActionForm) form;
		HomeBL homeBL = null;
		HomeDTO homeDTO = null;
		session = request.getSession(true);
		
		String userSessionId = session.getAttribute("USERID").toString();
		int userId = Integer.parseInt(userSessionId);
				
		session = request.getSession(true);
		homeBL = new HomeBL();
		homeDTO = new HomeDTO();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
				
		homeDTO.setUserId(userId);
		homeDTO.setPostTags(homeActionForm.getPostTags());
		homeDTO.setTagDate(dateFormat.format(date));
		
		homeDTO = homeBL.getinsertTag(homeDTO);
		
		
		if(homeDTO != null){
			if(homeDTO.isTagInsert()==true ){
				List userTags;
				userTags = homeBL.getTags(homeDTO);
				homeActionForm.setUserTags(userTags);
				nextPage= "HOMETAGS";
			}
		}
		
		return mapping.findForward(nextPage);
	}

}
