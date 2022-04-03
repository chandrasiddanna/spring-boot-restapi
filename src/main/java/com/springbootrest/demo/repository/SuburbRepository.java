package com.springbootrest.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootrest.demo.model.Suburb;

public interface SuburbRepository extends JpaRepository<Suburb, Long> {
	
	/**
	 * Returns suburb names between post code range
	 * @param suburbPostcode1
	 * @param suburbPostcode2
	 * @return List<Suburb>
	 */
	List<Suburb> findBySuburbPostcodeBetween(int suburbPostcode1, int suburbPostcode2);
	
}
