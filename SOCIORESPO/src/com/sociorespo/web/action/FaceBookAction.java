package com.sociorespo.web.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.MessageResources;

import com.google.code.facebookapi.FacebookJsonRestClient;
import com.sociorespo.bl.FaceBookBL;
import com.sociorespo.dto.FaceBookDTO;


import java.util.ArrayList;

public class FaceBookAction extends Action {
	
	

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	
		
		

		HttpSession session = null;
		
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		FaceBookBL faceBookBL = new FaceBookBL();
		FaceBookDTO faceBookDTO = new FaceBookDTO();
		String nextPage = null;
			
		try{
			
			boolean saveResult = false;
			
			System.out.println("In FaceBookAction");
			session = request.getSession(true);
			
			String authToken = null;

			authToken = (String)session.getAttribute("AUTH_TOKEN");    
			System.out.println("Facbook authToken.......!"+authToken);

			String userSessionId = session.getAttribute("USERID").toString();
			int userId = Integer.parseInt(userSessionId);
					
			
			faceBookDTO.setUserId(userId);
			faceBookDTO.setAuthToken(authToken);
			
			saveResult = faceBookBL.saveAuthSession(faceBookDTO);
			
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
