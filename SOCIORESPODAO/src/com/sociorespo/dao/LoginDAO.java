package com.sociorespo.dao;

import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sociorespo.dao.DataAccessObject;
import com.sociorespo.dto.LoginDTO;
import com.sociorespo.util.ShaUtil;




public class LoginDAO extends DataAccessObject{
	
	
	Connection sqlCon = null;
	Statement sqlStmt = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	
	

public LoginDTO isValidUser(LoginDTO loginDTO){
		
		
		
		
		String sqlQuery = null;

		String loginStatus = null;
		
		try	{
				
		sqlQuery = "select * from user  where email_id='"+loginDTO.getEmailId()+"' and User_password = '" +loginDTO.getPassword() +"'";
	
		loginDTO = new LoginDTO();
			
			sqlCon = getSQLConnection(); 
			
			sqlStmt =sqlCon.createStatement();
			
			resultSet = sqlStmt.executeQuery(sqlQuery);
			
			if(resultSet.next()){
							
				
				loginStatus = "valid";
				
				loginDTO.setUserId(resultSet.getInt(1));
				loginDTO.setValidUser(loginStatus);
				
						
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
