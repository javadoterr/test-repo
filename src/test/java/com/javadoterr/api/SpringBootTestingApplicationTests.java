package com.javadoterr.api;

import com.javadoterr.api.bean.User;
import com.javadoterr.api.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootTestingApplicationTests {

	@Autowired
	private TestService testService;

	@Test
	public void TestService_testRestClient(){
		User responseUser = testService.testRestClient();
		System.out.println("Name : "+responseUser.getName());
		System.out.println("Email : "+responseUser.getEmail());
		System.out.println("Street : "+responseUser.getAddress().getStreet());
		System.out.println("City : "+responseUser.getAddress().getCity());
		System.out.println("Phone : "+responseUser.getPhone());
		System.out.println("Company Name : "+responseUser.getCompany().getName());
	}

}
