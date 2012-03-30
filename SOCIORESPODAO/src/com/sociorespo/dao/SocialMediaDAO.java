package com.sociorespo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class SocialMediaDAO extends DataAccessObject {

	
public boolean insertFaceBookKey(int userId, String accessToken){
		
		boolean result=false;
		String userExist = null;
		Connection sqlCon = null;
		Statement sqlStmt = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		
		userExist = getUserExist(userId);
		if(userExist==null || userExist==""){
			sqlCon = getSQLConnection();
			try {
				
			sqlStmt =sqlCon.createStatement();
			
			preparedStatement=sqlCon.prepareStatement("insert into social_media_key(smk_id,smk_user_id,sm_facebook_key) values(default,"+userId+",'"+accessToken+"')");
			
			preparedStatement.executeUpdate();
			
			result=true;
			}catch (SQLException e) {
				
				e.printStackTrace();
			}
			closeSQLConnection(sqlCon, sqlStmt, resultSet);
		}else{
			sqlCon = getSQLConnection();
			try {
				
			sqlStmt =sqlCon.createStatement();
					
			preparedStatement=sqlCon.prepareStatement("UPDATE social_media_key SET (sm_facebook_key='"+accessToken+"') WHERE smk_user_id="+userId+"");
			
			
			preparedStatement.executeUpdate();
			
			result=true;
			}catch (SQLException e) {
				
				e.printStackTrace();
			}
			closeSQLConnection(sqlCon, sqlStmt, resultSet);
		}
		
		return result;
	}

public String getFaceBookAccessToken(int userId) {
	
	String sqlQuery = null;

	String faceBookAuthKey = null;
	Connection sqlCon = null;
	Statement sqlStmt = null;
	ResultSet resultSet = null;
	try
	{
	
	sqlQuery = "select * from social_media_key where smk_user_id = "+userId;

	
		
		sqlCon = getSQLConnection(); 
		
		sqlStmt =sqlCon.createStatement();
		
		resultSet = sqlStmt.executeQuery(sqlQuery);
		
		if(resultSet.next()){
		
			faceBookAuthKey = resultSet.getString("sm_facebook_key");
		}
			
	}catch (Exception e){
		System.out.println(e);
	}finally{
		
		closeSQLConnection(sqlCon, sqlStmt, null, resultSet);
	}
	
	
	
	return faceBookAuthKey;
}


public boolean insertTwitterKey(int userId, String accessToken){
	
	boolean result=false;
	String userExist = null;
	Connection sqlCon = null;
	Statement sqlStmt = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	
	userExist = getUserExist(userId);
	if(userExist==null || userExist==""){
		sqlCon = getSQLConnection();
		try {
			
		sqlStmt =sqlCon.createStatement();
		
		preparedStatement=sqlCon.prepareStatement("insert into social_media_key(smk_id,smk_user_id,sm_linkedin_key) values(default,"+userId+",'"+accessToken+"')");
		
		preparedStatement.executeUpdate();
		
		result=true;
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		closeSQLConnection(sqlCon, sqlStmt, resultSet);
	}else{
		sqlCon = getSQLConnection();
		try {
			
		sqlStmt =sqlCon.createStatement();
				
		preparedStatement=sqlCon.prepareStatement("UPDATE social_media_key SET (sm_linkedin_key='"+accessToken+"') WHERE smk_user_id="+userId+"");
		
		preparedStatement.executeUpdate();
		
		result=true;
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		closeSQLConnection(sqlCon, sqlStmt, resultSet);
	}
	
	return result;
}


public String getTwitterAccessToken(int userId) {
	
	String sqlQuery = null;

	String linkedInAuthKey = null;
	Connection sqlCon = null;
	Statement sqlStmt = null;
	ResultSet resultSet = null;
	try
	{
	
	sqlQuery = "select * from social_media_key where smk_user_id = "+userId;

	
		
		sqlCon = getSQLConnection(); 
		
		sqlStmt =sqlCon.createStatement();
		
		resultSet = sqlStmt.executeQuery(sqlQuery);
		
		if(resultSet.next()){
		
			linkedInAuthKey = resultSet.getString("sm_twitter_key");
		}
			
	}catch (Exception e){
		System.out.println(e);
	}finally{
		
		closeSQLConnection(sqlCon, sqlStmt, null, resultSet);
	}
	
	
	
	return linkedInAuthKey;
}
	


public boolean saveLinkedInAccessToken(int userId, String accessToken){
	
	boolean result=false;
	String userExist = null;
	Connection sqlCon = null;
	Statement sqlStmt = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	
	userExist = getUserExist(userId);
	if(userExist==null || userExist==""){
		sqlCon = getSQLConnection();
		try {
			
		sqlStmt =sqlCon.createStatement();
		
		preparedStatement=sqlCon.prepareStatement("insert into social_media_key(smk_id,smk_user_id,sm_linkedin_key) values(default,"+userId+",'"+accessToken+"')");
		
		preparedStatement.executeUpdate();
		
		result=true;
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		closeSQLConnection(sqlCon, sqlStmt, resultSet);
	}else{
		sqlCon = getSQLConnection();
		try {
			
		sqlStmt =sqlCon.createStatement();
				
		preparedStatement=sqlCon.prepareStatement("UPDATE social_media_key SET (sm_linkedin_key='"+accessToken+"') WHERE smk_user_id="+userId+"");
		
		preparedStatement.executeUpdate();
		
		result=true;
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		closeSQLConnection(sqlCon, sqlStmt, resultSet);
	}
	
	return result;
}


public String getLinkedInAccessToken(int userId) {
	
	String sqlQuery = null;

	String linkedInAuthKey = null;
	Connection sqlCon = null;
	Statement sqlStmt = null;
	ResultSet resultSet = null;
	try
	{
	
	sqlQuery = "select * from social_media_key where smk_user_id = "+userId;

	
		
		sqlCon = getSQLConnection(); 
		
		sqlStmt =sqlCon.createStatement();
		
		resultSet = sqlStmt.executeQuery(sqlQuery);
		
		if(resultSet.next()){
		
			linkedInAuthKey = resultSet.getString("sm_linkedin_key");
		}
			
	}catch (Exception e){
		System.out.println(e);
	}finally{
		
		closeSQLConnection(sqlCon, sqlStmt, null, resultSet);
	}
	
	
	
	return linkedInAuthKey;
}




public String getUserExist(int userId) {
	
	String sqlQuery = null;

	String faceBookAuthKey = null;
	Connection sqlCon = null;
	Statement sqlStmt = null;
	ResultSet resultSet = null;
	try
	{
	
	sqlQuery = "select * from social_media_key where smk_user_id = "+userId;

	
		
		sqlCon = getSQLConnection(); 
		
		sqlStmt =sqlCon.createStatement();
		
		resultSet = sqlStmt.executeQuery(sqlQuery);
		
		if(resultSet.next()){
		
			faceBookAuthKey = resultSet.getString("smk_user_id");
		}
			
	}catch (Exception e){
		System.out.println(e);
	}finally{
		
		closeSQLConnection(sqlCon, sqlStmt, null, resultSet);
	}
	
	
	
	return faceBookAuthKey;
}

}
