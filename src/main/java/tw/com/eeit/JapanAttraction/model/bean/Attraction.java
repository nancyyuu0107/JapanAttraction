package tw.com.eeit.JapanAttraction.model.bean;

import java.util.Arrays;
import java.util.Base64;

public class Attraction {
	private int attractionID;
	private String attractionName;
	private String location;
	private byte[] attractionPhoto;
	private String discribe;
	private String attractionPhotoBase64;


	public String getAttractionPhotoBase64() {
		return attractionPhotoBase64;
	}

	public Attraction() {
	}
	
	public int getAttractionID() {
		return attractionID;
	}
	public void setAttractionID(int attractionID) {
		this.attractionID = attractionID;
	}
	public String getAttractionName() {
		return attractionName;
	}
	public void setAttractionName(String attractionName) {
		this.attractionName = attractionName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public byte[]  getAttractionPhoto() {
		return attractionPhoto;
	}
	public void setAttractionPhoto(byte[]  attractionPhoto) {
		this.attractionPhoto = attractionPhoto;
		
		String base64String = Base64.getEncoder().encodeToString(attractionPhoto);
		this.attractionPhotoBase64 = "data:image/png;base64,"+base64String;
	}
	public String getDiscribe() {
		return discribe;
	}
	public void setDiscribe(String discribe) {
		this.discribe = discribe;
	}

	@Override
	public String toString() {
		return "Attraction [attractionID=" + attractionID + ", attractionName=" + attractionName + ", location="
				+ location + ", attractionPhoto=" + Arrays.toString(attractionPhoto) + ", discribe=" + discribe + "]";
	}

	
	
	
}
