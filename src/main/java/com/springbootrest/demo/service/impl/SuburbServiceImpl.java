package com.springbootrest.demo.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springbootrest.demo.exception.NoDataFoundException;
import com.springbootrest.demo.exception.ResourceNotFoundException;
import com.springbootrest.demo.model.Suburb;
import com.springbootrest.demo.model.Suburbs;
import com.springbootrest.demo.repository.SuburbRepository;
import com.springbootrest.demo.service.SuburbService;

@Service
public class SuburbServiceImpl implements SuburbService{

	private SuburbRepository suburbRepository;
	
	public SuburbServiceImpl(SuburbRepository suburbRepository) {
		
		super();
		this.suburbRepository = suburbRepository;
		
	}

	@Override
	public List<Suburb> getAllSuburbs() {
		
		return suburbRepository.findAll();
		
	}

	@Override
	public Suburb getSuburbById(Long id) {		

		return suburbRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Suburb not found for id -> " + id));
		
	}

	@Override
	public Suburb saveSuburb(Suburb suburb) {
		
		return suburbRepository.save(suburb);
		
	}

	@Override
	public List<Suburb> saveAllSuburbs(Suburbs suburbs) {
		
		return suburbRepository.saveAll(suburbs.getSuburbs());
		
	}

	@Override
	public List<String> getSuburbNamesBySuburbPostcode(int suburbPostcode1, int suburbPostcode2) {
		
		List<String> suburbNamesList = new ArrayList<String>();
		suburbRepository.findBySuburbPostcodeBetween(suburbPostcode1, suburbPostcode2).forEach(sub -> {
			suburbNamesList.add(sub.getSuburbName());
		});
		if(suburbNamesList.isEmpty()) {
			throw new NoDataFoundException("No suburbs found for the given post code range");
		}
		return suburbNamesList.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
		
	}

	@Override
	public void deleteSuburb(long id) {

		suburbRepository.findById(id).orElseThrow(() -> new NoDataFoundException("No suburb found for id -> " + id));
		suburbRepository.deleteById(id);
		
	}

}
