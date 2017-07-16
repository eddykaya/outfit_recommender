package de.bobbin.outfitrecommendation.weather;

import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.eddykaya.openweather.client.OpenWeatherClient;
import com.github.eddykaya.openweather.entities.external.CurrentWeather;

import de.bobbin.outfitrecommendation.entities.OutfitRecommendation;

@Component
public class OutfitRecommendationClient {

	private static final String DEFAULT_COUNTRY = "DE";

	@Autowired
	private OpenWeatherClient openWeatherClient;

	public Optional<OutfitRecommendation> getOutfitRecommendationForCity(String city) {
		Optional<CurrentWeather> currentWeather = openWeatherClient.fetchCurrentWeatherAt(city, Locale.GERMANY);
		Optional<OutfitRecommendation> response = Optional.empty();

		if (isWeatherAvailable(currentWeather)) {
			response = buildOutfitRecommendation(currentWeather.get());
		}

		return response;
	}

	private Optional<OutfitRecommendation> buildOutfitRecommendation(final CurrentWeather currentWeather) {
		return Optional.of(OutfitRecommendation.builder().currentTemperature(currentWeather.getCurrentTemperature()).build());
	}

	private boolean isWeatherAvailable(final Optional<CurrentWeather> currentWeather) {
		return currentWeather.isPresent();
	}

}
