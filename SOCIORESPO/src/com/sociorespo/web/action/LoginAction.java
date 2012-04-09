package com.sociorespo.web.action;

import java.util.List;

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

import com.sociorespo.bl.FaceBookBL;
import com.sociorespo.bl.PostBL;
import com.sociorespo.bl.LoginBL;
import com.sociorespo.bl.ProfileBL;
import com.sociorespo.bl.TwitterBL;
import com.sociorespo.dto.LinkedInDTO;
import com.sociorespo.dto.PostDTO;
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
		PostBL postBL = null;
		PostDTO postDTO = null;
		
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
			
				
			
			loginDTO.setEmailId(loginActionForm.getEmailId());
		          	
			loginDTO.setPassword(loginActionForm.getPassword());
			
			loginDTO = loginBL.isValidUser(loginDTO);
			
			if(loginDTO != null){
				
				if(loginDTO.getValidUser().equals("valid")){
					
					List userTags;
					
					HomeActionForm homeActionForm = new HomeActionForm();
					profileDTO = new ProfileDTO();
					profileBL = new ProfileBL();
					postBL = new PostBL();
					postDTO = new PostDTO();
					
					profileDTO.setUserId(loginDTO.getUserId());
					
					profileDTO=profileBL.getUserProfile(profileDTO);
					profileActionForm.setProfileDTO(profileDTO);
					
					session.setAttribute("USERID", profileDTO.getUserId());
					session.setAttribute("FIRSTNAME", profileDTO.getFirstName());
					
					postDTO.setUserId(loginDTO.getUserId());
					
					userTags = postBL.getTagList(postDTO);
					if(userTags.equals("")){
						homeActionForm.setUserTags(userTags);
					}
					//userTags.add("ddddd");
					
					initTwitter(String.valueOf(profileDTO.getUserId()), session);
					
					initFaceBook(String.valueOf(profileDTO.getUserId()), session);
					
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
			//}
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
	
	public void initTwitter(String userId, HttpSession session){
	
	TwitterBL twitterBL = new TwitterBL();
	
	boolean twitterConnected = false;
	
	
//	twitterConnected = twitterBL.isTwitterConnected(userId);
//	
//	if(twitterConnected){
//		
//		session.setAttribute("TWITTERCONNECTED", "CONNECTED");
//		
//	}else{
//		
		String twitterAuthURL = null;
		
		twitterAuthURL = twitterBL.initAuthUrl();
		
		session.setAttribute("TWITTERAUTHURL", twitterAuthURL);
		
		session.setAttribute("TWITTERCONNECTED", "NOTCONNECTED");
	//	}
		
	}
	
	
	public void initFaceBook(String userId, HttpSession session){
		
		FaceBookBL faceBookBL = new FaceBookBL();
		
		boolean faceBookConnected = false;
		
		
		faceBookConnected = faceBookBL.isFaceBookConnected(userId);
		
		if(faceBookConnected){
			
			session.setAttribute("FACEBOOKCONNECTED", "CONNECTED");
			
		}else{
			
			String faceBookAuthURL = null;
			
			faceBookAuthURL = faceBookBL.initAuthUrl();
			
			session.setAttribute("FACEBOOKAUTHURL", faceBookAuthURL);
			
			session.setAttribute("FACEBOOKCONNECTED", "NOTCONNECTED");
			}
			
		}
	
	
}
