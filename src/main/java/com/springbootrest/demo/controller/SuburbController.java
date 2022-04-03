package com.springbootrest.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrest.demo.model.Suburb;
import com.springbootrest.demo.model.Suburbs;
import com.springbootrest.demo.service.SuburbService;

@RestController
@RequestMapping("/api/suburbs")
public class SuburbController {
	
	private SuburbService suburbService;

	public SuburbController(SuburbService suburbService) {
		
		super();
		this.suburbService = suburbService;
		
	}
	
	/**
	 * Save single suburb entry
	 * @param suburb
	 * @return ResponseEntity<Suburb>
	 */
	@PostMapping
	public ResponseEntity<Suburb> saveSuburb(@RequestBody Suburb suburb) {
		
		return  new ResponseEntity<Suburb>(suburbService.saveSuburb(suburb), HttpStatus.CREATED);
		
	}
	
	/**
	 * Gets all suburb list
	 * @return List<Suburb>
	 */
	@GetMapping
	public List<Suburb> getAllSuburbs() {
		
		return suburbService.getAllSuburbs();
		
	}
	
	/**
	 * Get suburb by id - ex - http://localhost:8080/api/suburbs/1
	 * @param suburbId
	 * @return ResponseEntity<Suburb>
	 */
	@GetMapping("{id}")
	public Suburb getSuburbById(@PathVariable("id") long suburbId) {
		
		return suburbService.getSuburbById(suburbId);
		
	}
	
	/**
	 * Saves a list of suburb names and postcode from HTTP request body
	 * @param suburbs
	 * @return List<Suburb>
	 */
	@PostMapping("/all")
	public List<Suburb> saveAllSuburbs(@RequestBody Suburbs suburbs) {
		
		return suburbService.saveAllSuburbs(suburbs);
		
	}	
	
	/**
	 * Returns suburb names between post code range sorted alphabetically as well as total number of characters
	 * @param suburbPostcode1
	 * @param suburbPostcode2
	 * @return List<Suburb>
	 */
	@GetMapping("/postcode")
	public List<String> getSuburbNamesBySuburbPostcode(@RequestParam int suburbPostcode1, @RequestParam int suburbPostcode2) {
		
		return suburbService.getSuburbNamesBySuburbPostcode(suburbPostcode1, suburbPostcode2);
		
	}
	
	/**
	 * delete Suburb REST API ex - http://localhost:8080/api/suburbs/1 
	 * @return
	 */
	@DeleteMapping
	public ResponseEntity<String> deleteSuburb(@PathVariable("id") long id) {
	
		suburbService.deleteSuburb(id);
		return new ResponseEntity<String>("Suburb deleted successfully", HttpStatus.OK);
		
	}
}
