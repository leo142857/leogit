package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CityDao;
import com.example.demo.domain.City;
import com.example.demo.service.CityService;

@Service
public class CityServiceImpl implements CityService{
	
	@Autowired
	private CityDao cityDao;
	@Override
	public City findCity(String cityName) {
		// TODO Auto-generated method stub
		return cityDao.findByName(cityName);
	}

}
