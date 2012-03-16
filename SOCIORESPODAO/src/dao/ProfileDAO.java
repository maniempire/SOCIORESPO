package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.pid.util.ShaUtil;


public class ProfileDAO extends DataAccessObject{
	
	public boolean empUpdateProfile(String userId, String oldPwd,String moblie,String landLine,String personalMail,String officeMail,String permanentAddress,String contactAddress,String newPwd,String confirmPwd,String accNum,String pfNum){
		
		boolean result=false;
		Connection sqlCon = null;
		Statement sqlStmt = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		
		sqlCon = getSQLConnection();
		try {
			try {
				oldPwd = 	ShaUtil.toSha1String(oldPwd);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		sqlStmt =sqlCon.createStatement();
		
		preparedStatement=sqlCon.prepareStatement("update employee set emp_password='"+oldPwd+"', emp_acc_num='"+accNum+"',emp_pf_num='"+pfNum+"' where emp_id='"+userId+"'");
		preparedStatement.executeUpdate();
		preparedStatement=sqlCon.prepareStatement("update employee_personal_details set epd_temp_address='"+contactAddress+"',epd_perm_address='"+permanentAddress+"',epd_phone_no='"+landLine+"',epd_cell_no='"+moblie +"',epd_email='"+personalMail+"' where epd_emp_id='"+userId+"'");
		preparedStatement.executeUpdate();
		result=true;
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		closeSQLConnection(sqlCon, sqlStmt, resultSet);
		
		return result;
	}

}
