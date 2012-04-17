package com.sociorespo.web.action;

import java.util.ArrayList;
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
import com.sociorespo.web.actionform.DebateActionForm;

public class DebateAction extends Action{
	
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		
		String nextPage = null;
		String linkUrl = null;
		HttpSession session = null;
		ActionErrors errors = new ActionErrors();
		
		DebateActionForm debateActionForm = (DebateActionForm)form;
		
		PostBL postBL = null;
		PostDTO postDTO = null;
	
		session = request.getSession(true);
		
		String userSessionId = session.getAttribute("USERID").toString();
		int userId = Integer.parseInt(userSessionId);
				
		linkUrl = request.getParameter("link_url");
		postBL = new PostBL();
		postDTO = new PostDTO();
		postDTO.setUserId(userId);
		if (linkUrl != null) {
			if (linkUrl.equals("debate")) {
				List debateList=new ArrayList();
				List userList=new ArrayList();
				List titleList = new ArrayList();
				
				debateList = postBL.getDebateList(postDTO);
				debateActionForm.setDebateListView(debateList);
				userList = postBL.getUserList(postDTO);
				//if(!debateList.isEmpty()){
				debateActionForm.setUserListView(userList);
				titleList = postBL.getTitleList();
				debateActionForm.setTitleListView(titleList);
				
				//}
			
				nextPage= "DEBATE";
			}
		}else{
			postDTO.setUserId(userId);
			
			//postDTO.setComplaintTitle(debateActionForm.getDebateTitle());
			
			if(debateActionForm.getDebateComment()!=null && debateActionForm.getDebateComment()!=""){
				postDTO.setContent(debateActionForm.getDebateComment());
				FaceBookBL faceBookBL = new FaceBookBL();
				TwitterBL twitterBL = new TwitterBL();
				LinkedInBL linkedInBL = new LinkedInBL();
				
				boolean shareSts = false;
				
				if(debateActionForm.isShareFacebook()){
					shareSts = faceBookBL.shareMsgInFaceBook(postDTO);	
				}
				
				if(debateActionForm.isShareTwitter()){
					
					AccessToken accessToken = null;
					
					accessToken = (AccessToken)session.getAttribute("TWITTERACCESSTOKEN");
					
					shareSts = twitterBL.shareMsgInTwitter(postDTO, accessToken);	
				}
				
					if(debateActionForm.isShareLinkedIn()){
					
						LinkedInAccessToken accessToken = null;
					
					accessToken = (LinkedInAccessToken)session.getAttribute("LINKEDINACCESSTOKEN");
					
					shareSts = linkedInBL.shareMsgInLinkedIn(postDTO, accessToken);	
				}
					
					
					postDTO = postBL.insertDebate(postDTO);
				
			}
			
		if(postDTO != null){
			//if(postDTO.isTagInsert()==true ){
				List debateList=new ArrayList();
				debateList = postBL.getDebateList(postDTO);
				
				debateActionForm.setDebateListView(debateList);
				
				nextPage= "DEBATE";
			}
		}
		
		
		return mapping.findForward(nextPage);
	}

}
