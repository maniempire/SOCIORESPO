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

import com.pid.util.ShaUtil;

import dto.EmployeeDTO;
import dto.LoginDTO;


public class LoginDAO extends DataAccessObject{
	
	
	Connection sqlCon = null;
	Statement sqlStmt = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	
	public List loginUser(String user, String password){
		String tempId = null;
		String tempName = null;
		String tempPassword =null;
		String userEmailId = null;
		String userSupvId = null;
		String type=null;
		String sNo=null;
		String date=null;
		String day=null;
		String reason=null;
		String result;
		List userData=new ArrayList();
		
		List holidayData = new ArrayList();
		Connection conn=null;
		
		ResultSet rs=null;
		Statement stmt=null;
		//String ConnectionURL="jdbc:db2://192.168.1.169:50000/PIM";
				
		try
		{
			conn = getSQLConnection(); 
			//Class.forName("com.ibm.db2.jcc.DB2Driver");
			//conn=DriverManager.getConnection(ConnectionURL, "dba","visiondba");
			stmt =conn.createStatement();
			//rs=stmt.executeQuery("select * from EMPLOYEE where EMP_FIRST_NAME= '"+user+"' and EMP_PASSWORD='"+password+"'");
			
			rs=stmt.executeQuery(" select e.emp_id, e.emp_password, e.emp_first_name, e.emp_type_id, eo.eod_email as user_mail,eom.eod_email as Supervisor_mail " 
			+" from employee e,employee_official_details eo,employee_official_details eom "
			+" where e.emp_id='"+user +"' and e.emp_password = '" +password +"' "
			+" and e.emp_id=eo.eod_emp_id and eo.eod_supv_id=eom.eod_emp_id");
			while(rs.next()){
				 tempId=rs.getString(1);
				 tempPassword=rs.getString(2);
				 tempName=rs.getString(3);				 
				 type =rs.getString(4);
				 userEmailId = rs.getString(5);
				 userSupvId = rs.getString(6);
			}
			userData.add(tempId);
			userData.add(tempName);
			userData.add(type);
			userData.add(userEmailId);
			userData.add(userSupvId);
			if(user.equals(tempId) && password.equals(tempPassword)){
				result = "true";
				userData.add(result);
				rs=stmt.executeQuery("select * from Holiday");
				while(rs.next()){
					List holiday = new ArrayList();
					sNo=rs.getString(1);
					date=rs.getString(2);
					day=rs.getString(3);
					reason =rs.getString(4);
					holiday.add(sNo);
					holiday.add(date);
					holiday.add(day);
					holiday.add(reason);
					holidayData.add(holiday);
				}
			
			}else{
				result = "false";
			}
			
			
			
		}catch (Exception e){
			System.out.println(e);
		}finally {
			if(rs!=null && conn!=null)
				try
			{
					rs.close();
					conn.close();
					System.out.println("Database connection is Disconnected");
		}
			catch(SQLException ex){
				System.out.println(ex);
			}
		}
		
		userData.add(holidayData);
		return userData;
	}

public LoginDTO isValidUser(String userId, String password){
		
		EmployeeDAO employeeDAO = null;
		LoginDTO loginDTO =  null;
		EmployeeDTO employeeDTO = null;
		String sqlQuery = null;

		String loginStatus = null;
		
		try
		{
		
		//password = 	ShaUtil.toSha1String(password);	
		
		//sqlQuery = "select * from EMPLOYEE e where e.emp_id='"+userId+"' and e.emp_password = '" +password +"'";
		sqlQuery = "select * from user_detail e where e.first_name='"+userId+"' and e.password = '" +password +"'";
	
		loginDTO = new LoginDTO();
			
			sqlCon = getSQLConnection(); 
			
			sqlStmt =sqlCon.createStatement();
			
			resultSet = sqlStmt.executeQuery(sqlQuery);
			
			if(resultSet.next()){
				
				employeeDAO = new EmployeeDAO();
				
				//employeeDTO = employeeDAO.getEmpProfileData(userId);
				
				loginStatus = "valid";
				
				loginDTO.setValidUser(loginStatus);
				
				//loginDTO.setEmployeeDTO(employeeDTO);
		
			}else{
				
				loginStatus = "error.pim.invaliduser";
				
				loginDTO.setValidUser(loginStatus);
				
			}
				
		}catch (Exception e){
			System.out.println(e);
		}finally{
			
			closeSQLConnection(sqlCon, sqlStmt, preparedStatement, resultSet);
		}
		
		return loginDTO;
	}
	
}
