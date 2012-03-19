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
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.MessageResources;

import dto.EmployeeDTO;
import dto.LoginDTO;

import bl.EmployeeBL;
import bl.LoginBL;
import actionform.LoginActionForm;
import java.util.ArrayList;

public class LoginAction extends Action {
	
	

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	
		
		LoginBL loginBL = null;
		EmployeeBL employeeBL = null;
		LoginActionForm loginActionForm = null;

		HttpSession session = null;
		
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		
		EmployeeDTO  employeeDTO = null;
		LoginDTO  loginDTO = null;
		
		String userId = null;
		String password = null;
		
		String nextPage = null;
			
		try{
			
			loginActionForm = (LoginActionForm)form;
			
			loginBL = new LoginBL();
			session = request.getSession(true);
			
			userId = loginActionForm.getUserId();
			
			password = loginActionForm.getPassword();
			
			loginDTO = loginBL.isValidUser(userId,password);
			
			if(loginDTO != null){
				
				if(loginDTO.getValidUser().equals("valid")){
					
//					employeeDTO = loginDTO.getEmployeeDTO();
//					
//					employeeBL = new EmployeeBL();
//					
//					employeeDTO = employeeBL.getEmpProfileData(userId);
//					
//					if(employeeDTO != null){
//						
//						session.setAttribute("USERID", userId);
//						
//						session.setAttribute("USERFNAME", employeeDTO.getFirstName());
//						
//						session.setAttribute("USERTYPE", employeeDTO.getEmpType());
//						
//						session.setAttribute("USEREMAIL", employeeDTO.getOfficeMail());
//						
//						session.setAttribute("USERSUPVEMAIL", employeeDTO.getSupvEmail());
//						
//						session.setAttribute("EMPLOYEEDTO", employeeDTO);
//						
//						
//					}
					
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
