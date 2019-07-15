package com.interview.example.junitmavenexample.model.factory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;


public class EnterpriseNodeLoader {

	public  <T> T loadFromJSON(String strJson,  Class<T> generic){
		Gson g = new Gson();
		return  g.fromJson(strJson, generic);
	}

	public    <T> T[] loadFromJSONArray(String strJson, Class<T[]> generic){
		Gson g = new Gson();
		return g.fromJson(strJson, generic);
	}

	public  <T> T[] loadFromJSONFile(String strFile, Class<T[]> generic) throws IOException{
		String strJson = new String(Files.readAllBytes(Paths.get(strFile))); 
		return loadFromJSONArray(strJson, generic);
	}

}
