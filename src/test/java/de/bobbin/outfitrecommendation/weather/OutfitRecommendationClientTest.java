package de.bobbin.outfitrecommendation.weather;

import java.util.Locale;
import java.util.Optional;

import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.eddykaya.openweather.client.OpenWeatherClient;
import com.github.eddykaya.openweather.entities.external.CurrentWeather;

import de.bobbin.outfitrecommendation.entities.OutfitRecommendation;
import de.bobbin.outfitrecommendation.recommender.OutfitRecommender;

public class OutfitRecommendationClientTest {

	public static final String UNKNOWN_CITY = "00000";
	public static final String KNOWN_CITY = "73730";

	@InjectMocks
	private OutfitRecommendationProvider clientUnderTest;

	@Mock
	private OpenWeatherClient openWeatherClient;

	@Spy
	private OutfitRecommender outfitRecommender;

	@BeforeMethod
	public void beforeMethod() {
		MockitoAnnotations.initMocks(this);

		Mockito.doReturn(
			Optional.of(CurrentWeather.builder().currentTemperature(0d).build()))
			.when(openWeatherClient)
			.fetchCurrentWeatherAt(KNOWN_CITY, Locale.GERMANY);

		Mockito.doReturn(
			Optional.empty())
			.when(openWeatherClient)
			.fetchCurrentWeatherAt(UNKNOWN_CITY, Locale.GERMANY);

	}

	@Test
	public void returnsEmptyOptionalIfCityWasNotFound() {
		Optional<OutfitRecommendation> actualRecommendation = clientUnderTest.getOutfitRecommendationForCity
			(UNKNOWN_CITY);

		Assert.assertFalse(actualRecommendation.isPresent());
	}

	@Test
	public void returnsOutfitRecommendationIfCityWasFound() {
		Optional<OutfitRecommendation> actualRecommendation = clientUnderTest.getOutfitRecommendationForCity
			(KNOWN_CITY);

		Assert.assertTrue(actualRecommendation.isPresent());
	}



}