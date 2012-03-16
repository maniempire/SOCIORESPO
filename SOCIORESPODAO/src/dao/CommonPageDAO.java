package dao;

import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.EmployeeDTO;

public class CommonPageDAO extends DataAccessObject{
	
	public List profileList(String userId){
		
		String firstName = null;
		String lastName =null;
		String empRole=null;
		String empDesc=null;
		String deptDesc=null;
		String empSupvId=null;
		String empEmail=null;
		String dob=null;
		String hireDate=null;
		String gender=null;
		String bloodGroup=null;
		String empPwd=null;
		String empLandLine=null;
		String empCell=null;
		String empPersonalMail=null;
		String empAddress=null;
		String empTempAddress=null;
		String empAcc=null;
		String empPf=null;
		String result;
		List userData=new ArrayList();
		
		Connection sqlCon = null;
		Statement sqlStmt = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;

		String sqlQuery = null;
		
		sqlCon = getSQLConnection();
		//String ConnectionURL="jdbc:db2://192.168.1.169:50000/PIM";
				
		try
		{
			//Class.forName("com.ibm.db2.jcc.DB2Driver");
			//conn=DriverManager.getConnection(ConnectionURL, "dba","visiondba");
			sqlStmt =sqlCon.createStatement();
			resultSet=sqlStmt.executeQuery("select e.emp_id,e.emp_first_name," +
					"e.emp_last_name,cm.code_value,e.emp_designation,d.dept_desc," +
					" eod.eod_supv_id,eod.eod_email,ep.epd_dob,eod.eod_hire_date," +
					"eod.eod_gender,ep.epd_blood_group, e.emp_password," +
					"ep.epd_phone_no,ep.epd_cell_no,ep.epd_email,ep.epd_perm_address," +
					" ep.epd_temp_address,e.emp_acc_num,e.emp_pf_num from employee e," +
					"employee_official_details eod,employee_personal_details ep" +
					",department d,code_misc c,code_misc cm " +
					"where e.emp_id='"+userId+"' and e.emp_id=eod.eod_emp_id " +
					"and e.emp_id=ep.epd_emp_id and d.dept_id=eod.eod_dept_id " +
					"and eod.eod_gender=c.code_id and e.emp_type_id=cm.code_id"); 
					/*"select e.emp_id,e.emp_first_name,e.emp_last_name," +
					"r.role_desc,e.emp_designation,d.dept_desc,eod.eod_supv_id," +
					"eod.eod_email,ep.epd_dob,eod.eod_hire_date,eod.eod_gender," +
					"ep.epd_blood_group,e.emp_password,ep.epd_phone_no,ep.epd_cell_no," +
					"ep.epd_email,ep.epd_perm_address,ep.epd_temp_address,e.emp_acc_num," +
					"e.emp_pf_num from employee e,employee_official_details eod," +
					"employee_personal_details ep,department d,code_misc c,role r " +
					"where emp_id='"+useId+"' and e.emp_id=eod.eod_emp_id " +
					"and e.emp_id=ep.epd_emp_id and d.dept_id=eod.eod_dept_id " +
					"and eod.eod_gender=c.code_id and r.role_emp_id=e.emp_id");*/
			
			
			while(resultSet.next()){
				userId = resultSet.getString(1);
				firstName = resultSet.getString(2);
				lastName =resultSet.getString(3);
				empRole=resultSet.getString(4);
				empDesc=resultSet.getString(5);
				deptDesc=resultSet.getString(6);
				empSupvId=resultSet.getString(7);
				empEmail=resultSet.getString(8);
				dob=resultSet.getString(9);
				hireDate=resultSet.getString(10);
				gender=resultSet.getString(11);
				if(gender.equals("16000")){
					gender = "MALE";
				}else{
					gender = "FEMALE";
				}
				bloodGroup=resultSet.getString(12);
				empPwd=resultSet.getString(13);
				empLandLine=resultSet.getString(14);
				empCell=resultSet.getString(15);
				empPersonalMail=resultSet.getString(16);
				empAddress=resultSet.getString(17);
				empTempAddress=resultSet.getString(18);
				empAcc=resultSet.getString(19);
				empPf=resultSet.getString(20);
			}
			userData.add(userId);
			userData.add(firstName);
			userData.add(lastName);
			userData.add(empRole);
			userData.add(empDesc);
			userData.add(deptDesc);
			userData.add(empSupvId);
			userData.add(empEmail);
			userData.add(dob);
			userData.add(hireDate);
			userData.add(gender);
			userData.add(bloodGroup);
			userData.add(empPwd);
			userData.add(empLandLine);
			userData.add(empCell);
			userData.add(empPersonalMail);
			userData.add(empAddress);
			userData.add(empTempAddress);
			userData.add(empAcc);
			userData.add(empPf);
			
			}catch (Exception e){
				System.out.println(e);
			}finally {
				if(resultSet!=null && sqlCon!=null)
					try
				{
						resultSet.close();
						sqlCon.close();
						System.out.println("Database connection is Disconnected");
			}
				catch(SQLException ex){
					System.out.println(ex);
				}
			}
			return userData;
			}
	
	public List manageEmp(String useId){
		EmployeeDTO employeeDTO = null;
		
		String empId = null;
		String firstName = null;
		String lastName =null;
		String empRole=null;
		String designation=null;
		String dept=null;
		String empSupvId=null;
		String empEmail=null;
		String dob=null;
		String hireDate=null;
		String gender=null;
		String bloodGroup=null;
		String empPwd=null;
		String empLandLine=null;
		String empCell=null;
		String empPeresultSetonalMail=null;
		String empAddress=null;
		String empTempAddress=null;
		String empAcc=null;
		String empPf=null;
		String result;
		List userData=new ArrayList();
		Connection sqlCon = null;
		Statement sqlStmt = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		sqlCon = getSQLConnection();
		//String ConnectionURL="jdbc:db2://192.168.1.169:50000/PIM";
				
		try
		{
			//Class.forName("com.ibm.db2.jcc.DB2Driver");
			//sqlCon=DriverManager.getConnection(ConnectionURL, "dba","visiondba");
			sqlStmt =sqlCon.createStatement();
			resultSet=sqlStmt.executeQuery("select e.emp_id,e.emp_first_name," +
					"e.emp_last_name,cm.code_desc,e.emp_designation,dept_name," +
					"en.emp_first_name from employee e,code_misc cm,department," +
					"employee_official_details,employee en " +
					"where e.emp_type_id=cm.code_id and " +
					"e.emp_id=eod_emp_id and dept_id=eod_dept_id " +
					"and en.emp_id=eod_supv_id and e.emp_id=eod_emp_id");
			/*resultSet=sqlStmt.executeQuery("select e.emp_id,e.emp_firesultSett_name,e.emp_last_name," +
					"r.role_desc,e.emp_designation,d.dept_desc,eod.eod_supv_id," +
					"eod.eod_email,ep.epd_dob,eod.eod_hire_date,eod.eod_gender," +
					"ep.epd_blood_group,e.emp_password,ep.epd_phone_no,ep.epd_cell_no," +
					"ep.epd_email,ep.epd_perm_address,ep.epd_temp_address,e.emp_acc_num," +
					"e.emp_pf_num from employee e,employee_official_details eod," +
					"employee_peresultSetonal_details ep,department d,code_misc c,role r " +
					"where emp_id='"+useId+"' and e.emp_id=eod.eod_emp_id " +
					"and e.emp_id=ep.epd_emp_id and d.dept_id=eod.eod_dept_id " +
					"and eod.eod_gender=c.code_id and r.role_emp_id=e.emp_id");*/
			
			
			while(resultSet.next()){
				
				employeeDTO = new EmployeeDTO();
				List empList = new ArrayList(); 
				empId = resultSet.getString(1);
				firstName = resultSet.getString(2);
				lastName =resultSet.getString(3);
				empRole=resultSet.getString(4);
				designation=resultSet.getString(5);
				dept=resultSet.getString(6);
				empSupvId=resultSet.getString(7);
				employeeDTO.setEmpId(empId);
				employeeDTO.setFirstName(firstName);
				employeeDTO.setLastName(lastName);
				employeeDTO.setEmpRole(empRole);
				employeeDTO.setDesignation(designation);
				employeeDTO.setDept(dept);
				employeeDTO.setReportingTo(empSupvId);
			
				
				
				userData.add(employeeDTO);
				
				
				
				/*empEmail=resultSet.getString(8);
				dob=resultSet.getString(9);
				hireDate=resultSet.getString(10);
				gender=resultSet.getString(11);
				bloodGroup=resultSet.getString(12);
				empPwd=resultSet.getString(13);
				empLandLine=resultSet.getString(14);
				empCell=resultSet.getString(15);
				empPeresultSetonalMail=resultSet.getString(16);
				empAddress=resultSet.getString(17);
				empTempAddress=resultSet.getString(18);
				empAcc=resultSet.getString(19);
				empPf=resultSet.getString(20);*/
			}
			
			/*userData.add(empEmail);
			userData.add(dob);
			userData.add(hireDate);
			userData.add(gender);
			userData.add(bloodGroup);
			userData.add(empPwd);
			userData.add(empLandLine);
			userData.add(empCell);
			userData.add(empPeresultSetonalMail);
			userData.add(empAddress);
			userData.add(empTempAddress);
			userData.add(empAcc);
			userData.add(empPf);*/
			
			}catch (Exception e){
				System.out.println(e);
			}finally {
				if(resultSet!=null && sqlCon!=null)
					try
				{
						resultSet.close();
						sqlCon.close();
						System.out.println("Database connection is Disconnected");
			}
				catch(SQLException ex){
					System.out.println(ex);
				}
			}
			return userData;
			}
}
