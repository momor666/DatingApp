/**
 * 
 */
package com.digitalforce.datingapp.parser;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.digitalforce.datingapp.model.NearBy;
import com.digitalforce.datingapp.model.UserInfo;

/**
 * @author FARHAN
 *
 */
public class JsonParser {

	/*
	 * Parse Login response
	 */
	public static UserInfo parseLoginJson(JSONObject jsonObject){
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(jsonObject.optString("userid"));
		return userInfo;
	}

    /*
     *  Parse Sign up data
     */
	public static UserInfo parseSignUpJson(JSONObject jsonObject){
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(jsonObject.optString("userid"));
		return userInfo;
	}
	
	/*
	 * Parse Forgot password response
	 */
	public static String parseForgotPasswordJson(JSONObject jsonObject){

		return jsonObject.optString("success");

	}

	/*
	 *  Parse Near By user data
	 */
	public static ArrayList<NearBy> parseNearByUserJson(JSONObject jsonObject){
		ArrayList<NearBy> nearByUserList = new ArrayList<NearBy>();
		
		JSONArray jsonArray = jsonObject.optJSONArray("Data");
		if(jsonArray!=null){
			for(int i=0; i<jsonArray.length(); i++){
				JSONObject nearJObj = jsonArray.optJSONObject(i);
				
				NearBy nearBy = new NearBy();
				nearBy.setUserId(nearJObj.optString("userId"));
				nearBy.setFirstName(nearJObj.optString("firstName"));
				nearBy.setDistance(nearJObj.optString("distance"));
				nearBy.setLastName(nearJObj.optString("lastname"));
				nearBy.setEmail(nearJObj.optString("email"));
				nearBy.setDob(nearJObj.optString("dob"));
				nearBy.setGender(nearJObj.optString("gender"));
				nearBy.setMobile(nearJObj.optString("mobile"));
				nearBy.setCountry(nearJObj.optString("country"));
				nearBy.setLatitude(nearJObj.optString("lat"));
				nearBy.setLongitude(nearJObj.optString("long"));
				nearBy.setStatus(nearJObj.optString("status"));
				nearBy.setDistance(nearJObj.optString("distance"));
				
				nearByUserList.add(nearBy);
			}
		}

		return nearByUserList;

	}

}
