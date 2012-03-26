package com.sociorespo.bl;

import com.sociorespo.dto.ProfileDTO;
import com.sociorespo.dao.ProfileDAO;

public class ProfileBL {
	
	
	public ProfileDTO insertUserProfile(ProfileDTO profileDTO){
		
		boolean userProfile=false;
		ProfileDAO profileDAO = new ProfileDAO();
		
		if(profileDTO != null){
			
			profileDTO = profileDAO.insertUserProfile(profileDTO);
		}
		
		return profileDTO;
	}

	public ProfileDTO getUserProfile(ProfileDTO profileDTO) {
		
		ProfileDAO profileDAO = new ProfileDAO();
		profileDTO=profileDAO.getuserProfile(profileDTO);
		
		return profileDTO;
	}
	
public ProfileDTO updateProfile(ProfileDTO profileDTO) {
		
		ProfileDAO profileDAO = new ProfileDAO();
		profileDTO=profileDAO.updateProfile(profileDTO);
		
		return profileDTO;
	}

	
}
