package action;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionform.LoginActionForm;

public class LoginAction extends Action{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){

		
		ActionForward forward = null;
		ActionErrors errors = null;
		String userId = null;
		String password = null;
		String nextPage = null;
		
        errors = new ActionErrors();
        String linkUrl = "";

		linkUrl = request.getParameter("link_url");
		System.out.println("In login Action===>link_url" + linkUrl);

		if (linkUrl != null) {
			if (linkUrl.equals("signup")) {

				nextPage = "SIGNUP";

			} }
		
        LoginActionForm loginActionForm  = (LoginActionForm) form;

		
		userId = loginActionForm.getUserName();
		password = loginActionForm.getPassword();

		boolean userExist = false;
		userExist = validateUser(userId, password);

		if (userExist) {
			errors.add("VALIDUSER", new ActionError("error.user.exist"));
			nextPage = "SUCCESS";
		} else {
			
			nextPage = "Failure";
			}
		forward = mapping.findForward(nextPage);
		return forward;
	}
		public boolean validateUser(String userId, String password) {
			boolean isUserExist = false;
			String empFirstName = null;
			String sqlPwd = null;
			
			try {
				
				if(userId.equals("dhivya") && password.equals("1234"))
				{
					isUserExist = true;
				}
				
			}
			
			catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
			return isUserExist;
}}