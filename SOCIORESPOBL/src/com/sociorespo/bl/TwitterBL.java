package com.sociorespo.bl;

import com.sociorespo.dto.TwitterDTO;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.http.AccessToken;
import twitter4j.http.RequestToken;

public class TwitterBL {

	 Twitter twitter = null;

		private static final String CONSUMER_KEY = "842CPqEwrBDFQ6MYV64ZLw";
		private static final String CONSUMER_SECRET = "Xdy2WxNzLAgo7lDPSnWQUSB1wOFoLwMbvIrg1yiyU";

		 
		 public TwitterBL(){
	     twitter = new Twitter();
		 twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
	   	}
	
public String initAuthUrl() {
		
		RequestToken requestToken = null;
		
		String authUrl = null;
		
		
		try {			
			
			requestToken = twitter.getOAuthRequestToken();
			
		} catch (TwitterException e) {
			
			//processTwitterException(e);	
		}

		authUrl = requestToken.getAuthorizationURL();
		
		return authUrl;
	}

public TwitterDTO addToken(TwitterDTO twitterDTO) {
	
	AccessToken accessToken = null; 	
	String tokenSecret = null;
	String token = null;
	String profileId = null;
	String profileURL = null;
	String profileImgURL = null;
	String twitterId = null;

	try {
		
		token = twitterDTO.getToken();
		tokenSecret = twitterDTO.getTokenSecret();
		
		accessToken = twitter.getOAuthAccessToken(token,tokenSecret);
		profileId = twitterDTO.getProfileId();
		 testTwitter(accessToken);
		
//		Keys keys = new Keys();
//		
//		keys.setHiddenObject("TWITTER");
//		keys.setTwitterAccessToken(accessToken);
//		keys.setProfileId(profileId);
//		boolean retSts = keys.saveTwitterAccessToken(keys);
//		
//		if(retSts){
//			//accessToken = getAccessToken(profileId);
//			
//			twitterId = getTwitterId(accessToken);
//			
//			//profileURL = getPublicProfile(accessToken);
//			
//			profileURL = "http://twitter.com/intent/user?screen_name="+twitterId;
//			
//			profileImgURL = profileImageURL(accessToken);
//			
//			retSts = updatePublicProfile(twitterId, profileImgURL,profileURL,profileId);			
//			
//			twitterDTO.setAccessToken(accessToken);
//					
//			//twitterDTO = getProfileImageURL(accessToken);
//			
//			twitterDTO.setAddStatus(retSts);
//			
//			
//		}
		
	
	} catch (TwitterException e) {
		// TODO Auto-generated catch block
		
	}
	
	return twitterDTO;
}

public boolean testTwitter(AccessToken accessToken) 	{
	boolean result = false;
  User user = null;
try {
	 twitter.setOAuthAccessToken(accessToken);
	 user = twitter.verifyCredentials();
	 System.out.println("Welcome "+user.getName()+" to Twitter! You are successfully connected.");
	 result = true;
	   
	  } catch (TwitterException e) {
		  
	   System.out.println("Unable to connect to Twitter..!");
	  }

return result;

}
	
}
