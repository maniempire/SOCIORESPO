package action;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import dto.ProfileDTO;
import actionform.ProfileActionForm;

public class ProfileAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		ActionErrors errors = null;
		String nextPage = null;
		ProfileDTO profileDTO = null;
		
		List myList = null;
		
       errors = new ActionErrors();
		
      ProfileActionForm profileActionForm = (ProfileActionForm)form;
		
       String linkUrl = "";

		linkUrl = request.getParameter("link_url");
		System.out.println("In login Action===>link_url" + linkUrl);

		if (linkUrl != null) {

			if (linkUrl.equals("my_info")) {

				
				String firstname = null; 
				profileDTO = getMyprofile(firstname);
				profileActionForm.setProfileDTO(profileDTO);
				nextPage = "PROFILE";
			}
				else if (linkUrl.equals("emp_list")) {

					myList = getEmployees();

					profileActionForm.setMyList(myList);

					nextPage = "EMPLIST";

				} else if (linkUrl.equals("home")) {

					nextPage = "SUCCESS";

				} else if (linkUrl.equals("logout")) {

					nextPage = "LOGOUT";

				} else {
					nextPage = "Failure";
				}

		}
		
		
		
		return forward;
	
	}
	
	
	//Connection sqlCon = null;

	public Connection getSQLConnection() {

		String ConnectionURL = "jdbc:mysql://localhost:3306/sociorespo";
		Connection sqlCon = null;
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
	


public ProfileDTO getMyprofile(String UserId)
           {
	
	ProfileDTO profileDTO = null;
	 String firstname = null; 
	 String lastname = null; 
	 String gender = null; 
	 String dateofbirth = null; 
     String voterid = null; 
	
	Connection conn = null;
	Statement sqlStmt = null;
	ResultSet rs = null;
	Statement stmt = null;

	try {

		profileDTO = new ProfileDTO();
		conn = getSQLConnection();
		Connection sqlCon = null;
		sqlStmt = sqlCon.createStatement();
	 
		rs = sqlStmt.executeQuery("select * from employee where first_name='"
				+ firstname + "'");
	
		while (rs.next()) {
			firstname = rs.getString(1);
			lastname = rs.getString(2);
			gender = rs.getString(3);
			dateofbirth = rs.getString(4);
			voterid = rs.getString(5);
	
	          profileDTO.setFirstname(firstname);
	          profileDTO.setLastname(lastname);
	          profileDTO.setGender(gender);
	          profileDTO.setDateofbirth(dateofbirth);
	          profileDTO.setVoterid(voterid);
		}

		conn.close();

	} catch (Exception e) {
		System.out.println(e);
		e.printStackTrace();
	}

	
	
	
	
	return profileDTO;
	
	

           }

  public List getEmployees() {

	  List myList = new ArrayList();
	     String firstname = null; 
		 String lastname = null; 
		 String gender = null; 
		 String dateofbirth = null; 
	     String voterid = null;
	     Connection conn = null;
	     Connection sqlCon = null;
			Statement sqlStmt = null;
			ResultSet rs = null;
			Statement stmt = null;
			
			ProfileDTO proDTO = null;
			
			
			try {

				conn = getSQLConnection();
				sqlStmt = sqlCon.createStatement();
				rs = sqlStmt.executeQuery("select * from user_detail");
				while (rs.next()) {
				
					proDTO = new ProfileDTO();
					firstname = rs.getString(1);
					lastname = rs.getString(2);
					gender = rs.getString(3);
					dateofbirth= rs.getString(4);
					voterid=rs.getString(5);

					proDTO.setFirstname(firstname);
					proDTO.setLastname(lastname);
					proDTO.setGender(gender);
					proDTO.setDateofbirth(dateofbirth);
					proDTO.setVoterid(voterid);
					
					myList.add(proDTO);	
					
					System.out.println("firstname:" + firstname + "\t" + "lastname:"
							+lastname+ "\t" + "gender:" + gender
							+ "\t" + "dateofbirth:"+dateofbirth+"\t"+ 
							"voterid:"+voterid+"\t");
				}


				conn.close();

			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}

			return myList;

      }

}

