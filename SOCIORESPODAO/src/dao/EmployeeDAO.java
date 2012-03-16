package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.pid.util.ShaUtil;

import dto.EmployeeDTO;
import dto.TaskMgntDTO;

public class EmployeeDAO  extends DataAccessObject {

		
		Connection sqlCon = null;
		Statement sqlStmt = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		
		
		public Collection getempList(String userId) {
			
			EmployeeDTO employeeDTO = null;
			
			List empList = null;
			
			String sqlQuery = null;
			
			sqlCon = getSQLConnection();
			
			sqlQuery = "select e.emp_id,e.emp_first_name," +
					"e.emp_last_name,cm.code_desc,e.emp_designation,dept_name," +
					"en.emp_first_name from employee e,code_misc cm,department," +
					"employee_official_details,employee en " +
					"where e.emp_type_id=cm.code_id and " +
					"e.emp_id=eod_emp_id and dept_id=eod_dept_id " +
					"and en.emp_id=eod_supv_id and e.emp_id=eod_emp_id ";
			
			try {
				
				sqlStmt = sqlCon.createStatement();
				
				resultSet = sqlStmt.executeQuery(sqlQuery);
				
				empList = populateEmpList(resultSet);
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			closeSQLConnection(sqlCon, sqlStmt, resultSet);
		
			
			return empList;
		}
		
		public Collection getempList() {
			
			EmployeeDTO employeeDTO = null;
			
			List empList = null;
			
			String sqlQuery = null;
			
			sqlCon = getSQLConnection();
			
			sqlQuery = "select e.emp_id,e.emp_first_name," +
					"e.emp_last_name,cm.code_desc,e.emp_designation,dept_name," +
					"en.emp_first_name from employee e,code_misc cm,department," +
					"employee_official_details,employee en " +
					"where e.emp_type_id=cm.code_id and " +
					"e.emp_id=eod_emp_id and dept_id=eod_dept_id " +
					"and en.emp_id=eod_supv_id and e.emp_id=eod_emp_id ";
			
			try {
				
				sqlStmt = sqlCon.createStatement();
				
				resultSet = sqlStmt.executeQuery(sqlQuery);
				
				empList = populateEmpList(resultSet);
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			closeSQLConnection(sqlCon, sqlStmt, resultSet);
		
			
			return empList;
		}



		private List populateEmpList(ResultSet resultSet) throws SQLException {
			
			EmployeeDTO employeeDTO = null;
 			
			List empList = null;
			
			if(resultSet != null){
				
				empList = new ArrayList();

				while(resultSet.next()){
					
					employeeDTO = new EmployeeDTO();
					
					employeeDTO.setEmpId(resultSet.getString(1));
					employeeDTO.setFirstName(resultSet.getString(2));
					employeeDTO.setLastName(resultSet.getString(3));
					employeeDTO.setEmpRole(resultSet.getString(4));
					employeeDTO.setDesignation(resultSet.getString(5));
					employeeDTO.setDept(resultSet.getString(6));
					employeeDTO.setReportingTo(resultSet.getString(7));
									
					
					empList.add(employeeDTO);
				}
				
			}
			
			return empList;
		}

		public boolean saveUser(String userId, String firstName, String lastName, String  empRole, String empDesc, String team, String reportingTo, String empEmail, String 
				empPwd, String dob, String doj, String active, String gender, String bloodGroup, String empCell, String empLandLine, String empPersonalMail,
				String empAddress, String empTempAddress, String empAcc, String empPf, String reliving){
			boolean result=false;
			
					
			try
			{
				empPwd = 	ShaUtil.toSha1String(empPwd);	
				
				sqlCon = getSQLConnection();
				sqlStmt =sqlCon.createStatement();
				
				preparedStatement=sqlCon.prepareStatement("insert into employee values ('"+userId+"','"+firstName+"','"+lastName+"','"+empPwd+"',(select code_id from code_misc where code_value='"+empRole+"'),'"+empDesc+"','"+empAcc+"','"+empPf+"','Y')");
				preparedStatement.executeUpdate();
				preparedStatement=sqlCon.prepareStatement("insert into employee_official_details values ('"+userId+"',(select emp_id from employee where emp_first_name='"+reportingTo+"'),(select dept_id from department where dept_name='"+team+"'),(select code_id from code_misc where code_value='"+gender+"'),'"+doj+"','"+empEmail+"')");
				preparedStatement.executeUpdate();
				preparedStatement=sqlCon.prepareStatement("insert into employee_personal_details values ('6000','"+userId+"','"+dob+"','"+bloodGroup+"','"+empTempAddress+"','"+empAddress+"','"+empLandLine+"','"+empCell+"','"+empPersonalMail+"')");
				preparedStatement.executeUpdate();
				result = true;
			}catch (Exception e){
				System.out.println(e);
			}finally {
				if(preparedStatement!=null && sqlCon!=null)
					try
				{
						preparedStatement.close();
						sqlCon.close();
						System.out.println("Database connection is Disconnected");
			}
				catch(SQLException ex){
					System.out.println(ex);
				}
			}
			return result;
		}

		public boolean updateEmpData(String userId, String firstName, String lastName, String  empRole, String empDesc, String team, String reportingTo, String empEmail, String 
				empPwd, String dob, String doj, String active, String gender, String bloodGroup, String empCell, String empLandLine, String empPersonalMail,
				String empAddress, String empTempAddress, String empAcc, String empPf, String reliving){
			boolean result=false;
			
			
			try
			{
				empPwd = 	ShaUtil.toSha1String(empPwd);	
				sqlCon = getSQLConnection();
				sqlStmt =sqlCon.createStatement();
				
				preparedStatement=sqlCon.prepareStatement("update employee set emp_first_name='"+firstName+"'," +
						"emp_last_name='"+lastName+"',emp_type_id=(select code_id from code_misc " +
								"where code_value='"+empRole+"'),emp_designation='"+empDesc+"'" +
										",emp_acc_num='"+empAcc+"',emp_pf_num='"+empPf+"',emp_status=(select code_id from " +
										"code_misc where code_value='20001') where emp_id='"+userId+"'");
										preparedStatement.executeUpdate();				
					preparedStatement=sqlCon.prepareStatement("update employee_official_details set eod_supv_id=(select emp_id from " +
										"employee where emp_first_name='"+firstName+"'),eod_dept_id=(select " +
										"dept_id from department where dept_name='"+team+"')," +
										"eod_gender=(select code_id from code_misc where code_value='"+gender+"')" +
										",eod_email='"+empEmail+"' where eod_emp_id='"+userId+"'");
				preparedStatement.executeUpdate();
				preparedStatement=sqlCon.prepareStatement("update employee_personal_details set epd_dob='"+dob+"'" +
										",epd_blood_group='"+bloodGroup+"',epd_temp_address='"+empTempAddress+"',epd_perm_address='"+empAddress+"'," +
										"epd_phone_no='"+empLandLine+"',epd_cell_no='"+empCell+"',epd_email='"+empPersonalMail+"' where epd_emp_id='"+userId+"'");
				preparedStatement.executeUpdate();
				
				result = true;
			}catch (Exception e){
				System.out.println(e);
			}finally {
				if(preparedStatement!=null && sqlCon!=null)
					try
				{
						preparedStatement.close();
						sqlCon.close();
						System.out.println("Database connection is Disconnected");
			}
				catch(SQLException ex){
					System.out.println(ex);
				}
			}
			return result;
		}
		
		
		public EmployeeDTO getEmpData(String hiddenEmpId) {
			EmployeeDTO employeeDTO = null;
			
			List empList = null;
			
			String sqlQuery = null;
			
			sqlCon = getSQLConnection();
			
			sqlQuery = ("select e.emp_id,e.emp_first_name," +
					"e.emp_last_name,c.code_value,e.emp_designation," +
					"d.dept_desc,eod.eod_supv_id,eod.eod_email," +
					"ep.epd_dob,eod.eod_hire_date,eod.eod_gender," +
					"ep.epd_blood_group, e.emp_password,ep.epd_phone_no," +
					"ep.epd_cell_no,ep.epd_email,ep.epd_perm_address," +
					" ep.epd_temp_address,e.emp_acc_num,e.emp_pf_num" +
					" from employee e,employee_official_details eod," +
					"employee_personal_details ep,department d," +
					"code_misc c,code_misc cm where e.emp_id='"+hiddenEmpId+"' " +
					"and e.emp_id=eod.eod_emp_id and " +
					" e.emp_id=ep.epd_emp_id and d.dept_id=eod.eod_dept_id " +
					"and eod.eod_gender=c.code_id and e.emp_type_id=cm.code_id"); 
			/*
					"select e.emp_id,e.emp_first_name," +
					"e.emp_last_name,cm.code_desc,e.emp_designation,dept_name," +
					"en.emp_first_name from employee e,code_misc cm,department," +
					"employee_official_details,employee en " +
					"where e.emp_type_id=cm.code_id and " +
					"e.emp_id=eod_emp_id and dept_id=eod_dept_id " +
					"and en.emp_id=eod_supv_id and e.emp_id=eod_emp_id and e.emp_id='"+hiddenEmpId+"' ";*/
			
			try {
				
				sqlStmt = sqlCon.createStatement();
				
				resultSet = sqlStmt.executeQuery(sqlQuery);
				
				employeeDTO = populateEmpData(resultSet);
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			closeSQLConnection(sqlCon, sqlStmt, resultSet);
		
			
		
			return employeeDTO;
		}
		
		public EmployeeDTO getEmpProfileData(String empId) {
			EmployeeDTO employeeDTO = null;
			
			List empList = null;
			
			String sqlQuery = null;
			
			sqlCon = getSQLConnection();
			
			sqlQuery = ("select e.emp_id, e.emp_password, e.emp_first_name, e.emp_type_id, eo.eod_email as user_mail,eom.eod_email as Supervisor_mail " 
					+" from employee e,employee_official_details eo,employee_official_details eom "
					+" where e.emp_id='"+empId +"'"
					+" and e.emp_id=eo.eod_emp_id and eo.eod_supv_id=eom.eod_emp_id"); 
			/*
					"select e.emp_id,e.emp_first_name," +
					"e.emp_last_name,cm.code_desc,e.emp_designation,dept_name," +
					"en.emp_first_name from employee e,code_misc cm,department," +
					"employee_official_details,employee en " +
					"where e.emp_type_id=cm.code_id and " +
					"e.emp_id=eod_emp_id and dept_id=eod_dept_id " +
					"and en.emp_id=eod_supv_id and e.emp_id=eod_emp_id and e.emp_id='"+hiddenEmpId+"' ";*/
			
			try {
				
				sqlStmt = sqlCon.createStatement();
				
				resultSet = sqlStmt.executeQuery(sqlQuery);
				
				employeeDTO = populateEmpProfileData(resultSet);
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			closeSQLConnection(sqlCon, sqlStmt, resultSet);
		
			
		
			return employeeDTO;
		}
		
		private EmployeeDTO populateEmpProfileData(ResultSet resultSet) throws SQLException {
			
			EmployeeDTO employeeDTO = null;
			
			if(resultSet != null){

				while(resultSet.next()){
					
					employeeDTO = new EmployeeDTO();
					
					employeeDTO.setEmpId(resultSet.getString(1));
					
					employeeDTO.setFirstName(resultSet.getString(3));
					
					employeeDTO.setEmpType(resultSet.getString(4));
					
					employeeDTO.setOfficeMail(resultSet.getString (5));
					
					employeeDTO.setSupvEmail(resultSet.getString (6));
					
					
				}
			}
			
			return employeeDTO;
			
		}
		
		
private EmployeeDTO populateEmpData(ResultSet resultSet) throws SQLException {
			
			EmployeeDTO employeeDTO = null;
 			
			List empList = null;
			
			if(resultSet != null){
				
			

				while(resultSet.next()){
					
					employeeDTO = new EmployeeDTO();
					
					employeeDTO.setEmpId(resultSet.getString(1));
					employeeDTO.setFirstName(resultSet.getString(2));
					employeeDTO.setLastName(resultSet.getString(3));
					employeeDTO.setGender(resultSet.getString(4));
					employeeDTO.setDesignation(resultSet.getString(5));
					employeeDTO.setDept(resultSet.getString(6));
					employeeDTO.setReportingTo(resultSet.getString(7));
					employeeDTO.setOfficeMail(resultSet.getString (8));
					employeeDTO.setDob(resultSet.getString (9));
					employeeDTO.setDoj(resultSet.getString (10));
					employeeDTO.setGender(resultSet.getString (11));
					employeeDTO.setBloodGroup(resultSet.getString (12));
					employeeDTO.setOldPassword(resultSet.getString (13));
					employeeDTO.setLandLine(resultSet.getString (14));
					employeeDTO.setCellNumber(resultSet.getString (15));
					employeeDTO.setPersonalMail(resultSet.getString (16));
					employeeDTO.setPermanentAddress(resultSet.getString (17));
					employeeDTO.setContactAddress(resultSet.getString (18));
					employeeDTO.setAccNumber(resultSet.getString (19));
					employeeDTO.setPfNumber(resultSet.getString (20));
			
					
					
					/*
					
					
					
					ep.epd_perm_address," +
					" ep.epd_temp_address,e.emp_acc_num,e.emp_pf_num" +
					" from employee e,employee_official_details eod," +
					"employee_personal_details ep,department d," +
					"code_misc c,code_misc cm */
					/*
					
					
					
					
					employeeDTO.setContactAddress(resultSet.getString (13));
					
					
					
					
					
					employeeDTO.setDob(resultSet.getString(19));
					*/
					
					
					
				}
				
			}
			
			return employeeDTO;
		}
}
