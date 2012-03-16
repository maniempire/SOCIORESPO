package dao;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class MyprofileDAO extends DataAccessObject {
	
	
	public String loginUser(String EmployeeID, String FirstName, String LastName,String EmployeeType,String Designation,String Team,String Reportingto,String OfficialEmail,String DOB,String DOJ,String Gender,String BloodGroup,String OldPassword,String MobilePhone,String ResidencePhone,String PersonalEmail,String PermanantAddress,String ContactAddress,String Newpassword,String Confirmpassword,String Accnumber,String PFNumber){
		String tempEmployeeID = null;
		String tempFirstName =null;
		String tempLastName =null;
		String tempEmployeeType =null;
		String tempDesignation =null;
		String tempTeam =null;
		String tempReportingto =null;
		String tempOfficialEmail =null;
		String tempDOB =null;
		String tempDOJ =null;
		String tempGender =null;
		String tempBloodGroup =null;
		String tempOldPassword =null;
		String tempMobilePhone =null;
		String tempResidencePhone =null;
		String tempPersonalEmail =null;
		String tempPermanantAddress =null;
		String tempContactAddress =null;
		String tempNewpassword =null;
		String tempConfirmpassword =null;
		String tempAccnumber =null;
		String tempPFNumber =null;
		String result;
		Connection conn=null;
		
		ResultSet rs=null;
		Statement stmt=null;
		//String ConnectionURL="jdbc:db2://192.168.1.169:50000/PIM";
				
		try
		{
			conn = getSQLConnection();
			//Class.forName("com.ibm.db2.jcc.DB2Driver");
			//conn=DriverManager.getConnection(ConnectionURL, "dba","visiondba");
			stmt =conn.createStatement();
			rs=stmt.executeQuery("select * from EMPLOYEE_PERSONAL_DETAILS where EPD_EMP_ID= '"+EmployeeID+"' and EPD_DOB='"+DOB+"' and EPD_BLOOD_GROUP='"+BloodGroup+"' and EPD_PHONE_NO='"+ResidencePhone+"'"  );
			
			
			while(rs.next()){
				 tempEmployeeID=rs.getString(2);
				 tempDOB=rs.getString(4);
			}
			
		}catch (Exception e){
			System.out.println(e);
		}finally {
			if(rs!=null && conn!=null)
				try
			{
					rs.close();
					conn.close();
					System.out.println("Database connection is Disconnected");
		}
			catch(SQLException ex){
				System.out.println(ex);
			}
		}
		if(EmployeeID.equals(tempEmployeeID) && DOB.equals(tempDOB)){
			result = "true";
		}else{
			result = "false";
		}
		return result;
	}
	
}




