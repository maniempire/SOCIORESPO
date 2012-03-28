package com.sociorespo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.sociorespo.dto.HomeDTO;
import com.sociorespo.dto.LoginDTO;

public class HomeDAO extends DataAccessObject{

	Connection sqlCon = null;
	Statement sqlStmt = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	boolean result = false;

	public HomeDTO insertPostTage(HomeDTO homeDTO) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		//date = (dateFormat.format(date)).;
		sqlCon = getSQLConnection();
		try {
			
			
		sqlStmt =sqlCon.createStatement();
			
		String sqlQuery =("insert into thoughts (thoughts_id,thoughts_description,thoughts_start_date,thoughts_user_id) values (default,'"+homeDTO.getPostTags()+"','"+dateFormat.format(date)+"',"+homeDTO.getUserId()+")");

		preparedStatement=sqlCon.prepareStatement(sqlQuery);
		//preparedStatement=sqlCon.prepareStatement("insert into social_media_key(smk_id,smk_user_id,smk_key) values(1,"+userId+",'"+accessToken+"')");
		
		preparedStatement.executeUpdate();
		
		result=true;
		homeDTO.setTagInsert(result);
		
		}catch (SQLException e) {
			
			e.printStackTrace();
		} 
		closeSQLConnection(sqlCon, sqlStmt, preparedStatement,null);
		
		return homeDTO;
	}

	public List getPostTage(HomeDTO homeDTO) {
		
		String sqlQuery = null;

		String loginStatus = null;
		
		List userTags = new ArrayList();
		
		try	{
				
		sqlQuery = "select * from thoughts where thoughts_user_id='"+homeDTO.getUserId()+"'";
	
		
			sqlCon = getSQLConnection(); 
			
			sqlStmt =sqlCon.createStatement();
			
			resultSet = sqlStmt.executeQuery(sqlQuery);
			/*Iterator iterator = (Iterator) sqlStmt.executeQuery(sqlQuery);
			if (iterator != null) {
				while (iterator.hasNext()) {
					codeMiscHB = (CodeMiscHB) iterator.next();
					dataConstantCollection.add(codeMiscHB);
				}
			}*/
			//if(resultSet.next()){
				while(resultSet.next()){
					homeDTO = new HomeDTO();
				//loginStatus = "valid";
			
				homeDTO.setPostTags(resultSet.getString(4));
				homeDTO.setTagDate(resultSet.getString(5));
				homeDTO.setUserId(resultSet.getInt(2));
				userTags.add(homeDTO);	
				
			}
				
			//}else{
				
				//loginStatus = "error.pim.invaliduser";
				
				//homeDTO.setValidUser(loginStatus);
				
			//}
				
		}catch (Exception e){
			System.out.println(e);
		}finally{
			
			closeSQLConnection(sqlCon, sqlStmt, preparedStatement, resultSet);
		}
		
		
		return userTags;
	}

	

}
