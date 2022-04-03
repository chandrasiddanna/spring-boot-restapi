package com.springbootrest.demo.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.springbootrest.demo.model.Suburb;
import com.springbootrest.demo.model.Suburbs;

public interface SuburbService {
	
	Suburb saveSuburb(Suburb suburb);
	
	void deleteSuburb(long id);
	
	List<Suburb> getAllSuburbs();
	
	Suburb getSuburbById(Long id);
	
	List<Suburb> saveAllSuburbs(Suburbs suburbs);
	
	List<String> getSuburbNamesBySuburbPostcode(@RequestParam int suburbPostcode1, @RequestParam int suburbPostcode2);
	
}
