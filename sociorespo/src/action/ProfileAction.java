package action;

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

import actionform.ProfileActionForm;
import bl.ProfileBL;

public class ProfileAction extends Action{

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws IOException{
		
		String userId=null;
		String oldPwd=null;
		String moblie=null;
		String landLine=null;
		String personalMail=null;
		String officeMail=null;
		String permanentAddress=null;
		String contactAddress=null;
		String newPwd=null;
		String confirmPwd=null;
		String accNum=null;
		String pfNum=null;
		
		String nextPage =null;
		String finalResult=null;
		HttpSession session = null;
		
		ActionErrors errors = new ActionErrors();
		
		try{
		
		session = request.getSession(true);
		
		ProfileActionForm profileActionForm = (ProfileActionForm)form;
		userId=session.getAttribute("USERID").toString();
		moblie=profileActionForm.getCellNumber();
		landLine=profileActionForm.getLandLine();
		personalMail=profileActionForm.getPersonalMail();
		officeMail=profileActionForm.getOfficeMail();
		permanentAddress=profileActionForm.getPermanentAddress();
		contactAddress=profileActionForm.getContactAddress();
		newPwd=profileActionForm.getNewPwd();
		
		if(newPwd!=null){
			oldPwd=profileActionForm.getConfirmPwd();
		}else {
			oldPwd=profileActionForm.getOldPassword();
		}
		accNum=profileActionForm.getAccNumber();
		pfNum=profileActionForm.getPfNumber();
		
//		session.setAttribute("USERNAME", name);
		//String password = profileActionForm.getPassword();
		ProfileBL profileBL = new ProfileBL();
		boolean result=profileBL.empUpdateProfile(userId,oldPwd,moblie,landLine,personalMail,officeMail,permanentAddress,contactAddress,newPwd,confirmPwd,accNum,pfNum);
		String type = session.getAttribute("USERTYPE").toString();
		if(type.equals("15002")){
			nextPage="HRPROFILELIST";
		}else if(type.equals("15001")){
			nextPage="SUPERPROFILELIST";
		}else if((type).equals("15000")){
			nextPage="PROFILELIST";
		}
		
		errors.add("PIMERROR", new ActionError("errors.pim.profileupdated.success"));
		
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
		
		
		
		return mapping.findForward(nextPage);
		
	}
}
