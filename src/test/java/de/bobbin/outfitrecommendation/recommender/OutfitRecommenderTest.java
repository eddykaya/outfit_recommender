package de.bobbin.outfitrecommendation.recommender;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.eddykaya.openweather.entities.external.CurrentWeather;

import de.bobbin.outfitrecommendation.entities.OutfitLevel;
import de.bobbin.outfitrecommendation.entities.OutfitRecommendation;

/**
 *
 */
public class OutfitRecommenderTest {


	@Test(dataProvider = "outfitRecommendationDataTests")
	public void returnsExpectedOutfitRecommendation(CurrentWeather currentWeather, OutfitLevel expectedOutfitLevel) {
		OutfitRecommendation outfitRecommendation = new OutfitRecommender()
			.provideOutfitRecommendationForCurrentWeather(currentWeather);

		Assert.assertEquals(outfitRecommendation.getOutfitLevel(), expectedOutfitLevel);
	}

	@DataProvider(name = "outfitRecommendationDataTests")
	public Object[][] provideTestDataForOutfitRecommendations() {
		return new Object[][]{
			{getCurrentWeatherWithTemperature(26.1), OutfitLevel.ONE},
			{getCurrentWeatherWithTemperature(28.0), OutfitLevel.ONE},
			{getCurrentWeatherWithTemperature(21.0), OutfitLevel.TWO},
			{getCurrentWeatherWithTemperature(25.9), OutfitLevel.TWO},
			{getCurrentWeatherWithTemperature(15.0), OutfitLevel.THREE},
			{getCurrentWeatherWithTemperature(20.9), OutfitLevel.THREE},
			{getCurrentWeatherWithTemperature(5.0), OutfitLevel.FOUR},
			{getCurrentWeatherWithTemperature(14.9), OutfitLevel.FOUR},
			{getCurrentWeatherWithTemperature(4.9), OutfitLevel.FIVE},
			{getCurrentWeatherWithTemperature(0.0), OutfitLevel.FIVE},
			{getCurrentWeatherWithTemperature(-10.0), OutfitLevel.FIVE},
		};
	}

	public CurrentWeather getCurrentWeatherWithTemperature(double currentTemp) {
		return CurrentWeather.builder().currentTemperature(currentTemp).build();
	}
}