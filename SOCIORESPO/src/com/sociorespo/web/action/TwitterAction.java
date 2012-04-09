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

import twitter4j.http.AccessToken;

import com.sociorespo.bl.FaceBookBL;
import com.sociorespo.bl.TwitterBL;
import com.sociorespo.dto.FaceBookDTO;
import com.sociorespo.dto.TwitterDTO;

public class TwitterAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		
			HttpSession session = null;
			
			ActionErrors errors = new ActionErrors();
			ActionForward forward = new ActionForward();
			FaceBookBL faceBookBL = new FaceBookBL();
			FaceBookDTO faceBookDTO = new FaceBookDTO();
			String nextPage = null;
			String userId = null;
			
				
			try{
				
				boolean saveResult = false;
				
				System.out.println("In TwitterAction");
				session = request.getSession(true);
				
				String oAuthVerifier = null;
				String oauthToken = null;
			
				userId = session.getAttribute("USERID").toString();
				oAuthVerifier = request.getParameter("oauth_verifier");
				oauthToken= request.getParameter("oauth_token");
				
				//session.setAttribute("oauth_verifier",oauth_verifier);
				//session.setAttribute("oauth_token",oauth_token);

				TwitterDTO twitterDTO = new TwitterDTO();
				TwitterBL twitterBL = new TwitterBL();
				
				System.out.println(" oauth_token.......!"+oauthToken);
				System.out.println("Twitter oAuthVerifier.......!"+oAuthVerifier);

				twitterDTO.setToken(oauthToken);
				twitterDTO.setTokenSecret(oAuthVerifier);
				
				
				//twitterDTO = twitterBL.addToken(twitterDTO);
				AccessToken accessToken = null;
				
				boolean addStatus = false;
				
				
				//addStatus = twitterBL.addTwitterToken(oauthToken, oAuthVerifier, userId);
				
				accessToken = twitterBL.addTwitterToken(oauthToken, oAuthVerifier);
				
				if(accessToken != null){
					session.setAttribute("TWITTERCONNECTED", "CONNECTED");
					session.setAttribute("TWITTERACCESSTOKEN", accessToken);
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
