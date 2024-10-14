package tw.com.eeit.JapanAttraction.model.bean;

import java.util.Arrays;
import java.util.Base64;

public class Users {
	private int userID;
	private String userEmail;
	private String userName;
	private String password;
	private byte[] userPhoto;
//	private String attractionPhotoBase64;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public byte[] getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(byte[] userPhoto) {
		this.userPhoto = userPhoto;
//		String base64String = Base64.getEncoder().encodeToString(userPhoto);
//		this.attractionPhotoBase64 = "data:image/png;base64,"+base64String;
	}
//	public String getAttractionPhotoBase64() {
//		return attractionPhotoBase64;
//	}
	@Override
	public String toString() {
		return "Users [userID=" + userID + ", userEmail=" + userEmail + ", userName=" + userName + ", password="
				+ password + ", userPhoto=" + Arrays.toString(userPhoto) + "]";
	}
	
	



	
	
}
