package com.sociorespo.web.actionform;

import org.apache.struts.action.ActionForm;

import com.sociorespo.dto.ProfileDTO;

public class ProfileActionForm extends ActionForm{
	
	
	private String userId=null;
	private String firstName=null;
	private String lastName=null;
	private String password=null;
	private String gender=null;
	private String phoneNum=null;
	private String mailId=null;
	private String dob=null;
	private String voterId = null;
	private String changePassword = null;
	
	private String update=null;
	
	private String linkedInAuthURL = null;
	
	private ProfileDTO profileDTO = null;
	
	private ProfileDTO faceBookProfileDTO = null;
	
	private ProfileDTO linkedInProfileDTO = null;
	
	
	public ProfileDTO getLinkedInProfileDTO() {
		return linkedInProfileDTO;
	}
	public void setLinkedInProfileDTO(ProfileDTO linkedInProfileDTO) {
		this.linkedInProfileDTO = linkedInProfileDTO;
	}
	public String getLinkedInAuthURL() {
		return linkedInAuthURL;
	}
	public void setLinkedInAuthURL(String linkedInAuthURL) {
		this.linkedInAuthURL = linkedInAuthURL;
	}
	public ProfileDTO getFaceBookProfileDTO() {
		return faceBookProfileDTO;
	}
	public void setFaceBookProfileDTO(ProfileDTO faceBookProfileDTO) {
		this.faceBookProfileDTO = faceBookProfileDTO;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public ProfileDTO getProfileDTO() {
		return profileDTO;
	}
	public void setProfileDTO(ProfileDTO profileDTO) {
		this.profileDTO = profileDTO;
	}
	public String getChangePassword() {
		return changePassword;
	}
	public void setChangePassword(String changePassword) {
		this.changePassword = changePassword;
	}
	public String getUpdate() {
		return update;
	}
	public void setUpdate(String update) {
		this.update = update;
	}
	
	
	

}
