package com.creditcardprocessing.api;

import com.creditcardprocessing.api.model.CreditCardModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CreditCardProcessingApplicationTests {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void addCreditCardTest() {
		CreditCardModel cc = CreditCardModel.build(
				0L,
				"Test Name",
				"122000000000003",
				2000L,
				0L
		);
		HttpEntity<CreditCardModel> request = new HttpEntity<>(cc);
		ResponseEntity<CreditCardModel> response = testRestTemplate.postForEntity("/credit-card/add", request, CreditCardModel.class);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
		Assertions.assertEquals("122000000000003", response.getBody().getCard_number());
	}

	@Test
	public void getAllCreditCardsTest() {
		ResponseEntity <CreditCardModel[]> response = testRestTemplate.getForEntity("/credit-card/all", CreditCardModel[].class);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
}
