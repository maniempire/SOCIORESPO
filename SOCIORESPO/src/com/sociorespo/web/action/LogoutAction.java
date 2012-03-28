package com.sociorespo.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sociorespo.bl.LoginBL;

public class LogoutAction extends Action{
	
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		
		
		String nextPage = null;
		String linkUrl = "";
		HttpSession session = null;
		
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		
		session = request.getSession(true);
		
		LoginBL loginBL = null;
		
		String userSessionId = session.getAttribute("USERID").toString();
		int userId = Integer.parseInt(userSessionId);
		
		loginBL = new LoginBL();
		linkUrl = request.getParameter("link_url");
		
		if (linkUrl != null) {
			if (linkUrl.equals("logout")) {
				boolean result = loginBL.logoutUser(userId);
				nextPage = "LOGOUT";
				session.invalidate();
			}
			
		}
		
		forward = mapping.findForward(nextPage);
		
		return forward;
	}

}
