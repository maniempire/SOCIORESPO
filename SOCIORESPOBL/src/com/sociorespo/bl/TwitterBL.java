package com.sociorespo.bl;

import com.sociorespo.dao.SocialMediaDAO;
import com.sociorespo.dto.PostDTO;
import com.sociorespo.dto.ProfileDTO;
import com.sociorespo.dto.TwitterDTO;

import twitter4j.Status;
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
			authUrl = requestToken.getAuthorizationURL();
			
		} catch (TwitterException e) {
			
			//processTwitterException(e);	
		}

		
		
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
		
		//testTwitter(accessToken);
		
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

public boolean isTwitterConnected(String userId) {
	
	SocialMediaDAO socialMediaDAO = new SocialMediaDAO(); 
	boolean twitterConnected = false;
	
	twitterConnected = socialMediaDAO.isTwitterConnected(userId);
	
	return twitterConnected;
}

public ProfileDTO getUserTwitterProfileDetails(String userId) {
	ProfileDTO profileDTO = null;
	User profile = null;
	AccessToken accessToken = null;

	try {
		
		accessToken = getTwitterAccessToken(userId);
		
		twitter.setOAuthAccessToken(accessToken);
		profile = twitter.verifyCredentials();
		profile = twitter.showUser(profile.getId());
	} catch (TwitterException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	profileDTO = getProfile(profile);
	
	return profileDTO;
}


public AccessToken getTwitterAccessToken(String userId){
	AccessToken accessToken = null;
	SocialMediaDAO socialMediaDAO = new SocialMediaDAO(); 
	TwitterDTO twitterDTO = null;
	String tokenSecret = null;
	String token = null;
	
	twitterDTO = socialMediaDAO.getTwitterTokens(userId);
	
	
	if(twitterDTO != null){
		token = twitterDTO.getToken();
		tokenSecret = twitterDTO.getTokenSecret();
	
		try {
			
			accessToken = twitter.getOAuthAccessToken(token,tokenSecret);
			
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	return accessToken;
	
}

	public ProfileDTO getProfile(User profile){
	ProfileDTO profileDTO = null;
	if(profile != null){
		
		profileDTO = new ProfileDTO();
		
		profileDTO.setProfileId(String.valueOf(profile.getId()));
		profileDTO.setFirstName(profile.getName());
		profileDTO.setTwitterImgUrl(profile.getProfileImageURL().toString());
		
				
	}
	
	return profileDTO;
	}

	public boolean addTwitterToken(String oauthToken, String oAuthVerifier, String userId) {
		
		SocialMediaDAO socialMediaDAO = new SocialMediaDAO(); 
		boolean twitterAddStatus = false;
		
		//twitterAddStatus = socialMediaDAO.addTwitterToken(oauthToken, oAuthVerifier, userId);
		
		return twitterAddStatus;
	}
	
	
public AccessToken addTwitterToken(String oauthToken, String oAuthVerifier) {
		AccessToken accessToken = null;
		SocialMediaDAO socialMediaDAO = new SocialMediaDAO(); 
		boolean twitterAddStatus = false;
		
		//twitterAddStatus = socialMediaDAO.addTwitterToken(oauthToken, oAuthVerifier, userId);
		
		try {
			accessToken = twitter.getOAuthAccessToken(oauthToken,oAuthVerifier);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return accessToken;
	}
	
	
	public boolean shareMsgInTwitter(PostDTO postDTO, AccessToken accessToken){
		
		boolean twitterShareStatus = false;
		ProfileDTO profileDTO = null;
		User profile = null;
		//AccessToken accessToken = null;

		try {
			
			//accessToken = getTwitterAccessToken(String.valueOf(postDTO.getUserId()));
			
			twitter.setOAuthAccessToken(accessToken);

			profile = twitter.verifyCredentials();
			
			twitterShareStatus = shareMsgInTwitter( twitter,postDTO.getContent());
			
			//profile = twitter.showUser(profile.getId());
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//profileDTO = getProfile(profile);
		
		return twitterShareStatus;
	}
	
	public boolean shareMsgInTwitter(Twitter twitter,String Msg){
 	
    boolean result = false;
    Status status = null;
    try {
     if(Msg!=null){
     status = twitter.updateStatus(Msg);
     result = true;
     }
    } catch (TwitterException e) {
     result=false;
     System.out.println("Exception while updating the status to [" + status.getText() + "].");
     e.printStackTrace();
    }  
   return result;
   }

	public ProfileDTO getUserTwitterProfileDetails(AccessToken accessToken) {
		ProfileDTO profileDTO = null;
		User profile = null;
		

		try {
			
			
			
			twitter.setOAuthAccessToken(accessToken);
			profile = twitter.verifyCredentials();
			profile = twitter.showUser(profile.getId());
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		profileDTO = getProfile(profile);
		
		return profileDTO;
	}

	
}
