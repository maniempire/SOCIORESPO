package com.sociorespo.bl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.code.facebookapi.Attachment;
import com.google.code.facebookapi.FacebookException;
import com.google.code.facebookapi.FacebookJsonRestClient;
import com.google.code.facebookapi.ProfileField;
import com.sociorespo.dao.PostDAO;
import com.sociorespo.dao.SocialMediaDAO;
import com.sociorespo.dto.PostDTO;
import com.sociorespo.dto.ProfileDTO;

public class PostBL {
	
	private static final String API_KEY = "35da82b9e7418dc5c3a10267b1c0812f";
	private static final String API_SECRET = "00d5cce69386b945539e78a7b7000bfe";
	
	private static final String AUTH_URL = "http://www.facebook.com/login.php?api_key="+API_KEY+"&v=1.0&req_perms=read_stream,publish_stream,offline_access,sms,email,user_location";

	public PostDTO getinsertTag(PostDTO postDTO) {
		
		PostDAO postDAO = new PostDAO();
		FaceBookBL faceBookBL = new FaceBookBL();
		ProfileDTO profileDTO=null;
		
		postDTO = postDAO.insertPostTage(postDTO);
		if(postDTO.isTagInsert()==true){
			if(postDTO.isShareFacebook()==true){
				//profileDTO=getFaceBookProfile(postDTO);
				profileDTO=faceBookBL.getFaceBookProfile(postDTO);
			}else if(postDTO.isShareTwitter()==true){
				//profileDTO.getTwitterProfileUrl(postDTO);
			}else if(postDTO.isShareLinkedIn()==true){
				//profileDTO.getLinkedInProfileUrl(postDTO);
			}
		}
		
		return postDTO;
	}

	public List getTagList(PostDTO postDTO) {
		
		PostDAO postDAO = new PostDAO();
			
		List tagList;
		ProfileDTO profileDTO=null;
		//profileDTO=getFaceBookProfile(postDTO);
		
		tagList = postDAO.getTagList(postDTO);
		
		return tagList;
	}


	
	
	
	
	
	
	
	
	
	
	

public ProfileDTO getFaceBookProfile(PostDTO postDTO) {

	SocialMediaDAO socialMediaDAO = new SocialMediaDAO();
	// ProfileDTO profileDTO = null;
	ProfileDTO profileDTO=new ProfileDTO();
	
	String authKey = null;
	int userid = postDTO.getUserId();
	
	authKey = socialMediaDAO.getFaceBookAccessToken(userid);
	profileDTO.setAuthKey(authKey);
	profileDTO.setContent(postDTO.getContent());
	
	profileDTO = getPublicProfile(profileDTO);
	
	
	return profileDTO;
}



public ProfileDTO getPublicProfile(ProfileDTO profileDTO){
	String profileURL = null;
	
	FacebookJsonRestClient userClient = null;
	 JSONArray jsonArray = null;
	 
	//ProfileDTO profileDTO = null;
	try {
		String content=profileDTO.getContent();
		userClient = getUserClient(profileDTO.getAuthKey());
		
		profileDTO = getUserProfile(userClient);
		if(content!=null){
			shareMsg(userClient,content,null, null);
		}
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


public boolean shareMsg(FacebookJsonRestClient userClient, String message, Attachment attachment, Collection actionLinks){
	boolean resultSts = false;
	long userId = 0;

	 long targetId = 0;
	try {
		userId = userClient.users_getLoggedInUser();
		targetId = userId;
		userClient.stream_publish(message, attachment, actionLinks, targetId, userId);
		resultSts = true;
	
	} catch (FacebookException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return resultSts;
}

public PostDTO getinsertComplaint(PostDTO postDTO) {
	PostDAO postDAO = new PostDAO();
	
	postDTO = postDAO.insertComplaint(postDTO);
	
	return postDTO;
}

public List getComplaintList(PostDTO postDTO) {
	PostDAO postDAO = new PostDAO();
	
	List complaintList;
		
	complaintList = postDAO.getComplaintList(postDTO);
	
	return complaintList;
}

public PostDTO insertDebate(PostDTO postDTO) {
	
	PostDAO postDAO = new PostDAO();
	
	postDTO = postDAO.insertDebate(postDTO);
	
	return postDTO;
}

public List getDebateList(PostDTO postDTO) {
	
	PostDAO postDAO = new PostDAO();
	
	List debateList;
		
	debateList = postDAO.getDebateList(postDTO);
	
	return debateList;
}

public List getUserList(PostDTO postDTO) {
	PostDAO postDAO = new PostDAO();
	
	List userList;
		
	userList = postDAO.getUserList(postDTO);
	
	return userList;
	
}

public List getTitleList() {
	
PostDAO postDAO = new PostDAO();
	
	List titleList;
		
	titleList = postDAO.getTitleList();
	
	return titleList;
}



}