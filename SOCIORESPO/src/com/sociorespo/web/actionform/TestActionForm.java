package com.sociorespo.web.actionform;


import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

public class TestActionForm extends ActionForm{
	
	
	private String country;
	private ArrayList countryList;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public ArrayList getCountryList() {
		return countryList;
	}
	public void setCountryList(ArrayList countryList) {
		this.countryList = countryList;
	}
	
	

}
