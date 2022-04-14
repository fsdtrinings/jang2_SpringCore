package com.mkj.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mkj.myapp.db.CityDatabase;

@RestController
public class CityRestController {

	@Autowired
	private CityDatabase dbObj;

	public CityRestController() {
		System.out.println("--------->> inside city Rest controller");
	}

	@GetMapping("/home")
	public String getHomePage() {
		return "Welcome to City Service Application , <HomePage of the application>"; // web address
	}

	@GetMapping("/city/{pincode}")
	public String getCityNameBasedonPincode(@PathVariable int pincode) {
		// check the pincode in the database
		String result = dbObj.getCityName(pincode);
		// response back to the user
		if (result == null)
			return " Pincode not in the list";
		else
			return result;
	}

	// localhost:8080/citypoint?city=banglore
	
	@GetMapping("/citypoint")
	public String getCityPoints(@RequestParam String city) 
	{
		// check the pincode in the database
		String result = dbObj.getCityPoint(city);
		// response back to the user
		if (result == null)
			return " City not in the list";
		else
			return result;
	}
	
	// localhost:8080/cityinfo/{country}?city=cityName&whether=night&cabapp=Uber

	
	//-------------------------------  save record ------------------------------
	
	// localhost:8080/city?city=pune&pincode=411
	@PostMapping("/city")
	public String saveCityPincode(@RequestParam String city,@RequestParam int pincode)
	{
		String msg = "City pincode saved";
		boolean result = dbObj.saveCityPincode(city, pincode);
		
		return msg;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//end class














