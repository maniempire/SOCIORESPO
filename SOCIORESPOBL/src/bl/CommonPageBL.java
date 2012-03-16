package bl;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

import dao.CommonPageDAO;
public class CommonPageBL {

List result = new ArrayList();	
	public List profileList(String userId){
		CommonPageDAO commonPageDAO = new CommonPageDAO();
		result = commonPageDAO.profileList(userId);
		
		return result;
	}
	
	public List manageEmp(String userId){
		CommonPageDAO commonPageDAO = new CommonPageDAO();
		result =  commonPageDAO.manageEmp(userId);
		
		return result;
	}
}
