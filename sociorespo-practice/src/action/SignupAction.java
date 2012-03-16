package action;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;



import actionform.SignupActionForm;

public class SignupAction extends Action {
         
	//private static final String Integer = null;
	//private static final String String = null;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
	
		ActionForward forward = null;
		ActionErrors errors = null;
		String fname = null;
		String lname = null;
		String  gendr = null;
		String  dob = null;
		String  vid = null;
		String pwd = null;
		 String nextPage = null;
		 
		 errors = new ActionErrors();
		/* String linkUrl = "";

			linkUrl = request.getParameter("link_url");
			System.out.println("In login Action===>link_url" + linkUrl);

			if (linkUrl != null) {
				if (linkUrl.equals("signup")) {

					nextPage = "SUCCESS";

				} else if (linkUrl.equals("logout")) {

					nextPage = "LOGOUT";
			}}*/
		 
		 SignupActionForm signupActionForm = (SignupActionForm)form;
		 
		 fname = signupActionForm.getFirstname();
		 lname = signupActionForm.getLastname();
		 gendr = signupActionForm.getGender();
		 dob = signupActionForm.getDateofbirth();
		 vid = signupActionForm.getVoterid();
		 pwd = signupActionForm.getPassword();
		 
		boolean userExist = false;
		userExist = addnewUser( fname, lname, gendr,dob, vid, pwd); 
		if (userExist) {
			nextPage = "SUCCESS";
		}
	else {
		
		nextPage = "Failure";
		}
		
		forward = mapping.findForward(nextPage);
		return forward;
		
}
	public boolean addnewUser(String fname,String lname,String gendr,String dob,String vid,String pwd)
	
	{
		boolean isUserExist = false;
		
		Connection conn = null;
		Statement sqlStmt = null;
		PreparedStatement ps = null;
		int updateQuery = 0;
		try
		{
			conn = getSQLConnection();
			String queryString = "insert into user_detail(first_name,last_name,gender,date_of_birth,voter_id,password) VALUES (?,?,?,?,?,?)";
		    ps=conn.prepareStatement(queryString);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, gendr);
			ps.setString(4, dob);
			ps.setString(5, vid);
			ps.setString(6, pwd);
		
			updateQuery = ps.executeUpdate();
			ps.close();
			
			if(updateQuery!=0)
			{
				return true;
			}
		conn.close();
		}catch(Exception ex){
			System.out.println(ex);
			ex.printStackTrace();	
		}
		
		return isUserExist;
	}
	
	
	Connection sqlCon = null;

	public Connection getSQLConnection() {

		String ConnectionURL = "jdbc:mysql://192.168.1.5:3306/sociorespo";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			sqlCon = DriverManager.getConnection(ConnectionURL, "root",
					"root");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return sqlCon;
	}
}