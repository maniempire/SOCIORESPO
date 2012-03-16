package bl;

import java.util.ArrayList;
import java.util.List;

import dao.LoginDAO;
import dto.LoginDTO;

public class LoginBL {

	
	public List userLogin(String name, String password) {
		List result=new ArrayList();
		
		LoginDAO loginDAO = new LoginDAO();
		result=loginDAO.loginUser(name,password);
		
		return result;
	}
	
	public LoginDTO isValidUser(String userId, String password) {
		LoginDTO loginDTO = null;
		
		LoginDAO loginDAO = new LoginDAO();
		loginDTO = loginDAO.isValidUser(userId,password);
		
		return loginDTO;
	}
}
