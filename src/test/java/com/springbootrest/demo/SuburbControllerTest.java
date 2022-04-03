package com.springbootrest.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.springbootrest.demo.controller.SuburbController;
import com.springbootrest.demo.model.Suburb;
import com.springbootrest.demo.model.Suburbs;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
public class SuburbControllerTest {

	@Autowired
	private SuburbController controller;
	
	private Suburb suburb1;
	private Suburb suburb2;
	private Suburb suburb3;
	private Suburb suburb4;
	
	@Test
	public void contextLoads() throws Exception {
		Assertions.assertThat(controller).isNotNull();
	}
	
	@Test
	@Disabled
	public void saveSuburbTest() {

		controller.saveSuburb(suburb1);
		
		Assertions.assertThat(suburb1.getId()).isGreaterThan(0);
		
	}
	
	@BeforeAll
	public void setup() {
		suburb1 = Suburb.builder()
				.suburbName("Darlington")
				.suburbPostcode(6008)
				.build();
		
		suburb2 = Suburb.builder()
				.suburbName("Test2")
				.suburbPostcode(6014)
				.build();	
		
		suburb3 = Suburb.builder()
				.suburbName("Test3")
				.suburbPostcode(6016)
				.build();
		
		suburb4 = Suburb.builder()
				.suburbName("Aveley")
				.suburbPostcode(6018)
				.build();
	}
	
	@Test
	@Order(1)
	@Rollback(value = false)
	public void saveAllSuburbsTest() {
		
		Suburbs suburbs = new Suburbs();
		List<Suburb> suburbList = new ArrayList<Suburb>();
		suburbList.add(suburb1);
		suburbList.add(suburb2);
		suburbList.add(suburb3);
		suburbList.add(suburb4);
		suburbs.setSuburbs(suburbList);
		controller.saveAllSuburbs(suburbs);
		Assertions.assertThat((controller.getAllSuburbs()).size()).isGreaterThanOrEqualTo(4);
		
	}
	
	@Test
	@Order(2)
	@Rollback(value = false)
	public void getSuburbNamesBySuburbPostcodeTest() {
		
		List<String> suburbByPostcode = controller.getSuburbNamesBySuburbPostcode(6008, 6018);
		Collections.sort(suburbByPostcode);
		System.out.println(suburbByPostcode);
		Assertions.assertThat(controller.getSuburbNamesBySuburbPostcode(6008, 6018)).isEqualTo(suburbByPostcode);
		
	}
	
}
