package com.javaegitimleri.petclinic;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.javaegitimleri.petclinic.model.Owner;
import com.javaegitimleri.petclinic.service.PetClinicService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class PetclinicRefApplicationTests {
	
	@Autowired
	private WebApplicationContext appContext;
	
	@Autowired
	private PetClinicService pcs;
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;
	
	private RestTemplate restTemplate;
	
	private String baseUrl;
	
	@Before
	public void setUp() {
		restTemplate = restTemplateBuilder.build();
		baseUrl = "http://localhost:" + port + "/rest/";
	}

	@Test
	public void testCreateOwner() {
		Owner o = new Owner();
		o.setEmail("foo@bar");
		o.setFirstName("Foo");
		o.setLastName("Bar");
		Long id = restTemplate.postForObject(baseUrl + "owner", o, Long.class);
		
		String response = restTemplate.getForObject(baseUrl + "owner/" + id, 
				String.class);
		
		System.out.println(">>>" + response);
	}

}
