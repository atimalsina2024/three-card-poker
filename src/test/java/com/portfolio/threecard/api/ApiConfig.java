package com.portfolio.threecard.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiConfig {

	public static RequestSpecification requestSpec = new 
			RequestSpecBuilder()
			.setBaseUri("http://localhost:8080")
			.setContentType(ContentType.JSON)
			.setAccept(ContentType.JSON)
			.build();	
}
