package actionform;

import java.util.*;

import dto.ProfileDTO;
import org.apache.struts.action.ActionForm;


public class ProfileActionForm extends ActionForm {

	private ProfileDTO profileDTO = null;
	private List myList = null;

	public List getMyList() {
		return myList;
	}

	public void setMyList(List myList) {
		this.myList = myList;
	}

	public ProfileDTO getProfileDTO() {
		return profileDTO;
	}

	public void setProfileDTO(ProfileDTO profileDTO) {
		this.profileDTO = profileDTO;
	}
}
