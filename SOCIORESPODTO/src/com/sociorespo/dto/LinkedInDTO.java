package com.sociorespo.dto;

import java.util.List;

public class LinkedInDTO {

	
	private int userId=0;
	private String profileId = null;
	private String adminProfileId = null;
	private String token = null;
	private String tokenSecret = null;
	private String authUrl = null;
	private String oauthVerifier = null;
	
	private String inviteMessage = null;
	
	private Object requestToken = null;
	private Object accessToken = null;
	private Object adminAccessToken = null;
	
	private boolean addStatus = false;
	private boolean deleteStatus = false;
	
	private boolean ShareMsg = false;	
	
	private boolean inviteFriend = false;

	private ProfileDTO profileDTO = null;
	private String baseURL = null;
	
	private List friendsList = null;
	
	private String friendsCount = null;
	private String shareComment = null;
	boolean alreadyFriends = false;
	boolean alreadyInvited = false;
	boolean requestPending = false;
	
	String resultMessage = null;
	
	 String name = null;
	 String headLine = null;
	 String industry = null;
	 String profileImg = null;
	 String pubProfielUrl = null;	
	 String specialities = null;
	 String summary = null;
	 String country = null;
	 String locationName=null;
	 String connectionTotal=null;
	String inviteSubject = null;
	 
	 
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isAlreadyFriends() {
		return alreadyFriends;
	}

	public void setAlreadyFriends(boolean alreadyFriends) {
		this.alreadyFriends = alreadyFriends;
	}

	public String getAdminProfileId() {
		return adminProfileId;
	}

	public void setAdminProfileId(String adminProfileId) {
		this.adminProfileId = adminProfileId;
	}

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
	
	public String getBaseURL() {
		return baseURL;
	}
	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}
	public String getInviteMessage() {
		return inviteMessage;
	}
	public void setInviteMessage(String inviteMessage) {
		this.inviteMessage = inviteMessage;
	}
	public boolean isInviteFriend() {
		return inviteFriend;
	}
	public void setInviteFriend(boolean inviteFriend) {
		this.inviteFriend = inviteFriend;
	}
	public ProfileDTO getProfileDTO() {
		return profileDTO;
	}
	public void setProfileDTO(ProfileDTO profileDTO) {
		this.profileDTO = profileDTO;
	}
	public Object getRequestToken() {
		return requestToken;
	}
	public void setRequestToken(Object requestToken) {
		this.requestToken = requestToken;
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
	public String getOauthVerifier() {
		return oauthVerifier;
	}
	public void setOauthVerifier(String oauthVerifier) {
		this.oauthVerifier = oauthVerifier;
	}
	public String getProfileId() {
		return profileId;
	}
	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}
	public Object getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(Object accessToken) {
		this.accessToken = accessToken;
	}
	public boolean isAddStatus() {
		return addStatus;
	}
	public void setAddStatus(boolean addStatus) {
		this.addStatus = addStatus;
	}

	public boolean isDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHeadLine() {
		return headLine;
	}

	public void setHeadLine(String headLine) {
		this.headLine = headLine;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public String getPubProfielUrl() {
		return pubProfielUrl;
	}

	public void setPubProfielUrl(String pubProfielUrl) {
		this.pubProfielUrl = pubProfielUrl;
	}

	public String getSpecialities() {
		return specialities;
	}

	public void setSpecialities(String specialities) {
		this.specialities = specialities;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getConnectionTotal() {
		return connectionTotal;
	}

	public void setConnectionTotal(String connectionTotal) {
		this.connectionTotal = connectionTotal;
	}

	public boolean getShareMsg() {
		return ShareMsg;
	}

	public void setShareMsg(boolean shareMsg) {
		ShareMsg = shareMsg;
	}

	public String getShareComment() {
		return shareComment;
	}

	public void setShareComment(String shareComment) {
		this.shareComment = shareComment;
	}

	public Object getAdminAccessToken() {
		return adminAccessToken;
	}

	public void setAdminAccessToken(Object adminAccessToken) {
		this.adminAccessToken = adminAccessToken;
	}

	public String getInviteSubject() {
		return inviteSubject;
	}

	public void setInviteSubject(String inviteSubject) {
		this.inviteSubject = inviteSubject;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public boolean isAlreadyInvited() {
		return alreadyInvited;
	}

	public void setAlreadyInvited(boolean alreadyInvited) {
		this.alreadyInvited = alreadyInvited;
	}

	public boolean isRequestPending() {
		return requestPending;
	}

	public void setRequestPending(boolean requestPending) {
		this.requestPending = requestPending;
	}


}
