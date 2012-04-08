package com.sociorespo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;

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
	String dateofbirth = Convertstrdate(profileDTO.getDob());

		
	preparedStatement=sqlCon.prepareStatement("insert into profile (profile_id,profile_user_id,first_name,last_name,gender,phone_no,email_id,date_of_birth,voter_id) values (default,'"+profileDTO.getUserId()+"','"+profileDTO.getFirstName()+"','"+profileDTO.getLastName()+"','"+profileDTO.getGender()+"','"+profileDTO.getPhoneNum()+"','"+profileDTO.getMailId()+"','"+dateofbirth+"','"+profileDTO.getVoterId()+"')");
	
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
	
	
	preparedStatement=sqlCon.prepareStatement("insert into user (user_id,user_email_id,user_password,user_status) values (default,'"+profileDTO.getMailId()+"','"+profileDTO.getPassword()+"','active')");

	preparedStatement.executeUpdate();
	
	sqlQuery = "select * from user where user_email_id = '"+profileDTO.getMailId()+"'";
	
	
		
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
	
	
	sqlQuery = "select * from profile where profile_user_id = '"+profileDTO.getUserId()+"'";
	
	
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

public ProfileDTO updateProfile(ProfileDTO profileDTO) {
	
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
	
	preparedStatement=sqlCon.prepareStatement("UPDATE profile SET (first_name='"+profileDTO.getFirstName()+"',last_name='"+profileDTO.getLastName()+"',gender='"+profileDTO.getGender()+"',phone_no='"+profileDTO.getPhoneNum()+"',email_id='"+profileDTO.geteMail()+"',date_of_birth='"+profileDTO.getDob()+"',voter_id='"+profileDTO.getVoterId()+"') WHERE profile_user_id="+userId+"");
	
	preparedStatement.executeUpdate();
	
	preparedStatement=sqlCon.prepareStatement("UPDATE user SET (user_password='"+profileDTO.getPassword()+"'user_email_id='"+profileDTO.geteMail()+"') WHERE user_id="+userId+"");
	preparedStatement.executeUpdate();
	}catch (SQLException e) {
		
		e.printStackTrace();
	}
	closeSQLConnection(sqlCon, sqlStmt, resultSet);
	
	return profileDTO;
}
public String Convertstrdate(String dob)
{

	String[] tokenArry =  new String[3];
	

	
	StringTokenizer tokenizer = new StringTokenizer(dob,"/");
	
int i=0;
	while(tokenizer.hasMoreTokens()) {
		
		String key = tokenizer.nextToken();
		tokenArry[i] = key;
		
		System.out.println(key + "\t");
		i++;
		} 
	

	
	dob = tokenArry[2]+"-"+tokenArry[0]+"-"+tokenArry[1];
	System.out.println(dob);
  return dob;
}


}
