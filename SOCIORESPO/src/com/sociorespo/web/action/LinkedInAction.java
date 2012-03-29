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

import com.sociorespo.bl.FaceBookBL;
import com.sociorespo.dto.FaceBookDTO;

public class LinkedInAction  extends Action {

public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	
		HttpSession session = null;
		
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		FaceBookBL faceBookBL = new FaceBookBL();
		FaceBookDTO faceBookDTO = new FaceBookDTO();
		String nextPage = null;
			
		try{
			
			boolean saveResult = false;
			
			System.out.println("In LinkedInAction");
			session = request.getSession(true);
			
			String oauth_verifier = null;
			String oauth_token = null;

			oauth_verifier = request.getParameter("oauth_verifier");
			oauth_token = request.getParameter("oauth_token");

			//session.setAttribute("oauth_verifier",oauth_verifier);
			//session.setAttribute("oauth_token",oauth_token);

			System.out.println("LinkedIn oauth_token.......!"+oauth_token);
			System.out.println("LinkedIn oauth_verifier.......!"+oauth_verifier);

			
			//saveResult = faceBookBL.saveAuthSession(faceBookDTO);
			
			if(saveResult){
				
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
