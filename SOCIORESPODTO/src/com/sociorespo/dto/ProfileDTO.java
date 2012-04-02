/*
 * Copyright 2010-2011 Kyyba Ventures,Inc. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Kyyba ventures("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into 
 * with Kyyba Ventures.
 * 
 * CHANGE HISTORY
 * ==================================================================================
 * March 1, 2011 veeresh created the file.
 * 
 */
package com.sociorespo.dto;

import java.util.List;


/**
 * Class Description
 * 
 * @version beta
 * @author Veeresh
 * @Date March 1, 2011
 * 
 *       Copyright 2009-2010 Kyyba Ventures,Inc. All Rights Reserved. This
 *       software is the proprietary information of Kyyba Ventures Inc. Use is
 *       subject to license terms.
 */

public class ProfileDTO {
	
	private int userId;
	/*Property to store the First name */
	private String firstName;
	/*Property to store the Last name */
	private String lastName;
	/*Property to store the Password */
	private String password;
	/*Property to store the gender */
	private String gender;
	private String phoneNum;
	private String mailId;
	private String dob;
	private String voterId;
	
	/*Property to store the Email */
	private String eMail;
	/*Property to store the Email */
	private String alternativeEmail;	
	/*Property to store the Mobile */
	private String mobile;
	/*Property to store the LandHome number */
	private String landHome;
	/*Property to store the LandOffice number */
	private String landOffice;
	/*Property to store the Address */
	private String address;
	/*Property to store the City */
	private String city;
	/*Property to store the Zip code */
	private String zip;
	/*Property to store the State */
	private String state;
	/*Property to store the Country */
	private String country;
	/*Property to store the Education */
	private String education;
	/*Property to store the Occupation */
	private String occupation;
	/*Property to store the Web site */
	private String website;
		
	/*Property to store the profile Picture */
	private String profilePicture;
	/*Property to store the Profile Id */
	private String profileId;
	/*Property to store the new Password */
	private String newPassword;
	/*Property to store the result Message */
	private String resultMessage;	
	/*Property List to set Account Settings*/	
	private List accountSettingsList = null;
	/*Property List to set Profile Picture*/	
	private List profilePic = null;
	/*Property List to set Contact Information*/	
	private List contactInfoList = null;
	private String speakerFor = null;
	private String profileEmail = null;
	private String profImgFileName = null;
	private String extProfileImgLocation = null;
	
	
	
	private boolean speakerCheck = false;

	
	private String twitterId = null;
	private String faceBookId = null;
	private String linkedInId = null;
	private String twitterFollow = null;
	private String faceBookFriendsConnect = null;
	private String linkedInFriendsConnect = null;
	private String twitterProfileUrl = null;
	private String faceBookProfileUrl = null;
	private String linkedInProfileUrl = null;
	private String twitterImgUrl = null;
	private String faceBookImgUrl = null;
	private String linkedInImgUrl = null;
	
	private String profileMailFromId = null;
	private String profileMailToId = null;
	private String profileMailContent = null;
	private String profileToolTip = null;
	private int profileMailCount = 0;

	private boolean chkImageFromLocal = false;
	
	private String timeZone = null;
	private String toProfileId = null;
	
	private boolean speakerCheckBox = false;
	private String eventOption = null;
	private String sessionOption = null;
	private String speakerKeyNotes = null;
	private boolean currentUser = false;
	
	private String twitterCheck = null;
	private String facebookCheck = null;
	private String linkedinCheck = null;
	private boolean currentSessionSpeaker = false;
	
	
	private String twtShowTweets = null;
	private String twtAllowFriends = null;
	private String fbAllowFriendsToPost = null;
	private String fbAllowFriendsToConnect = null;
	private String liAllowFriendsToFollow = null;
	private String liAllowFriendsToPost = null;
	
	private String joinedEventsName = null;
	private String attendedSessionsName = null;
	
	private String authKey=null;
	private String content=null;
	private String userClientDetails = null;
	
	
		
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getVoterId() {
		return voterId;
	}
	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}
	public String getAttendedSessionsName() {
		return attendedSessionsName;
	}
	public void setAttendedSessionsName(String attendedSessionsName) {
		this.attendedSessionsName = attendedSessionsName;
	}
	
	public String getProfileEmail() {
		return profileEmail;
	}
	public void setProfileEmail(String profileEmail) {
		this.profileEmail = profileEmail;
	}
		public String getTwitterImgUrl() {
		return twitterImgUrl;
	}
	public void setTwitterImgUrl(String twitterImgUrl) {
		this.twitterImgUrl = twitterImgUrl;
	}
	public String getFaceBookImgUrl() {
		return faceBookImgUrl;
	}
	public void setFaceBookImgUrl(String faceBookImgUrl) {
		this.faceBookImgUrl = faceBookImgUrl;
	}
	public String getLinkedInImgUrl() {
		return linkedInImgUrl;
	}
	public void setLinkedInImgUrl(String linkedInImgUrl) {
		this.linkedInImgUrl = linkedInImgUrl;
	}
	public String getTwitterId() {
		return twitterId;
	}
	public void setTwitterId(String twitterId) {
		this.twitterId = twitterId;
	}
	public String getFaceBookId() {
		return faceBookId;
	}
	public void setFaceBookId(String faceBookId) {
		this.faceBookId = faceBookId;
	}
	public String getLinkedInId() {
		return linkedInId;
	}
	public void setLinkedInId(String linkedInId) {
		this.linkedInId = linkedInId;
	}
	public String getTwitterProfileUrl() {
		return twitterProfileUrl;
	}
	public void setTwitterProfileUrl(String twitterProfileUrl) {
		this.twitterProfileUrl = twitterProfileUrl;
	}
	public String getFaceBookProfileUrl() {
		return faceBookProfileUrl;
	}
	public void setFaceBookProfileUrl(String faceBookProfileUrl) {
		this.faceBookProfileUrl = faceBookProfileUrl;
	}
	public String getLinkedInProfileUrl() {
		return linkedInProfileUrl;
	}
	public void setLinkedInProfileUrl(String linkedInProfileUrl) {
		this.linkedInProfileUrl = linkedInProfileUrl;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public boolean isSpeakerCheck() {
		return speakerCheck;
	}
	public void setSpeakerCheck(boolean speakerCheck) {
		this.speakerCheck = speakerCheck;
	}
	public String profileDTO() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getLandHome() {
		return landHome;
	}
	public void setLandHome(String landHome) {
		this.landHome = landHome;
	}
	public String getLandOffice() {
		return landOffice;
	}
	public void setLandOffice(String landOffice) {
		this.landOffice = landOffice;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	public List getAccountSettingsList() {
		return accountSettingsList;
	}
	public void setAccountSettingsList(List accountSettingsList) {
		this.accountSettingsList = accountSettingsList;
	}
	public List getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(List profilePic) {
		this.profilePic = profilePic;
	}
	public List getContactInfoList() {
		return contactInfoList;
	}
	public void setContactInfoList(List contactInfoList) {
		this.contactInfoList = contactInfoList;
	}
	public String getAlternativeEmail() {
		return alternativeEmail;
	}
	public void setAlternativeEmail(String alternativeEmail) {
		this.alternativeEmail = alternativeEmail;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	public String getProfileId() {
		return profileId;
	}
	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getProfImgFileName() {
		return profImgFileName;
	}
	public void setProfImgFileName(String profImgFileName) {
		this.profImgFileName = profImgFileName;
	}
	public String getExtProfileImgLocation() {
		return extProfileImgLocation;
	}
	public void setExtProfileImgLocation(String extProfileImgLocation) {
		this.extProfileImgLocation = extProfileImgLocation;
	}
	
//	public SocialMediaDTO getSocialMediaDTO() {
//		return socialMediaDTO;
//	}
//	
//	public void setSocialMediaDTO(SocialMediaDTO socialMediaDTO) {
//		this.socialMediaDTO = socialMediaDTO;
//	}
	
	public String getProfileMailFromId() {
		return profileMailFromId;
	}
	
	public void setProfileMailFromId(String profileMailFromId) {
		this.profileMailFromId = profileMailFromId;
	}
	
	public String getProfileMailToId() {
		return profileMailToId;
	}
	
	public void setProfileMailToId(String profileMailToId) {
		this.profileMailToId = profileMailToId;
	}
	
	public String getProfileMailContent() {
		return profileMailContent;
	}
	
	public void setProfileMailContent(String profileMailContent) {
		this.profileMailContent = profileMailContent;
	}
	
	public boolean getChkImageFromLocal() {
		return chkImageFromLocal;
	}
	
	public void setChkImageFromLocal(boolean chkImageFromLocal) {
		this.chkImageFromLocal = chkImageFromLocal;
	}
	public int getProfileMailCount() {
		return profileMailCount;
	}
	public void setProfileMailCount(int profileMailCount) {
		this.profileMailCount = profileMailCount;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	
	public String getToProfileId() {
		return toProfileId;
	}
	public void setToProfileId(String toProfileId) {
		this.toProfileId = toProfileId;
	}	
	public boolean getSpeakerCheckBox() {
		return speakerCheckBox;
	}
	public void setSpeakerCheckBox(boolean speakerCheckBox) {
		this.speakerCheckBox = speakerCheckBox;
	}
	public String getEventOption() {
		return eventOption;
	}
	public void setEventOption(String eventOption) {
		this.eventOption = eventOption;
	}
	public String getSessionOption() {
		return sessionOption;
	}
	public void setSessionOption(String sessionOption) {
		this.sessionOption = sessionOption;
	}
	public String getTwitterFollow() {
		return twitterFollow;
	}
	public void setTwitterFollow(String twitterFollow) {
		this.twitterFollow = twitterFollow;
	}
	public String getFaceBookFriendsConnect() {
		return faceBookFriendsConnect;
	}
	public void setFaceBookFriendsConnect(String faceBookFriendsConnect) {
		this.faceBookFriendsConnect = faceBookFriendsConnect;
	}
	public String getLinkedInFriendsConnect() {
		return linkedInFriendsConnect;
	}
	public void setLinkedInFriendsConnect(String linkedInFriendsConnect) {
		this.linkedInFriendsConnect = linkedInFriendsConnect;
	}
	public String getSpeakerKeyNotes() {
		return speakerKeyNotes;
	}
	public void setSpeakerKeyNotes(String speakerKeyNotes) {
		this.speakerKeyNotes = speakerKeyNotes;
	}
	public boolean isCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(boolean currentUser) {
		this.currentUser = currentUser;
	}
	public String getTwitterCheck() {
		return twitterCheck;
	}
	public void setTwitterCheck(String twitterCheck) {
		this.twitterCheck = twitterCheck;
	}
	public String getFacebookCheck() {
		return facebookCheck;
	}
	public void setFacebookCheck(String facebookCheck) {
		this.facebookCheck = facebookCheck;
	}
	public String getLinkedinCheck() {
		return linkedinCheck;
	}
	public void setLinkedinCheck(String linkedinCheck) {
		this.linkedinCheck = linkedinCheck;
	}
	public String getSpeakerFor() {
		return speakerFor;
	}
	public void setSpeakerFor(String speakerFor) {
		this.speakerFor = speakerFor;
	}
	public boolean isCurrentSessionSpeaker() {
		return currentSessionSpeaker;
	}
	public void setCurrentSessionSpeaker(boolean currentSessionSpeaker) {
		this.currentSessionSpeaker = currentSessionSpeaker;
	}
	public String getProfileToolTip() {
		return profileToolTip;
	}
	public void setProfileToolTip(String profileToolTip) {
		this.profileToolTip = profileToolTip;
	}
	public String getTwtShowTweets() {
		return twtShowTweets;
	}
	public void setTwtShowTweets(String twtShowTweets) {
		this.twtShowTweets = twtShowTweets;
	}
	public String getTwtAllowFriends() {
		return twtAllowFriends;
	}
	public void setTwtAllowFriends(String twtAllowFriends) {
		this.twtAllowFriends = twtAllowFriends;
	}
	public String getFbAllowFriendsToPost() {
		return fbAllowFriendsToPost;
	}
	public void setFbAllowFriendsToPost(String fbAllowFriendsToPost) {
		this.fbAllowFriendsToPost = fbAllowFriendsToPost;
	}
	public String getFbAllowFriendsToConnect() {
		return fbAllowFriendsToConnect;
	}
	public void setFbAllowFriendsToConnect(String fbAllowFriendsToConnect) {
		this.fbAllowFriendsToConnect = fbAllowFriendsToConnect;
	}
	public String getLiAllowFriendsToFollow() {
		return liAllowFriendsToFollow;
	}
	public void setLiAllowFriendsToFollow(String liAllowFriendsToFollow) {
		this.liAllowFriendsToFollow = liAllowFriendsToFollow;
	}
	public String getLiAllowFriendsToPost() {
		return liAllowFriendsToPost;
	}
	public void setLiAllowFriendsToPost(String liAllowFriendsToPost) {
		this.liAllowFriendsToPost = liAllowFriendsToPost;
	}
	
	public String getJoinedEventsName() {
		return joinedEventsName;
	}
	public void setJoinedEventsName(String joinedEventsName) {
		this.joinedEventsName = joinedEventsName;
	}
	public String getAuthKey() {
		return authKey;
	}
	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserClientDetails() {
		return userClientDetails;
	}
	public void setUserClientDetails(String userClientDetails) {
		this.userClientDetails = userClientDetails;
	}

	
	
	
	
}
