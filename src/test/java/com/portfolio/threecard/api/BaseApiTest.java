package com.portfolio.threecard.api;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class BaseApiTest {

	@BeforeClass
	public void testSetup() {
		RestAssured.requestSpecification = ApiConfig.requestSpec;
	}
	
	@AfterClass
	public void teardown() {
		RestAssured.requestSpecification = null;
	}
}
