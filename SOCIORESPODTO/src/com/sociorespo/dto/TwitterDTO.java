package com.sociorespo.dto;


import java.io.Serializable;
import java.util.List;

/**
 * Class Description
 *    
 * @version 1.0
 * @author mmanimaran
 * @Date Oct 5, 2010
 * 
 * Copyright 2010-2011 Kyyba Ventures,Inc. All Rights Reserved.
 * This software is the proprietary information of Kyyba Ventures Inc.
 * Use is subject to license terms.
 */
public class TwitterDTO  {
		
		String userName = null;
		String tweet = null;
		String tweetCreatedAt = null;
		String userImg = null;		
		String userScreeName= null;	
		String userLocation= null;	
		String userURL= null;
		String userBio= null;
		String userBgImgUrl = null;
		String userDesc = null;
		String userBgColor = null;
		String tweetId = null;
		String followingCount = null;	
		String followersCount = null;
        String userFavCount = null;
        String personalUrl =null;
		String token = null;
		String tokenSecret = null;
		String authUrl = null;
		String searchTweet = null;		
		String sessionTweetTag = null;
		String sessionEventTweetTag = null;
		Object accessToken = null;
		String userTimeZone = null;
		Object adminAccessToken = null;
		String resultMessage = null;
		String[] eventTags = null;
		
		boolean isConnected = false;
		
		boolean addStatus = false;
		boolean deleteStatus = false;
		
		boolean friendInvited = false;
		boolean alreadyFriends = false;
		boolean friendIsFollowing = false;
		boolean shareMsg = false;
		String  alreadyFollowingInTwitterMsg = null;
		private String profileId = null;	
		private String adminProfileId = null;
		
		private String shareComment = null;
		private String inviteMessage = null;
		
		private ProfileDTO profileDTO = null;
		
		private List friendsList = null;
		private List followersList = null;
		private List tweetList = null;
		
		
		
		
		public boolean isAlreadyFriends() {
			return alreadyFriends;
		}

		public void setAlreadyFriends(boolean alreadyFriends) {
			this.alreadyFriends = alreadyFriends;
		}

		public String getSearchTweet() {
			return searchTweet;
		}

		public void setSearchTweet(String searchTweet) {
			this.searchTweet = searchTweet;
		}

		public List getTweetList() {
			return tweetList;
		}

		public void setTweetList(List tweetList) {
			this.tweetList = tweetList;
		}

		private String friendsCount = null;
		
		
		public String getFriendsCount() {
			return friendsCount;
		}

		public void setFriendsCount(String friendsCount) {
			this.friendsCount = friendsCount;
		}

		public List getFriendsList() {
			return friendsList;
		}

		public void setFriendsList(List friendsList) {
			this.friendsList = friendsList;
		}

		
		
		public ProfileDTO getProfileDTO() {
			return profileDTO;
		}
		public void setProfileDTO(ProfileDTO profileDTO) {
			this.profileDTO = profileDTO;
		}
		public String getShareComment() {
			return shareComment;
		}
		public void setShareComment(String shareComment) {
			this.shareComment = shareComment;
		}
		public boolean isShareMsg() {
			return shareMsg;
		}
		public void setShareMsg(boolean shareMsg) {
			this.shareMsg = shareMsg;
		}
		public Object getAccessToken() {
			return accessToken;
		}
		public void setAccessToken(Object accessToken) {
			this.accessToken = accessToken;
		}
		public String getToken() {
			return token;
		}
		public void setToken(String token) {
			this.token = token;
		}
		public String getTokenSecret() {
			return tokenSecret;
		}
		public void setTokenSecret(String tokenSecret) {
			this.tokenSecret = tokenSecret;
		}
		public String getAuthUrl() {
			return authUrl;
		}
		public void setAuthUrl(String authUrl) {
			this.authUrl = authUrl;
		}
		public String getFollowersCount() {
			return followersCount;
		}
		public void setFollowersCount(String followersCount) {
			this.followersCount = followersCount;
		}
		public String getFollowingCount() {
			return followingCount;
		}
		public void setFollowingCount(String followingCount) {
			this.followingCount = followingCount;
		}
		public String getTweetId() {
			return tweetId;
		}
		public void setTweetId(String tweetId) {
			this.tweetId = tweetId;
		}
		public String getUserBgColor() {
			return userBgColor;
		}
		public void setUserBgColor(String userBgColor) {
			this.userBgColor = userBgColor;
		}
		public String getUserBgImgUrl() {
			return userBgImgUrl;
		}
		public void setUserBgImgUrl(String userBgImgUrl) {
			this.userBgImgUrl = userBgImgUrl;
		}
		public String getUserBio() {
			return userBio;
		}
		public void setUserBio(String userBio) {
			this.userBio = userBio;
		}
		public String getUserLocation() {
			return userLocation;
		}
		public void setUserLocation(String userLocation) {
			this.userLocation = userLocation;
		}
		public String getUserURL() {
			return userURL;
		}
		public void setUserURL(String userURL) {
			this.userURL = userURL;
		}
		public String getUserImg() {
			return userImg;
		}
		public void setUserImg(String userImg) {
			this.userImg = userImg;
		}
		
		public String getUserScreeName() {
			return userScreeName;
		}
		public void setUserScreeName(String userScreeName) {
			this.userScreeName = userScreeName;
		}
		public String getTweet() {
			return tweet;
		}
		public void setTweet(String tweet) {
			this.tweet = tweet;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getProfileId() {
			return profileId;
		}
		public void setProfileId(String profileId) {
			this.profileId = profileId;
		}
		public Object getAdminAccessToken() {
			return adminAccessToken;
		}
		public void setAdminAccessToken(Object adminAccessToken) {
			this.adminAccessToken = adminAccessToken;
		}
		public boolean isConnected() {
			return isConnected;
		}
		public void setConnected(boolean isConnected) {
			this.isConnected = isConnected;
		}
		public boolean isAddStatus() {
			return addStatus;
		}
		public void setAddStatus(boolean addStatus) {
			this.addStatus = addStatus;
		}
		public String getInviteMessage() {
			return inviteMessage;
		}
		public void setInviteMessage(String inviteMessage) {
			this.inviteMessage = inviteMessage;
		}

		public String getAdminProfileId() {
			return adminProfileId;
		}

		public void setAdminProfileId(String adminProfileId) {
			this.adminProfileId = adminProfileId;
		}

		public boolean isDeleteStatus() {
			return deleteStatus;
		}

		public void setDeleteStatus(boolean deleteStatus) {
			this.deleteStatus = deleteStatus;
		}

		public String getUserDesc() {
			return userDesc;
		}

		public void setUserDesc(String userDesc) {
			this.userDesc = userDesc;
		}

		public String getUserFavCount() {
			return userFavCount;
		}

		public void setUserFavCount(String userFavCount) {
			this.userFavCount = userFavCount;
		}

		public String getPersonalUrl() {
			return personalUrl;
		}

		public void setPersonalUrl(String personalUrl) {
			this.personalUrl = personalUrl;
		}

		public List getFollowersList() {
			return followersList;
		}

		public void setFollowersList(List followersList) {
			this.followersList = followersList;
		}

		public String getTweetCreatedAt() {
			return tweetCreatedAt;
		}

		public void setTweetCreatedAt(String tweetCreatedAt) {
			this.tweetCreatedAt = tweetCreatedAt;
		}

		public String getSessionTweetTag() {
			return sessionTweetTag;
		}

		public void setSessionTweetTag(String sessionTweetTag) {
			this.sessionTweetTag = sessionTweetTag;
		}

		public String getUserTimeZone() {
			return userTimeZone;
		}

		public void setUserTimeZone(String userTimeZone) {
			this.userTimeZone = userTimeZone;
		}

		public boolean isFriendInvited() {
			return friendInvited;
		}

		public void setFriendInvited(boolean friendInvited) {
			this.friendInvited = friendInvited;
		}

		public String getResultMessage() {
			return resultMessage;
		}

		public void setResultMessage(String resultMessage) {
			this.resultMessage = resultMessage;
		}

		public String[] getEventTags() {
			return eventTags;
		}

		public void setEventTags(String[] eventTags) {
			this.eventTags = eventTags;
		}

		public String getSessionEventTweetTag() {
			return sessionEventTweetTag;
		}

		public void setSessionEventTweetTag(String sessionEventTweetTag) {
			this.sessionEventTweetTag = sessionEventTweetTag;
		}

		public boolean isFriendIsFollowing() {
			return friendIsFollowing;
		}

		public void setFriendIsFollowing(boolean friendIsFollowing) {
			this.friendIsFollowing = friendIsFollowing;
		}

		public String getAlreadyFollowingInTwitterMsg() {
			return alreadyFollowingInTwitterMsg;
		}

		public void setAlreadyFollowingInTwitterMsg(String alreadyFollowingInTwitterMsg) {
			this.alreadyFollowingInTwitterMsg = alreadyFollowingInTwitterMsg;
		}
		

	}

