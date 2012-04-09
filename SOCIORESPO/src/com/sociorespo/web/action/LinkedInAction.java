package com.sociorespo.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;
import com.sociorespo.bl.FaceBookBL;
import com.sociorespo.bl.LinkedInBL;
import com.sociorespo.dto.FaceBookDTO;
import com.sociorespo.dto.LinkedInDTO;

public class LinkedInAction  extends Action {

public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	
		HttpSession session = null;
		
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		LinkedInBL linkedInBL = new LinkedInBL();
		
		//FaceBookBL faceBookBL = new FaceBookBL();
		FaceBookDTO faceBookDTO = new FaceBookDTO();
		String nextPage = null;
		LinkedInDTO linkedInDTO = null;
		
		
			
		try{
			
			boolean saveResult = false;
			
			System.out.println("In LinkedInAction");
			session = request.getSession(true);
			
			String oauth_verifier = null;
			Object oauth_token = null;
			
			String userSessionId = session.getAttribute("USERID").toString();
			int userId = Integer.parseInt(userSessionId);

			oauth_verifier = request.getParameter("oauth_verifier");
			oauth_token = session.getAttribute("LINKEDINREQUESTTOKEN");

			//session.setAttribute("oauth_verifier",oauth_verifier);
			//session.setAttribute("oauth_token",oauth_token);

			System.out.println("LinkedIn oauth_token.......!"+oauth_token);
			System.out.println("LinkedIn oauth_verifier.......!"+oauth_verifier);
			linkedInDTO = new LinkedInDTO();
			linkedInDTO.setUserId(userId);
	        
	        linkedInDTO.setRequestToken(oauth_token);
	        linkedInDTO.setOauthVerifier(oauth_verifier);
	        LinkedInAccessToken accsessToken = null;
	        //linkedInDTO = linkedInBL.addToken(linkedInDTO);
	        accsessToken=linkedInBL.getLinkedInAccessToken(linkedInDTO);
			//saveResult = linkedInBL.saveAuthSession
			//saveResult = faceBookBL.saveAuthSession(faceBookDTO);
			
			if(accsessToken!=null){
				session.setAttribute("LINKEDINACCESSTOKEN", accsessToken);
				session.setAttribute("LINKEDINCONNECTED", "CONNECTED");
				nextPage = "SUCCESS";
				
			}else{
				
				nextPage = "FAILURE";
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
