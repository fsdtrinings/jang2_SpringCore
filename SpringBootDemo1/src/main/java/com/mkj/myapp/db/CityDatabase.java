package com.mkj.myapp.db;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

// act like as ORM layer / Hibernate
@Component
public class CityDatabase {
	
	Map<Integer, String> cityDB = new HashMap<>();
	Map<String, String> cityPoints = new HashMap<>();
	
	CityDatabase()
	{
		cityDB.put(110, "New Delhi");
		cityDB.put(220, "Mumbai");
		cityDB.put(330, "Chennai");
		cityDB.put(440, "Kolkatta");
		cityDB.put(560, "Banglore");
		cityDB.put(500, "Hydrabad");
		
		cityPoints.put("New Delhi", "India Gate");
		cityPoints.put("Mumbai", "Marin Drive");
		cityPoints.put("Chennai", "Sea Beach");
		cityPoints.put("Banglore", "Nandihills");
		cityPoints.put("Hydrabad", "Char Minar");
		
		
	
	}
	
	public boolean saveCityPincode(String cityname,int code)
	{
		cityDB.put(code, cityname);
		return true;
	}
	
	public String getCityPoint(String cityName)
	{
		return cityPoints.get(cityName);
	}
	
	
	public String getCityName(int pincode)
	{
		return cityDB.get(pincode);
	}
	

}
