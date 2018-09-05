package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.City;
import com.example.demo.service.CityService;

@RestController
public class CityRestController {
	@Autowired
	private CityService cityService;
	
	@RequestMapping(value = "/api" , method = RequestMethod.GET)
	public City findCity(@RequestParam(value = "cityName" ,required = true)String cityName) {
		return cityService.findCity(cityName);
	}
}
