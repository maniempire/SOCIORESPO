package com.sociorespo.bl;

import twitter4j.Twitter;
import twitter4j.TwitterException;
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
	
}
