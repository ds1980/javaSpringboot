package com.in.cafe.utils;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.crypto.Data;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.google.common.base.Strings;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.in.cafe.serviceImpl.BillServiceImpl;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class CafeUtils {
	
	private CafeUtils() {
		
	}
	public static ResponseEntity<String> getresponseEntity(String responseMessage, HttpStatus httpStatus){
		return new ResponseEntity<String>("{\"message\":\""+responseMessage+"\"}", httpStatus);
	}
	
	public static String getUUID() {
		Date date = new Date();
		long time = date.getTime();
		return "BILL-"+ time;
	}
	
	public static JSONArray convertJsonArrayFromString(String data) throws JSONException {
		JSONArray jsonArray = new JSONArray(data);
		return jsonArray;
	}
	
	public static Map<String, Object> getMapfromJson(String data) {
		if(!Strings.isNullOrEmpty(data)) {
			return new Gson().fromJson(data, new TypeToken<Map<String, Object>>(){
				
			}.getType());
		}
		return new HashMap<String, Object>();
	}
	
	// check file is exist or not
	
	public static Boolean isFileExist(String path) {
		log.info("Inside file is exist");
		try {
			File file = new File(path);
			return (file != null && file.exists()) ? Boolean.TRUE : Boolean.FALSE;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
