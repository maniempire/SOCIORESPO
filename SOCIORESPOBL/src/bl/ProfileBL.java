package bl;

import java.util.ArrayList;
import java.util.List;

import dao.ProfileDAO;

public class ProfileBL {

		public boolean empUpdateProfile(String userId, String oldPwd,String moblie,String landLine,String personalMail,String officeMail,String permanentAddress,String contactAddress,String newPwd,String confirmPwd,String accNum,String pfNum){
			boolean result ;
			ProfileDAO profileDAO = new ProfileDAO();
			result =profileDAO.empUpdateProfile(userId,oldPwd,moblie,landLine,personalMail,officeMail,permanentAddress,contactAddress,newPwd,confirmPwd,accNum,pfNum);
			return result;
		}
}
