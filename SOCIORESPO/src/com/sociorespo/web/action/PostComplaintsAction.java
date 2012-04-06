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

import com.sociorespo.bl.PostBL;
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
				
		postDTO.setUserId(userId);
		postDTO.setComplaintTitle(postComplaintsActionForm.getComplaintTitle());
		postDTO.setPostComplaint(postComplaintsActionForm.getPostComplaints());
		
		linkUrl = request.getParameter("link_url");
		
		if (linkUrl != null) {
			if (linkUrl.equals("complaint")) {
				
				nextPage = "SUCESS";
				
			}
			
		}else{
		
		postDTO.setTagDate(dateFormat.format(date));
		
		if(postComplaintsActionForm.getComplaintTitle()!=null){
			postDTO = postBL.getinsertComplaint(postDTO);
		}else{
			nextPage= "SUCCESS";
		}
		
		
		if(postDTO != null){
			//if(postDTO.isTagInsert()==true ){
				List complaintList=new ArrayList();
				complaintList = postBL.getComplaintList(postDTO);
				
				postComplaintsActionForm.setComplaintsList(complaintList);
				
				nextPage= "SUCCESS";
			}
		}
		
		return mapping.findForward(nextPage);
	}
		
		
	
}
