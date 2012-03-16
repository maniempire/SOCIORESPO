package bl;

import java.util.Collection;


import dao.EmployeeDAO;
import dto.EmployeeDTO;

public class EmployeeBL {
	
public Collection getEmpList(String userId) {
		
		Collection empList = null;
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		empList = employeeDAO.getempList(userId);
		
		
		return empList;
	}
public Collection getEmpList() {
	
	Collection empList = null;
	
	EmployeeDAO employeeDAO = new EmployeeDAO();
	
	empList = employeeDAO.getempList();
	
	
	return empList;
}


public boolean saveUser(String userId, String firstName, String lastName, String  empRole, String empDesc, String team, String reportingTo, String empEmail, String 
		empPwd, String dob, String doj, String active, String gender, String bloodGroup, String empCell, String empLandLine, String empPersonalMail,
		String empAddress, String empTempAddress, String empAcc, String empPf, String reliving){
	EmployeeDAO employeeDAO = new EmployeeDAO();
	boolean result ;
	result =employeeDAO.saveUser(userId,firstName,lastName, empRole,empDesc,team,reportingTo,empEmail,
			empPwd,dob,doj,active,gender,bloodGroup,empCell,empLandLine,empPersonalMail,
			empAddress,empTempAddress,empAcc,empPf,reliving);
	
	return result;
	
}
public boolean updateEmpData(String userId, String firstName, String lastName, String  empRole, String empDesc, String team, String reportingTo, String empEmail, String 
		empPwd, String dob, String doj, String active, String gender, String bloodGroup, String empCell, String empLandLine, String empPersonalMail,
		String empAddress, String empTempAddress, String empAcc, String empPf, String reliving){
	EmployeeDAO employeeDAO = new EmployeeDAO();
	boolean result ;
	result =employeeDAO.updateEmpData(userId,firstName,lastName, empRole,empDesc,team,reportingTo,empEmail,
			empPwd,dob,doj,active,gender,bloodGroup,empCell,empLandLine,empPersonalMail,
			empAddress,empTempAddress,empAcc,empPf,reliving);
	
	return result;
	
}
public EmployeeDTO getEmpData(String hiddenEmpId) {
	EmployeeDTO employeeDTO = null;
	EmployeeDAO employeeDAO = new EmployeeDAO();
	employeeDTO=employeeDAO.getEmpData(hiddenEmpId);
	return employeeDTO;
}

public EmployeeDTO getEmpProfileData(String empId) {
	
	EmployeeDTO employeeDTO = null;
	
	EmployeeDAO employeeDAO = new EmployeeDAO();
	
	employeeDTO=employeeDAO.getEmpProfileData(empId);
	
	return employeeDTO;
}


}
