package com.practice.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LoginAction extends Action {

	 public ActionForward execute(ActionMapping mapping, ActionForm form,
			    HttpServletRequest request, HttpServletResponse response)
			    throws Exception {

			ActionErrors errors = new ActionErrors();
			ActionForward forward = new ActionForward(); // return value
			
		
			String successMessage = "SUCCESS";
			
		
			
			try {
				
				System.out.println("In action class");

			} catch (Exception e) {

			    // Report the error using the appropriate name and ID.
				e.printStackTrace();
				errors.add("EERROR", new ActionError(
				"errors.test.error"));

			}

			// If a message is require]d, save the specified key(s)
			// into the request for use by the <struts:errors> tag.

			if (!errors.isEmpty()) {
			    saveErrors(request, errors);

			    // Forward control to the appropriate 'failure' URI (change name as desired)
			    forward = mapping.findForward(successMessage);

			} else {

			    // Forward control to the appropriate 'success' URI (change name as desired)
				forward = mapping.findForward(successMessage);

			}

			// Finish with
			
			return (forward);

		    }
	
	
}
