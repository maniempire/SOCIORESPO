package com.sociorespo.bl;


import com.sociorespo.dao.LoginDAO;
import com.sociorespo.dto.LoginDTO;
import com.sociorespo.dto.ProfileDTO;


public class LoginBL {

	
	public LoginDTO isValidUser(LoginDTO loginDTO) {
		
		
	
		LoginDAO loginDAO = new LoginDAO();
		loginDTO = loginDAO.isValidUser(loginDTO);
		
		
		return loginDTO;
	}
}
