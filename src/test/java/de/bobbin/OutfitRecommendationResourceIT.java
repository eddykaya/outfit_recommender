package de.bobbin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.Assert;

import de.bobbin.outfitrecommendation.entities.OutfitRecommendation;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OutfitRecommendationResourceIT {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void returns200IfRecommendationIsPresent() {
		ResponseEntity<OutfitRecommendation> response = restTemplate.getForEntity("/weather/outfit?zipCode=76137",
			OutfitRecommendation.class);

		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void returns404IfRecommendationIsNotPresent() {
		ResponseEntity<OutfitRecommendation> response = restTemplate.getForEntity("/weather/outfit?zipCode=00000",
			OutfitRecommendation.class);

		Assert.assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
	}

}
