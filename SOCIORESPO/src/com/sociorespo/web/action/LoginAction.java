package com.sociorespo.web.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sociorespo.web.actionform.HomeActionForm;
import com.sociorespo.web.actionform.ProfileActionForm;

import com.sociorespo.web.actionform.LoginActionForm;

import com.sociorespo.bl.HomeBL;
import com.sociorespo.bl.LoginBL;
import com.sociorespo.bl.ProfileBL;
import com.sociorespo.dto.HomeDTO;
import com.sociorespo.dto.ProfileDTO;
import com.sociorespo.dto.LoginDTO;

public class LoginAction extends Action{
	
public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	
		
		LoginBL loginBL = null;
		
		ProfileBL profileBL =null;
		
		ProfileDTO profileDTO = null;
		
		LoginActionForm loginActionForm = null;
		
		ProfileActionForm profileActionForm = new ProfileActionForm();

		HttpSession session = null;
		HomeBL homeBL = null;
		HomeDTO homeDTO = null;
		
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		
		
		LoginDTO  loginDTO = new LoginDTO();
		
		String userId = null;
		String password = null;
		String validUser = null;
		
		String nextPage = null;
		String linkUrl = "";
			
		try{
			
			loginActionForm = (LoginActionForm)form;
			
			loginBL = new LoginBL();
			
			session = request.getSession(true);
			
			linkUrl = request.getParameter("link_url");
			
			if (linkUrl != null) {
				if (linkUrl.equals("logout")) {
					boolean result = loginBL.logoutUser(loginActionForm.getUserId());
					nextPage = "LOGOUT";
					session.invalidate();
				}
				
			}else{
				
			
			loginDTO.setEmailId(loginActionForm.getEmailId());
			
			loginDTO.setPassword(loginActionForm.getPassword());
			
			loginDTO = loginBL.isValidUser(loginDTO);
			
			if(loginDTO != null){
				
				if(loginDTO.getValidUser().equals("valid")){
					
//					ArrayList userTags;
//					
//					HomeActionForm homeActionForm = new HomeActionForm();
					profileDTO = new ProfileDTO();
					profileBL = new ProfileBL();
					//homeBL = new HomeBL();
					//homeDTO = new HomeDTO();
					
					profileDTO.setUserId(loginDTO.getUserId());
					
					profileDTO=profileBL.getUserProfile(profileDTO);
					profileActionForm.setProfileDTO(profileDTO);
					
					session.setAttribute("USERID", profileDTO.getUserId());
					session.setAttribute("FIRSTNAME", profileDTO.getFirstName());
//					
//					homeDTO.setUserId(loginDTO.getUserId());
//					
//					userTags = (ArrayList) homeBL.getTags(homeDTO);
//					homeActionForm.setUserTags(userTags);
					nextPage="SUCCESS";
					System.out.println("Login Success");
				}else{
					
					errors.add("PIMERROR", new ActionError("errors.pim.invaliduser"));
					
					nextPage="Failure";
				}

				
			}else{
				
				errors.add("PIMERROR", new ActionError(
				"errors.pim.internalerror"));
				nextPage="Failure";
			
			}
			}
		}catch(Exception e){
		
			e.printStackTrace();
			errors.add("PIMERROR", new ActionError(
			"errors.pim.internalerror"));
			
			nextPage="EXCEPTION";
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);			
		} else {
		}
		
		forward = mapping.findForward(nextPage);
		
		return forward;
	}
	
	



}
