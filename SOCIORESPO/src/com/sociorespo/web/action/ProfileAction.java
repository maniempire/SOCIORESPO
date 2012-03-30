package com.sociorespo.web.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sociorespo.bl.FaceBookBL;
import com.sociorespo.bl.LinkedInBL;
import com.sociorespo.bl.ProfileBL;
import com.sociorespo.bl.TwitterBL;

import com.sociorespo.dto.ProfileDTO;

import com.sociorespo.web.actionform.ProfileActionForm;


public class ProfileAction extends Action{

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws IOException{
		

		
		String nextPage =null;
		
		String linkUrl="";
		HttpSession session = null;
		
		ActionErrors errors = new ActionErrors();
		
		ProfileDTO profileDTO = null;
		ProfileBL profileBL = null;
		try{
		
		session = request.getSession(true);
		
		//linkUrl = request.getParameter("link_url");
		
		ProfileActionForm profileActionForm = (ProfileActionForm)form;
		
		profileBL = new ProfileBL();
		
		String userSessionId = session.getAttribute("USERID").toString();
		int userId = Integer.parseInt(userSessionId);
		profileActionForm.getUpdate();
		
		profileDTO = new ProfileDTO();
	
		
		profileDTO.setUserId(userId);
		
		
		if (linkUrl != null) {
			if (linkUrl.equals("update")) {
				profileDTO.setFirstName(profileActionForm.getFirstName());
				profileDTO.setLastName(profileActionForm.getLastName());
				if(profileActionForm.getChangePassword()!=null){
					profileDTO.setPassword(profileActionForm.getChangePassword());
				}else{
					profileDTO.setPassword(profileActionForm.getPassword());
				}
				profileDTO.setGender(profileActionForm.getGender());
				profileDTO.setPhoneNum(profileActionForm.getPhoneNum());
				profileDTO.setVoterId(profileActionForm.getVoterId());
				profileDTO.setDob(profileActionForm.getDob());
				
				profileDTO = profileBL.updateProfile(profileDTO);
				nextPage = "SUCCESS";
				//session.invalidate();
			}
			
		else{
		profileDTO=profileBL.getUserProfile(profileDTO);
		
		//profileActionForm.setProfileDTO(profileDTO);
		
		profileActionForm.setFirstName(profileDTO.getFirstName());
		profileActionForm.setLastName(profileDTO.getLastName());
		profileActionForm.setMailId(profileDTO.getMailId());
		profileActionForm.setPassword(profileDTO.getPassword());
		profileActionForm.setGender(profileDTO.getGender());
		profileActionForm.setPhoneNum(profileDTO.getPhoneNum());
		profileActionForm.setDob(profileDTO.getDob());
		profileActionForm.setVoterId(profileDTO.getVoterId());
		
		FaceBookBL faceBookBL = new FaceBookBL();
		
		profileDTO = faceBookBL.getFaceBookProfile(profileDTO);
		
		profileActionForm.setFaceBookProfileDTO(profileDTO);
		
		LinkedInBL linkedInBl = new LinkedInBL();
		
		String authURL = null;
		String baseURL = null;
		
		baseURL ="http://" + request.getServerName() + ":" + request.getServerPort() +  request.getContextPath();
		
		authURL = linkedInBl.getLinkedInAuthURL(baseURL);
	
		profileActionForm.setLinkedInAuthURL(authURL);
		
		TwitterBL twitterBL = new TwitterBL();
		
		String twiterAuthURL = null;
		
		twiterAuthURL = twitterBL.initAuthUrl();
		
		profileActionForm.setTwitterAuthURL(twiterAuthURL);
		
		errors.add("PIMERROR", new ActionError("errors.pim.profileupdated.success"));
		
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
		} 
		
		
		nextPage="SUCCESS";
		
		return mapping.findForward(nextPage);
		
	}
}
