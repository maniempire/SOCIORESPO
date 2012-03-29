package com.sociorespo.bl;

import com.google.code.linkedinapi.client.oauth.LinkedInOAuthService;
import com.google.code.linkedinapi.client.oauth.LinkedInOAuthServiceFactory;
import com.google.code.linkedinapi.client.oauth.LinkedInRequestToken;
import com.sociorespo.dto.LinkedInDTO;

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
	
    
    public String getLinkedInAuthURL(String baseURL){
		//String AUTHORIZE_URL = "https://api.linkedin.com/uas/oauth/authorize?oauth_token=";
       
		//LinkedInDTO linkedInDTO = null;
		String token = null;
		String tokenSecret = null;		
		String authUrl = null; 

		//LinkedInRequestToken requestToken = oauthService.getOAuthRequestToken();
		//String baseURL = null;
		baseURL = baseURL+"/linkedInAction.do";
		//baseURL = linkedInDTO.getBaseURL()+"/views/config_linkedin_callback.jsf";
		LinkedInRequestToken requestToken = oauthService.getOAuthRequestToken(baseURL);
		//LinkedInRequestToken requestToken = oauthService.getOAuthRequestToken("http://ec2-50-16-39-131.compute-1.amazonaws.com:8080/EVENTPORTAL/views/linkedIn_connect.jsf");
		//linkedInDTO = new LinkedInDTO();
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
		return authUrl;
	}
	
	
}
