package com.sociorespo.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sociorespo.util.ShaUtil;




public class SocialMediaDAO extends DataAccessObject {

	
public boolean insertFaceBookKey(int userId, String accessToken){
		
		boolean result=false;
		Connection sqlCon = null;
		Statement sqlStmt = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		
		sqlCon = getSQLConnection();
		try {
			
		sqlStmt =sqlCon.createStatement();
		
		preparedStatement=sqlCon.prepareStatement("insert into social_media_key(smk_id,smk_user_id,smk_key) values(1,"+userId+",'"+accessToken+"')");
		
		preparedStatement.executeUpdate();
		
		result=true;
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		closeSQLConnection(sqlCon, sqlStmt, resultSet);
		
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
		
			faceBookAuthKey = resultSet.getString("smk_key");
		}
			
	}catch (Exception e){
		System.out.println(e);
	}finally{
		
		closeSQLConnection(sqlCon, sqlStmt, null, resultSet);
	}
	
	
	
	return faceBookAuthKey;
}
	
}
