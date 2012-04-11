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

import twitter4j.http.AccessToken;

import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;
import com.sociorespo.bl.FaceBookBL;
import com.sociorespo.bl.LinkedInBL;
import com.sociorespo.bl.PostBL;
import com.sociorespo.bl.TwitterBL;
import com.sociorespo.dto.PostDTO;
import com.sociorespo.web.actionform.HomeActionForm;
import com.sociorespo.web.actionform.PostComplaintsActionForm;

public class PostComplaintsAction extends  Action{

	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		
		
		String nextPage = null;
		String linkUrl = null;
		HttpSession session = null;
		ActionErrors errors = new ActionErrors();
		
		PostComplaintsActionForm postComplaintsActionForm = (PostComplaintsActionForm) form;
		PostBL postBL = null;
		
		PostDTO postDTO = null;
		//ProfileDTO profileDTO = null;
		
		session = request.getSession(true);
		
		String userSessionId = session.getAttribute("USERID").toString();
		int userId = Integer.parseInt(userSessionId);
				
		session = request.getSession(true);
		postBL = new PostBL();
		postDTO = new PostDTO();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		linkUrl = request.getParameter("link_url");
		
		if (linkUrl != null) {
			if (linkUrl.equals("complaint")) {
				postDTO.setUserId(userId);
				postDTO.setPostComplaint(postComplaintsActionForm.getPostComplaint());
				postDTO.setTagDate(dateFormat.format(date));
				
				
				   
			     postDTO.setComplaintUser("ALL");
			     
				List complaintList=new ArrayList();
				complaintList = postBL.getComplaintList(postDTO);
				postComplaintsActionForm.setComplaintsList(complaintList);
				
				   
			     postDTO.setComplaintUser("USER");
			     
				List userComplaintList=new ArrayList();
				userComplaintList = postBL.getComplaintList(postDTO);
				postComplaintsActionForm.setUserComplaintsList(userComplaintList);
				
				nextPage = "COMPLAINTS";
				
			}
			
		}else{
			postDTO.setUserId(userId);
			postDTO.setContent(postComplaintsActionForm.getPostComplaint());
			postDTO.setShareFacebook(postComplaintsActionForm.isShareFacebook());
			postDTO.setShareTwitter(postComplaintsActionForm.isShareTwitter());
			postDTO.setShareLinkedIn(postComplaintsActionForm.isShareLinkedIn());
			
			if(postComplaintsActionForm.getPostComplaint()!=null && postComplaintsActionForm.getPostComplaint()!=""){
			
				FaceBookBL faceBookBL = new FaceBookBL();
				TwitterBL twitterBL = new TwitterBL();
				LinkedInBL linkedInBL = new LinkedInBL();
				
				boolean shareSts = false;
				
				if(postComplaintsActionForm.isShareFacebook()){
					shareSts = faceBookBL.shareMsgInFaceBook(postDTO);	
				}
				
				if(postComplaintsActionForm.isShareTwitter()){
					
					AccessToken accessToken = null;
					
					accessToken = (AccessToken)session.getAttribute("TWITTERACCESSTOKEN");
					
					shareSts = twitterBL.shareMsgInTwitter(postDTO, accessToken);	
				}
				
					if(postComplaintsActionForm.isShareLinkedIn()){
					
						LinkedInAccessToken accessToken = null;
					
					accessToken = (LinkedInAccessToken)session.getAttribute("LINKEDINACCESSTOKEN");
					
					shareSts = linkedInBL.shareMsgInLinkedIn(postDTO, accessToken);	
				}
					
					postDTO.setComplaintTitle(postComplaintsActionForm.getComplaintTitleText());
				    postDTO = postBL.getinsertComplaint(postDTO);
				
			}
		
			
			postDTO.setTagDate(dateFormat.format(date));
			
//		if(postComplaintsActionForm.getComplaintTitleSelect()!=null){
//			postDTO.setComplaintTitle(postComplaintsActionForm.getComplaintTitleSelect());
//			postDTO = postBL.getinsertComplaint(postDTO);
//		}else if(postComplaintsActionForm.getComplaintTitleText()!=null){
//			postDTO.setComplaintTitle(postComplaintsActionForm.getComplaintTitleText());
//			postDTO = postBL.getinsertComplaint(postDTO);
//		}	
		
			
	     
	     
	     
	     postDTO.setComplaintUser("ALL");
	     
		List complaintList=new ArrayList();
		complaintList = postBL.getComplaintList(postDTO);
		postComplaintsActionForm.setComplaintsList(complaintList);
		
		   
	     postDTO.setComplaintUser("USER");
	     
		List userComplaintList=new ArrayList();
		userComplaintList = postBL.getComplaintList(postDTO);
		postComplaintsActionForm.setUserComplaintsList(userComplaintList);
		
		nextPage = "COMPLAINTS";
		

	}
		
		return mapping.findForward(nextPage);
	}
		
		
	
}
