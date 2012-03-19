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
 * Oct 21, 2010 - mmanimaran created the file.
 * 
 */
package com.sociorespo.dto;

import java.util.List;

/**
 * Class Description
 *    
 * @version 1.0
 * @author mmanimaran
 * @Date Oct 21, 2010
 * 
 * Copyright 2010-2011 Kyyba Ventures,Inc. All Rights Reserved.
 * This software is the proprietary information of Kyyba Ventures Inc.
 * Use is subject to license terms.
 */
public class FaceBookDTO  {

	private int userId = 0; 
	private String profileId = null;
	private String adminProfileId = null;
	
	private String authUrl = null;
	
	private Object accessToken = null;
	private Object adminAccessToken = null;
	
	private boolean addStatus = false;
	private boolean deleteStatus = false;
	
	
	
	private Object authToken = null;
	
	boolean alreadyFriends = false;
	
	boolean shareMsg = false;
	private String shareComment = null;
	
	private List friendsList = null;
	
	private String friendsCount = null;
	
	private String profileUrl =null;

	private String name = null; 

	private String profileImg = null;

	private String profileBigImg = null;
	
	private boolean inviteFriend = false;
	
	private boolean friendAlreadyReqYou = false;
	String resultMessage = null;
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

	public boolean isShareMsg() {
		return shareMsg;
	}

	public void setShareMsg(boolean shareMsg) {
		this.shareMsg = shareMsg;
	}

	public String getShareComment() {
		return shareComment;
	}

	public void setShareComment(String shareComment) {
		this.shareComment = shareComment;
	}

	public Object getAuthToken() {
		return authToken;
	}

	public void setAuthToken(Object authToken) {
		this.authToken = authToken;
	}

	public String getAuthUrl() {
		return authUrl;
	}

	public void setAuthUrl(String authUrl) {
		this.authUrl = authUrl;
	}

	public Object getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(Object accessToken) {
		this.accessToken = accessToken;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
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

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public String getProfileBigImg() {
		return profileBigImg;
	}

	public void setProfileBigImg(String profileBigImg) {
		this.profileBigImg = profileBigImg;
	}

	public Object getAdminAccessToken() {
		return adminAccessToken;
	}

	public void setAdminAccessToken(Object adminAccessToken) {
		this.adminAccessToken = adminAccessToken;
	}

	public boolean isInviteFriend() {
		return inviteFriend;
	}

	public void setInviteFriend(boolean inviteFriend) {
		this.inviteFriend = inviteFriend;
	}

	public boolean isFriendAlreadyReqYou() {
		return friendAlreadyReqYou;
	}

	public void setFriendAlreadyReqYou(boolean friendAlreadyReqYou) {
		this.friendAlreadyReqYou = friendAlreadyReqYou;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
}
