package com.sociorespo.web.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class TestAction extends Action{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	
		
	
	ArrayList countryList = new ArrayList();
	
//	countryList.add(new CountryData("1", "USA"));
//	
//	countryList.add(new CountryData("2", "Canada"));
//	
//	countryList.add(new CountryData("3", "Mexico"));
	
	return null;
	}

}
