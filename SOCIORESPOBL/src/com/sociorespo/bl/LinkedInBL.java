package com.sociorespo.bl;

import java.security.GeneralSecurityException;
import java.util.EnumSet;
import java.util.List;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientFactory;
import com.google.code.linkedinapi.client.enumeration.ProfileField;
import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;
import com.google.code.linkedinapi.client.oauth.LinkedInOAuthService;
import com.google.code.linkedinapi.client.oauth.LinkedInOAuthServiceFactory;
import com.google.code.linkedinapi.client.oauth.LinkedInRequestToken;
import com.google.code.linkedinapi.schema.Location;
import com.google.code.linkedinapi.schema.Person;
import com.sociorespo.dao.SocialMediaDAO;
import com.sociorespo.dto.LinkedInDTO;
import com.sociorespo.dto.ProfileDTO;

public class LinkedInBL {

	final String CONSUMER_KEY = "FLbA3YVCb-dS8-nv7KPvjBFLJmaEXXXWvboyWlQUZzXrNARkCl65xsg26eb3qF_7";
    final String CONSUMER_SECRET = "9n8ItOvtCEHnrqbF532klHSAGaWBX36zd02une-gmakMAS7xUEjD2kD4VHPZuJom";
   
    final LinkedInOAuthService oauthService;
    
    
    public LinkedInBL(){
    	oauthService = LinkedInOAuthServiceFactory.getInstance().createLinkedInOAuthService(CONSUMER_KEY, CONSUMER_SECRET);
    }
    
    public LinkedInDTO connectLinkedIn(LinkedInDTO linkedInDTO){
		String AUTHORIZE_URL = "https://api.linkedin.com/uas/oauth/authorize?oauth_token=";
       
		//LinkedInDTO linkedInDTO = null;
		String token = null;
		String tokenSecret = null;		
		String authUrl = null; 

		//LinkedInRequestToken requestToken = oauthService.getOAuthRequestToken();
		String baseURL = null;
		
		//baseURL = linkedInDTO.getBaseURL()+"/views/config_linkedin_callback.jsf";
		LinkedInRequestToken requestToken = oauthService.getOAuthRequestToken(baseURL);
		//LinkedInRequestToken requestToken = oauthService.getOAuthRequestToken("http://ec2-50-16-39-131.compute-1.amazonaws.com:8080/EVENTPORTAL/views/linkedIn_connect.jsf");
		linkedInDTO = new LinkedInDTO();
        token = requestToken.getToken();
        tokenSecret = requestToken.getTokenSecret();
        authUrl = requestToken.getAuthorizationUrl(); 
        
        System.out.println("Request token: " + token); 
        System.out.println("Token secret: " + tokenSecret);         
        System.out.println("authUrl: " + authUrl);
        
//        linkedInDTO.setToken(token);
//        linkedInDTO.setTokenSecret(tokenSecret);
//        linkedInDTO.setAuthUrl(authUrl);
//        linkedInDTO.setRequestToken(requestToken);
//        
		return linkedInDTO;
	}
	
    
    public LinkedInDTO getLinkedInAuthURL(ProfileDTO profileDTO){
		//String AUTHORIZE_URL = "https://api.linkedin.com/uas/oauth/authorize?oauth_token=";
       
		LinkedInDTO linkedInDTO = null;
		String token = null;
		String tokenSecret = null;		
		String authUrl = null; 

		//LinkedInRequestToken requestToken = oauthService.getOAuthRequestToken();
		String baseURL = null;
		baseURL = profileDTO.getBaseURL()+"/linkedInAction.do";
		//baseURL = linkedInDTO.getBaseURL()+"/views/config_linkedin_callback.jsf";
		LinkedInRequestToken requestToken = oauthService.getOAuthRequestToken(baseURL);
		//LinkedInRequestToken requestToken = oauthService.getOAuthRequestToken("http://ec2-50-16-39-131.compute-1.amazonaws.com:8080/EVENTPORTAL/views/linkedIn_connect.jsf");
		linkedInDTO = new LinkedInDTO();
        token = requestToken.getToken();
        tokenSecret = requestToken.getTokenSecret();
        authUrl = requestToken.getAuthorizationUrl(); 
        
//        System.out.println("Request token: " + token); 
//        System.out.println("Token secret: " + tokenSecret);         
//        System.out.println("authUrl: " + authUrl);
//        linkedInDTO.setUserId(profileDTO.getUserId());
//        linkedInDTO.setToken(token);
//        linkedInDTO.setTokenSecret(tokenSecret);
        linkedInDTO.setAuthUrl(authUrl);
        linkedInDTO.setRequestToken(requestToken);
        
        //linkedInDTO = addToken(linkedInDTO);
//        
		return linkedInDTO;
	}
	
    
    public LinkedInDTO addToken(LinkedInDTO linkedInDTO) {
    	
 	   boolean addStatus = false;
 	   String oauthVerifier = null;
 	   String profileId = null;
 	   LinkedInRequestToken requestToken = null;
 	   LinkedInAccessToken accessToken = null;
 	   String userAccessToken = null;
 	   String profileURL = null;
 		
 		if(linkedInDTO != null){
 			//profileId = linkedInDTO.getProfileId();
 			 oauthVerifier = linkedInDTO.getOauthVerifier();
 			 requestToken =  (LinkedInRequestToken) linkedInDTO.getRequestToken();
 		}
 	   
 	   accessToken = oauthService.getOAuthAccessToken(requestToken, oauthVerifier);
 	   
 	   //Keys keys = new Keys();
 	   SocialMediaDAO socialMediaDAO = new SocialMediaDAO();
 	   /*keys.setHiddenObject("LINKEDIN");
 	   keys.setLinkedInAccessToken(accessToken);
 	   keys.setProfileId(profileId);*/
 	   int userId = linkedInDTO.getUserId();
 	   
 	   //userAccessToken = linkedInDTO.getAccessToken().toString();
 	   
 	  // addStatus = socialMediaDAO.saveLinkedInAccessToken(userId,userAccessToken);
 	   
 	  addStatus = socialMediaDAO.saveLinkedInAccessToken(userId,oauthVerifier);
 	   
 	   if(addStatus){
 		   //accessToken = getAccessToken(profileId);
 		  
 		  //profileURL = getPublicProfile(accessToken);
 		  
 		  Person profile = getProfile(accessToken);
 		  
 		 /* if(profile != null){
 			  addStatus = updatePublicProfile(profile.getId(),profile.getPublicProfileUrl(), profile.getPictureUrl() ,profileId);
 		  }*/
 		   
 		   //addStatus = updatePublicProfile(profileURL, profileId);
 		   
 		   linkedInDTO.setAccessToken(accessToken);			
 		   linkedInDTO.setAddStatus(addStatus);	
 	   }
 	   
 	return linkedInDTO;
 }
	
    
    public Person getProfile(LinkedInAccessToken accessToken){
		 
		String profileURL = null;
		LinkedInApiClient client = null;
		Person profile = null;
		Person profile2 = null;
		
		try{
		
			client = getLinkedInApiClient(accessToken);
			
			 profile = client.getProfileForCurrentUser(EnumSet.of(ProfileField.ID));
			profile2 = client.getProfileById(profile.getId(), EnumSet.of(ProfileField.ID, ProfileField.FIRST_NAME, ProfileField.LAST_NAME, ProfileField.HEADLINE, ProfileField.INDUSTRY, ProfileField.CURRENT_STATUS, ProfileField.CURRENT_STATUS_TIMESTAMP,ProfileField.API_STANDARD_PROFILE_REQUEST, ProfileField.EDUCATIONS,ProfileField.PUBLIC_PROFILE_URL, ProfileField.POSITIONS, ProfileField.LOCATION, ProfileField.PICTURE_URL));
			
			 profileURL = profile2.getPublicProfileUrl();
			 
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		return profile2;
	}
    
public LinkedInApiClient getLinkedInApiClient(LinkedInAccessToken accessToken){
		
		final LinkedInApiClientFactory factory = LinkedInApiClientFactory.newInstance(CONSUMER_KEY, CONSUMER_SECRET); 
		   final LinkedInApiClient client = factory.createLinkedInApiClient(accessToken);

		   return client;
	}
	
	public LinkedInDTO getLinkedInDetails(LinkedInDTO linkedInDTO) {
		ProfileDTO profileDTO = null;
		LinkedInAccessToken accessToken = null;
		 LinkedInApiClient client = null;
		 List friendsList = null;
		 int friendsCount = 0;
		 if(linkedInDTO != null){
			 
			 accessToken = (LinkedInAccessToken)linkedInDTO.getAccessToken();
			 
			 if(accessToken != null){

				 client = getLinkedInApiClient(accessToken);
				 
				 profileDTO = getUserLinkedInProfile(client);
				 //friendsList = getFriendsProfile(client);
				 //friendsCount = friendsCount(client);

				 linkedInDTO = new LinkedInDTO();
				 linkedInDTO.setProfileDTO(profileDTO);
				 //linkedInDTO.setFriendsList(friendsList);
				 //linkedInDTO.setFriendsCount(String.valueOf(friendsCount));
			 }
		 }
		
		
		return linkedInDTO;
	}


private ProfileDTO getUserLinkedInProfile(LinkedInApiClient client) {
		
		ProfileDTO profileDTO = null;
		Person profile = null;
		
		 profile = getUserProfile(client);
		 
		 profileDTO = getProfileData(profile);
		
		return profileDTO;
	}	
    

public Person  getUserProfile(LinkedInApiClient client){
	 client.getRequestHeaders();
	 
	 Person initProfile = client.getProfileForCurrentUser(EnumSet.of(ProfileField.ID));
	 System.out.print("Current User-Id >>"+initProfile.getId());
    Person userprofile = client.getProfileById(initProfile.getId(), EnumSet.of(ProfileField.FIRST_NAME,ProfileField.LAST_NAME,ProfileField.HEADLINE,ProfileField.INDUSTRY,ProfileField.API_STANDARD_PROFILE_REQUEST, ProfileField.PICTURE_URL, ProfileField.PUBLIC_PROFILE_URL, ProfileField.LOCATION,ProfileField.CONNECTIONS));
   // printResult(userprofile);
	 
	 return userprofile;
	 
 
  }


public ProfileDTO getProfileData(Person profile){
	
	ProfileDTO profileDTO = null;
	
	if(profile != null){
		
		profileDTO = new ProfileDTO();
		
		profileDTO.setProfileId(profile.getId());
		profileDTO.setFirstName(profile.getFirstName());
		profileDTO.setLastName(profile.getLastName());
		profileDTO.setLinkedInImgUrl(profile.getPictureUrl());
		
	}
	
	return profileDTO;
}

public boolean isLinkedInConnected(String userId) {
	
	SocialMediaDAO socialMediaDAO = new SocialMediaDAO(); 
	boolean linkedInConnected = false;
	
	linkedInConnected = socialMediaDAO.isLinkedInConnected(userId);
	
	return linkedInConnected;
}

public ProfileDTO getUserLinkedInProfileDetails(
		Object linkedInRequestToken, String userId) {
	
	LinkedInAccessToken accessToken = null;
	 LinkedInApiClient client = null;
	 ProfileDTO profileDTO = null;
	
	accessToken =  getLinkedInAccessToken(linkedInRequestToken, userId);
	
	client = getLinkedInApiClient(accessToken);
	 
	 profileDTO = getUserLinkedInProfile(client);
	
	return profileDTO;
}

public LinkedInAccessToken getLinkedInAccessToken(Object linkedInRequestToken, String userId){
	
	LinkedInAccessToken accessToken = null;
	LinkedInRequestToken requestToken = null;
	String oauthVerifier = null;
	SocialMediaDAO socialMediaDAO = new SocialMediaDAO(); 
			
			 oauthVerifier = socialMediaDAO.getOauthVerifier(userId);
			 
			 requestToken =  (LinkedInRequestToken) linkedInRequestToken;
	
	   
	   accessToken = oauthService.getOAuthAccessToken(requestToken, oauthVerifier);
	   
	return accessToken;
}

public LinkedInDTO initLinkedIn(String baseURL) {
	
	
	LinkedInDTO linkedInDTO = null;	
	String authUrl = null; 

	baseURL = baseURL+"/linkedInAction.do";
	
	LinkedInRequestToken requestToken = oauthService.getOAuthRequestToken(baseURL);
	
	linkedInDTO = new LinkedInDTO();
   
    authUrl = requestToken.getAuthorizationUrl(); 
    

    linkedInDTO.setAuthUrl(authUrl);
    linkedInDTO.setRequestToken(requestToken);
    
     
	return linkedInDTO;
	
}

    
}
