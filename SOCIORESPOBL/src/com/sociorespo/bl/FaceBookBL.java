package com.sociorespo.bl;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.code.facebookapi.FacebookException;
import com.google.code.facebookapi.FacebookJsonRestClient;
import com.google.code.facebookapi.ProfileField;
import com.sociorespo.dao.SocialMediaDAO;
import com.sociorespo.dto.FaceBookDTO;
import com.sociorespo.dto.ProfileDTO;


public class FaceBookBL {
	
	private static final String API_KEY = "35da82b9e7418dc5c3a10267b1c0812f";
	private static final String API_SECRET = "00d5cce69386b945539e78a7b7000bfe";
	
	private static final String AUTH_URL = "http://www.facebook.com/login.php?api_key="+API_KEY+"&v=1.0&req_perms=read_stream,publish_stream,offline_access,sms,email,user_location";

	
public FaceBookDTO initialiseFaceBook(FaceBookDTO faceBookDTO) {
		
		boolean isFaceBookConnected = false;
		String authUrl = null;
		 
		String profileId = null;
		 String adminProfileId = null; 
		 
		 Object accessToken = null;
		 Object adminAccessToken = null;
		 
		if(faceBookDTO != null){
			
			profileId = faceBookDTO.getProfileId();
			//accessToken = getAccessToken(profileId);
			
		     if(accessToken != null){
		    	 
		    	 //isFaceBookConnected = testFaceBook(accessToken.toString());

		    	 isFaceBookConnected = true;
		    	 
		    	 if(isFaceBookConnected){
					faceBookDTO = new FaceBookDTO();
					faceBookDTO.setAccessToken(accessToken);
				}else{
					faceBookDTO = new FaceBookDTO();
					faceBookDTO.setAuthUrl(AUTH_URL);
				}
			}else{
				faceBookDTO = new FaceBookDTO();
				faceBookDTO.setAuthUrl(AUTH_URL);
			}
		     
		     if(!profileId.equals(adminProfileId)){
					//adminAccessToken = getAccessToken(adminProfileId);
					faceBookDTO.setAdminAccessToken(adminAccessToken);
				}else{
					faceBookDTO.setAdminAccessToken(accessToken);
				}
		     
			
		}else{
			faceBookDTO = new FaceBookDTO();
			faceBookDTO.setAuthUrl(AUTH_URL);
		}
		
		return faceBookDTO;
		
	}

public boolean testFaceBook(String accessToken ){
	
	boolean result = false;
	FacebookJsonRestClient userClient = null;
	 JSONArray jsonArray = null;
	 
	 ProfileDTO profileDTO = null;
	try {
		 
		//userClient = getUserClient(accessToken);
		
		profileDTO = getUserProfile(userClient);
		System.out.println("Welcome "+profileDTO.getFirstName()+" "+profileDTO.getLastName()+" to FaceBook! You are successfully connected.");
		result = true;
		
	} catch (Exception e1) {
		System.out.println("Unable to connect to FaceBook..!");
		e1.printStackTrace();
	}
	
	return result;
}

/**
 * @param userClient
 * @return
 * @throws EventPortalException 
 */
private ProfileDTO getUserProfile(FacebookJsonRestClient userClient)  {
	JSONArray jsonArray = null;
	ProfileDTO profileDTO = null;
	 List currentUser= new ArrayList();
	EnumSet<ProfileField> fields1 = EnumSet.of (
			com.google.code.facebookapi.ProfileField.UID,
            com.google.code.facebookapi.ProfileField.NAME,
            com.google.code.facebookapi.ProfileField.PIC,	        
          com.google.code.facebookapi.ProfileField.CURRENT_LOCATION, 
          com.google.code.facebookapi.ProfileField.FIRST_NAME, 
          com.google.code.facebookapi.ProfileField.LAST_NAME, 
          com.google.code.facebookapi.ProfileField.HOMETOWN_LOCATION,
          com.google.code.facebookapi.ProfileField.PROFILE_URL);
	try {
		
		 Long  facebookUserID = userClient.users_getLoggedInUser();
   		 currentUser.add(facebookUserID);
   		 
		jsonArray = userClient.users_getInfo(currentUser, fields1);
		
		 try {
			 
			JSONObject obj = jsonArray.getJSONObject(0);
			profileDTO = getUserData(obj);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		
	
	}
	
	
	return profileDTO;
}




private ProfileDTO getUserData(JSONObject jsonObject){
	JSONArray jsonArray = null;
	JSONObject jsonObjectLocation = null;
	ProfileDTO profileDTO = null;
	
	try {
		if(jsonObject != null){
			
			profileDTO = new ProfileDTO();
			
			profileDTO.setProfileId(jsonObject.getString("uid"));				
			profileDTO.setFirstName(jsonObject.getString("first_name"));
			profileDTO.setLastName(jsonObject.getString("last_name"));
			profileDTO.setFaceBookImgUrl(jsonObject.getString("pic"));
			if(jsonObject.getString("current_location") != null){
				if(!jsonObject.getString("current_location").equals("null")){
					jsonObjectLocation = jsonObject.getJSONObject("current_location");
					//profileDTO.setLocation(getLocation(jsonObjectLocation));
				}else{
					//profileDTO.setLocation("");
				}
			}else{
				//profileDTO.setLocation("");
			}
			//profileDTO.setFaceBookId(jsonObject.getString("profile_url"));
		}
		
		
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return profileDTO;
}

public boolean saveAuthSession(FaceBookDTO faceBookDTO) {
	
	 int userId = 0;
	 
	 Object authToken = null;
	 Object accessToken = null;
	 
	 boolean addStatus = false;
	 
	 FacebookJsonRestClient userClient = null;
	 SocialMediaDAO socialMediaDAO = new SocialMediaDAO();
	 
	 if(faceBookDTO != null){
			
			
			userId = faceBookDTO.getUserId();
			authToken = faceBookDTO.getAuthToken();
			
			accessToken = getUserSession((String)authToken);
			
			if(accessToken != null){
				
				addStatus = socialMediaDAO.insertFaceBookKey(userId, (String)accessToken);
	
			
		}
	 }
		
	
	return addStatus;
}	



public String getUserSession(String authToken){
	
	 String authSession = null;
	 FacebookJsonRestClient userClient = null;
	 
	 userClient = new FacebookJsonRestClient(API_KEY, API_SECRET); 
	 try {
		authSession = userClient.auth_getSession(authToken);
		
	} catch (FacebookException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return authSession;
}

public ProfileDTO getFaceBookProfile(int userId) {

	SocialMediaDAO socialMediaDAO = new SocialMediaDAO();
	 ProfileDTO profileDTO = null;
	
	String authKey = null;
	
	authKey = socialMediaDAO.getFaceBookAccessToken(userId);
	
	profileDTO = getPublicProfile(authKey);
	
	
	return profileDTO;
}





public ProfileDTO getPublicProfile(String authKey){
	String profileURL = null;
	
	FacebookJsonRestClient userClient = null;
	 JSONArray jsonArray = null;
	 
	 ProfileDTO profileDTO = null;
	try {
		 
		userClient = getUserClient(authKey);
		
		profileDTO = getUserProfile(userClient);
		
		//profileURL = profileDTO.getFaceBookId();

		if(profileURL == null){
			//profileURL = "http://www.facebook.com/"+profileDTO.getProfileId();
			
			profileURL = "http://www.facebook.com/people/"+profileDTO.getFirstName()+"-"+profileDTO.getLastName()+"/"+profileDTO.getProfileId();
			//http://www.facebook.com/people/Manimaran-Malaichamy/100000858117720
	
		}
		
		
	} catch (Exception e1) {
		System.out.println("Unable to connect to FaceBook..!");
		e1.printStackTrace();
	}
	
	return profileDTO;
	
}


public FacebookJsonRestClient getUserClient(String authSession){
	
	FacebookJsonRestClient userClient = null;
	
	userClient = new FacebookJsonRestClient(API_KEY, API_SECRET, authSession); 
	
	return userClient;
}


	
}
