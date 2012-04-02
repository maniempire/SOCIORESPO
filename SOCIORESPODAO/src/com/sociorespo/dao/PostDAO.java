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

import com.sociorespo.dto.PostDTO;
import com.sociorespo.dto.LoginDTO;

public class PostDAO extends DataAccessObject{

	Connection sqlCon = null;
	Statement sqlStmt = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	boolean result = false;

	public PostDTO insertPostTage(PostDTO postDTO) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		//date = (dateFormat.format(date)).;
		sqlCon = getSQLConnection();
		try {
			
			
		sqlStmt =sqlCon.createStatement();
			
		String sqlQuery =("insert into post (post_id,post_user_id,post_content,post_start_date) values (default,'"+postDTO.getUserId()+"','"+postDTO.getContent()+"','"+dateFormat.format(date)+"')");

		preparedStatement=sqlCon.prepareStatement(sqlQuery);
		//preparedStatement=sqlCon.prepareStatement("insert into social_media_key(smk_id,smk_user_id,smk_key) values(1,"+userId+",'"+accessToken+"')");
		
		preparedStatement.executeUpdate();
		
		result=true;
		postDTO.setTagInsert(result);
		
		}catch (SQLException e) {
			
			e.printStackTrace();
		} 
		closeSQLConnection(sqlCon, sqlStmt, preparedStatement,null);
		
		return postDTO;
	}

	public List getTagList(PostDTO postDTO) {
		
		String sqlQuery = null;

		String loginStatus = null;
		
		List userTags = new ArrayList();
		
		try	{
				
		sqlQuery = "select * from post where post_user_id='"+postDTO.getUserId()+"'";
	
		
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
					postDTO = new PostDTO();
							
					postDTO.setContent(resultSet.getString(3));
					postDTO.setTagDate(resultSet.getString(4));
					postDTO.setUserId(resultSet.getInt(2));
				userTags.add(postDTO);	
				
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
