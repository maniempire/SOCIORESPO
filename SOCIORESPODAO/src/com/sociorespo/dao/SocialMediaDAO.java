package com.sociorespo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sociorespo.dto.TwitterDTO;



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
			
			preparedStatement=sqlCon.prepareStatement("insert into social_media_key(smk_id,smk_user_id,smk_facebook_key) values(default,"+userId+",'"+accessToken+"')");
			
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
					
			preparedStatement=sqlCon.prepareStatement("UPDATE social_media_key SET (smk_facebook_key='"+accessToken+"') WHERE smk_user_id="+userId+"");
			
			
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
		
			faceBookAuthKey = resultSet.getString("smk_facebook_key");
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
		
		preparedStatement=sqlCon.prepareStatement("insert into social_media_key(smk_id,smk_user_id,smk_linkedin_key) values(default,"+userId+",'"+accessToken+"')");
		
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
				
		preparedStatement=sqlCon.prepareStatement("UPDATE social_media_key SET (smk_linkedin_key='"+accessToken+"') WHERE smk_user_id="+userId+"");
		
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
		
			linkedInAuthKey = resultSet.getString("smk_twitter_key");
		}
			
	}catch (Exception e){
		System.out.println(e);
	}finally{
		
		closeSQLConnection(sqlCon, sqlStmt, null, resultSet);
	}
	
	
	
	return linkedInAuthKey;
}
	


public boolean saveLinkedInAccessToken(int userId, String oauthVerifier){
	
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
		
		preparedStatement=sqlCon.prepareStatement("insert into social_media_key(smk_id,smk_user_id,smk_linkedin_key) values(default,"+userId+",'"+oauthVerifier+"')");
		
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
				
		preparedStatement=sqlCon.prepareStatement("UPDATE social_media_key SET (smk_linkedin_key='"+oauthVerifier+"') WHERE smk_user_id="+userId+"");
		
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
		
			linkedInAuthKey = resultSet.getString("smk_linkedin_key");
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

public boolean isLinkedInConnected(String userId) {
	
	String sqlQuery = null;
	boolean linkedInConnected = false;
	
	Connection sqlCon = null;
	Statement sqlStmt = null;
	ResultSet resultSet = null;
	try
	{
	
	sqlQuery = "select * from social_media_key where smk_user_id = "+userId+" and smk_linkedin_key is not null";
	//SELECT * FROM social_media_key where smk_user_id = 8 and smk_linkedin_key is not null

		
		sqlCon = getSQLConnection(); 
		
		sqlStmt =sqlCon.createStatement();
		
		resultSet = sqlStmt.executeQuery(sqlQuery);
		
		if(resultSet.next()){
		
			linkedInConnected = true;
		}
			
	}catch (Exception e){
		System.out.println(e);
	}finally{
		
		closeSQLConnection(sqlCon, sqlStmt, null, resultSet);
	}
	
	return linkedInConnected;
}

public String getOauthVerifier(String userId) {
	
	String sqlQuery = null;
	String oauthVerifier = null;
	
	Connection sqlCon = null;
	Statement sqlStmt = null;
	ResultSet resultSet = null;
	try
	{
	
	sqlQuery = "select * from social_media_key where smk_user_id = "+userId;
	//SELECT * FROM social_media_key where smk_user_id = 8

		
		sqlCon = getSQLConnection(); 
		
		sqlStmt =sqlCon.createStatement();
		
		resultSet = sqlStmt.executeQuery(sqlQuery);
		
		if(resultSet.next()){
			
			oauthVerifier = resultSet.getString("smk_linkedin_key");
		}
			
	}catch (Exception e){
		System.out.println(e);
	}finally{
		
		closeSQLConnection(sqlCon, sqlStmt, null, resultSet);
	}
	
	return oauthVerifier;
}

public boolean isTwitterConnected(String userId) {
	
	String sqlQuery = null;
	boolean twitterConnected = false;
	
	Connection sqlCon = null;
	Statement sqlStmt = null;
	ResultSet resultSet = null;
	try
	{
	
	sqlQuery = "select * from social_media_key where smk_user_id = "+userId+" and smk_twitter_token is not null";
	//SELECT * FROM social_media_key where smk_user_id = 8 and smk_linkedin_key is not null

		
		sqlCon = getSQLConnection(); 
		
		sqlStmt =sqlCon.createStatement();
		
		resultSet = sqlStmt.executeQuery(sqlQuery);
		
		if(resultSet.next()){
		
			twitterConnected = true;
		}
			
	}catch (Exception e){
		System.out.println(e);
	}finally{
		
		closeSQLConnection(sqlCon, sqlStmt, null, resultSet);
	}
	
	return twitterConnected;
}

public boolean addTwitterToken(String oauthToken, String oAuthVerifier,
		String userId) {
	
	boolean result=false;
	String userExist = null;
	Connection sqlCon = null;
	Statement sqlStmt = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	
	userExist = getUserExist(Integer.parseInt(userId));
	if(userExist==null || userExist==""){
		sqlCon = getSQLConnection();
		try {
			
		sqlStmt =sqlCon.createStatement();
		
		preparedStatement=sqlCon.prepareStatement("insert into social_media_key(smk_id,smk_user_id,smk_twitter_token,smk_twitter_verifier) values(default,"+userId+",'"+oauthToken+"','"+oAuthVerifier+"')");
		
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
				
		preparedStatement=sqlCon.prepareStatement("UPDATE social_media_key SET (smk_twitter_token='"+oauthToken+"', smk_twitter_verifier='"+oAuthVerifier+"') WHERE smk_user_id="+userId+"");
		
		preparedStatement.executeUpdate();
		
		result=true;
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		closeSQLConnection(sqlCon, sqlStmt, resultSet);
	}
	
	return result;
	
	
}

public TwitterDTO getTwitterTokens(String userId) {
	
	String sqlQuery = null;
	String oauthVerifier = null;
	String oauthToken = null;
	TwitterDTO twitterDTO = null;
	
	Connection sqlCon = null;
	Statement sqlStmt = null;
	ResultSet resultSet = null;
	try
	{
	
	sqlQuery = "select * from social_media_key where smk_user_id = "+userId;
	//SELECT * FROM social_media_key where smk_user_id = 8

		
		sqlCon = getSQLConnection(); 
		
		sqlStmt =sqlCon.createStatement();
		
		resultSet = sqlStmt.executeQuery(sqlQuery);
		
		
		
		if(resultSet.next()){
			
			twitterDTO = new TwitterDTO();
			oauthToken = resultSet.getString("smk_twitter_token");
			oauthVerifier = resultSet.getString("smk_twitter_verifier");
			
			twitterDTO.setToken(oauthToken);
			twitterDTO.setTokenSecret(oauthVerifier);
		}
			
	}catch (Exception e){
		System.out.println(e);
	}finally{
		
		closeSQLConnection(sqlCon, sqlStmt, null, resultSet);
	}
	

	return twitterDTO;
}

public boolean isFaceBookConnected(String userId) {
	String sqlQuery = null;
	boolean faceBookConnected = false;
	
	Connection sqlCon = null;
	Statement sqlStmt = null;
	ResultSet resultSet = null;
	try
	{
	
	sqlQuery = "select * from social_media_key where smk_user_id = "+userId+" and smk_facebook_key is not null";
	//SELECT * FROM social_media_key where smk_user_id = 8 and smk_linkedin_key is not null

		
		sqlCon = getSQLConnection(); 
		
		sqlStmt =sqlCon.createStatement();
		
		resultSet = sqlStmt.executeQuery(sqlQuery);
		
		if(resultSet.next()){
		
			faceBookConnected = true;
		}
			
	}catch (Exception e){
		System.out.println(e);
	}finally{
		
		closeSQLConnection(sqlCon, sqlStmt, null, resultSet);
	}
	
	return faceBookConnected;
}

}
