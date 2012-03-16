package action;

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



public class HomeAction extends Action{
	
	
public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){

		HttpSession session = null;
		
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		String nextPage = null;
			
		try{
			
			//holidayActionForm = (HolidayActionForm)form;
			//holidayBL = new HolidayBL();
			
			session = request.getSession(true);
		
			//holidayList = holidayBL.getHolidayList();
			
			//holidayActionForm.setHolidayList(holidayList);
			
			nextPage="Holiday";
			
		}catch(Exception e){
		
			e.printStackTrace();
		}
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			errors.add("IBERROR", new ActionError(
			"errors.ib.internalerror"));
			nextPage="Failure";
		} else {
		}
		
		forward = mapping.findForward(nextPage);
		
		return forward;
	}
}
	