package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;



public class LogoutAction extends Action{
	
	
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){

		HttpSession session = null;
		
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		
	
		String nextPage = null;
			
		try{
			
			session = request.getSession(true);
			
			session.invalidate();
			
			nextPage="LOGOUT";
			
		}catch(Exception e){
		
			e.printStackTrace();
			errors.add("PIMERROR", new ActionError(
			"errors.pim.internalerror"));
			nextPage="Failure";
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			
		} else {
		}
		
		forward = mapping.findForward(nextPage);
		
		return forward;
	}
	
	
	

}
