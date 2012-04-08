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

import com.sociorespo.dto.LinkedInDTO;
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
		String userId = null;
		try{
		
		session = request.getSession(true);
		
		userId = session.getAttribute("USERID").toString();
		
		ProfileActionForm profileActionForm = (ProfileActionForm)form;
		
		//initSocialMedia(userId,session, profileActionForm, request);
		
		faceBookProfile(userId,session, profileActionForm);
		
		twitterProfile(userId, session, profileActionForm);
		
		profileBL = new ProfileBL();
		
		String userSessionId = session.getAttribute("USERID").toString();
		//int userId = ;
		profileActionForm.getUpdate();
		
		profileDTO = new ProfileDTO();
	
		
		profileDTO.setUserId(Integer.parseInt(userSessionId));
		
		
		
		
		
		if (linkUrl != null) {
			//if (linkUrl.equals("update")) {
			if(profileActionForm.getUpdate()=="update"){
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
		
		//profileDTO = faceBookBL.getFaceBookProfile(profileDTO);
		
		//profileActionForm.setFaceBookProfileDTO(profileDTO);
		
		//LinkedInBL linkedInBl = new LinkedInBL();
		
		//String authURL = null;
		//String baseURL = null;
		
		//baseURL ="http://" + request.getServerName() + ":" + request.getServerPort() +  request.getContextPath();
//		profileDTO.setBaseURL(baseURL);
//		profileDTO.setUserId(Integer.parseInt(userId));
//		LinkedInDTO linkedInDTO = linkedInBl.getLinkedInAuthURL(profileDTO);
//		
//
//		session.setAttribute("LINKEDINREQUESTTOKEN", linkedInDTO.getRequestToken());
		
		//profileActionForm.setLinkedInAuthURL(linkedInDTO.getAuthUrl());

		//authURL = linkedInBl.getLinkedInAuthURL(baseURL);
	
		//profileActionForm.setLinkedInAuthURL(linkedInDTO.getAuthUrl());

		
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
	
	
	
public void twitterProfile(String userId, HttpSession session, ProfileActionForm profileActionForm) {
		
	String twitterConnected = null;
	TwitterBL twitterBL = new TwitterBL();
	
	twitterConnected = (String)session.getAttribute("TWITTERCONNECTED");
	
	if(twitterConnected.equals("CONNECTED")){
		
		ProfileDTO twitterProfileDTO = null;

		twitterProfileDTO = twitterBL.getUserTwitterProfileDetails(userId);
		profileActionForm.setTwitterProfileDTO(twitterProfileDTO);

		
	}else{
		String twitterAuthURL = null;
		
		twitterAuthURL = (String)session.getAttribute("TWITTERAUTHURL");
		
		profileActionForm.setTwitterAuthURL(twitterAuthURL);
		
	}
	
	
	
	}



public void faceBookProfile(String userId, HttpSession session, ProfileActionForm profileActionForm) {
	
	String faceBookConnected = null;
	FaceBookBL faceBookBL = new FaceBookBL();
	
	faceBookConnected = (String)session.getAttribute("FACEBOOKCONNECTED");
	
	if(faceBookConnected.equals("CONNECTED")){
		
		ProfileDTO faceBookProfileDTO = null;
	
		faceBookProfileDTO = faceBookBL.getFaceBookProfile(userId);
		profileActionForm.setFaceBookProfileDTO(faceBookProfileDTO);

		
	}else{
		String faceBookAuthURL = null;
		
		faceBookAuthURL = (String)session.getAttribute("FACEBOOKAUTHURL");
		
		profileActionForm.setFaceBookAuthURL(faceBookAuthURL);
		
	}
	
	
	}



public void initLinkedIn(String userId, HttpSession session, ProfileActionForm profileActionForm,  HttpServletRequest request){
		
		LinkedInBL linkedInBL = new LinkedInBL();
		
		boolean linkedInConnected = false;
		Object linkedInRequestToken = null;
		ProfileDTO linkedInProfileDTO = null;
		LinkedInDTO linkedInDTO = null;
		
		linkedInConnected = linkedInBL.isLinkedInConnected(userId);
		
		if(linkedInConnected){
			
			session.setAttribute("LINKEDINCONNECTED", "CONNECTED");
			
			linkedInRequestToken = session.getAttribute("LINKEDINREQUESTTOKEN");
			
			linkedInProfileDTO = linkedInBL.getUserLinkedInProfileDetails(linkedInRequestToken, userId);
			
			profileActionForm.setLinkedInProfileDTO(linkedInProfileDTO);
			
		}else{
			
			String baseURL = null;
			
			baseURL ="http://" + request.getServerName() + ":" + request.getServerPort() +  request.getContextPath();
			
			linkedInDTO = linkedInBL.initLinkedIn(baseURL);
			
			if(linkedInDTO != null){
			session.setAttribute("LINKEDINREQUESTTOKEN", linkedInDTO.getRequestToken());
	
			profileActionForm.setLinkedInAuthURL(linkedInDTO.getAuthUrl());
			
			}
			
		}
		
		
	}
	
}
