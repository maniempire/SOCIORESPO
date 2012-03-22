package com.sociorespo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sociorespo.dto.LoginDTO;
import com.sociorespo.dto.ProfileDTO;

import com.sociorespo.dao.DataAccessObject;

public class ProfileDAO extends DataAccessObject{
	
	

public ProfileDTO insertUserProfile(ProfileDTO profileDTO) {
	
	
		
	profileDTO = insertUser(profileDTO);
	
	profileDTO = insertProfile(profileDTO);
	
	
	
	return profileDTO;
}

private ProfileDTO insertProfile(ProfileDTO profileDTO) {
	
	Connection sqlCon = null;
	Statement sqlStmt = null;
	PreparedStatement preparedStatement = null;
	String sqlQuery = null;
	boolean result = false;
	
	sqlCon = getSQLConnection();
	try {
		
	sqlStmt =sqlCon.createStatement();
		
	preparedStatement=sqlCon.prepareStatement("insert into profile (pf_id,pf_user_id,first_name,last_name,gender,phone_no,email_id,date_of_birth,Voter_id) values (default,'"+profileDTO.getUserId()+"','"+profileDTO.getFirstName()+"','"+profileDTO.getLastName()+"','"+profileDTO.getGender()+"','"+profileDTO.getPhoneNum()+"','"+profileDTO.getMailId()+"','"+profileDTO.getDob()+"','"+profileDTO.getVoterId()+"')");

	
	//preparedStatement=sqlCon.prepareStatement("insert into social_media_key(smk_id,smk_user_id,smk_key) values(1,"+userId+",'"+accessToken+"')");
	
	preparedStatement.executeUpdate();
	
	result=true;
	profileDTO.setCurrentUser(result);
	
	}catch (SQLException e) {
		
		e.printStackTrace();
	}
	closeSQLConnection(sqlCon, sqlStmt, preparedStatement,null);
	
	
	return profileDTO;
}

private ProfileDTO insertUser(ProfileDTO profileDTO) {
	
	Connection sqlCon = null;
	Statement sqlStmt = null;
	ResultSet resultSet = null;
	String sqlQuery = null;

	String loginStatus = null;
	
	PreparedStatement preparedStatement = null;
	
	String userId = null;
	
	sqlCon = getSQLConnection();
	try {
		
	sqlStmt =sqlCon.createStatement();
	
	
	preparedStatement=sqlCon.prepareStatement("insert into user (user_id,email_id,user_password,user_status) values (default,'"+profileDTO.getMailId()+"','"+profileDTO.getPassword()+"','active')");

	preparedStatement.executeUpdate();
	
	sqlQuery = "select * from user where email_id = '"+profileDTO.getMailId()+"'";
	
	
		
		sqlCon = getSQLConnection(); 
		
		sqlStmt =sqlCon.createStatement();
		
		resultSet = sqlStmt.executeQuery(sqlQuery);
		
		if(resultSet.next()){
						
			
			profileDTO.setUserId(resultSet.getInt(1));
			
			//loginDTO.setValidUser(loginStatus);
			
					
		}else{
			
			loginStatus = "error.pim.invaliduser";
			
			//loginDTO.setValidUser(loginStatus);
			
		}
	}catch (SQLException e) {
		
		e.printStackTrace();
	}
	closeSQLConnection(sqlCon, sqlStmt, resultSet);
	
	return profileDTO;
}
public ProfileDTO getuserProfile(ProfileDTO profileDTO){
	
	Connection sqlCon = null;
	Statement sqlStmt = null;
	ResultSet resultSet = null;
	String sqlQuery = null;

	
	
	sqlCon = getSQLConnection();
	try {
		
	sqlStmt =sqlCon.createStatement();
	
	
	sqlQuery = "select * from profile where pf_user_id = '"+profileDTO.getUserId()+"'";
	
	
		sqlCon = getSQLConnection(); 
		
		sqlStmt =sqlCon.createStatement();
		
		resultSet = sqlStmt.executeQuery(sqlQuery);
		
		if(resultSet.next()){
						
			
			profileDTO.setUserId(resultSet.getInt(2));
			profileDTO.setFirstName(resultSet.getString(3));
			profileDTO.setLastName(resultSet.getString(4));
			profileDTO.setGender(resultSet.getString(5));
			profileDTO.setPhoneNum(resultSet.getString(6));
			profileDTO.setMailId(resultSet.getString(7));
			profileDTO.setDob(resultSet.getString(8));
			profileDTO.setVoterId(resultSet.getString(9));
						
				
		}
			
			
		
	}catch (SQLException e) {
		
		e.printStackTrace();
	}
	closeSQLConnection(sqlCon, sqlStmt, resultSet);
	
	return profileDTO;
}



}
