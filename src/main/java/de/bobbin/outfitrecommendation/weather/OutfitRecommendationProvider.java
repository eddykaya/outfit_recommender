package de.bobbin.outfitrecommendation.weather;

import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.eddykaya.openweather.client.OpenWeatherClient;
import com.github.eddykaya.openweather.entities.external.CurrentWeather;

import de.bobbin.outfitrecommendation.entities.OutfitRecommendation;
import de.bobbin.outfitrecommendation.recommender.OutfitRecommender;

@Component
public class OutfitRecommendationProvider {

	private static final Locale DEFAULT_LOCALE = Locale.GERMANY;

	@Autowired
	private OpenWeatherClient openWeatherClient;

	@Autowired
	private OutfitRecommender outfitRecommender;

	public Optional<OutfitRecommendation> getOutfitRecommendationForCity(String city) {
		Optional<CurrentWeather> currentWeather = openWeatherClient.fetchCurrentWeatherAt(city, DEFAULT_LOCALE);
		Optional<OutfitRecommendation> response = Optional.empty();

		if (isWeatherAvailable(currentWeather)) {
			response = buildOutfitRecommendation(currentWeather.get());
		}

		return response;
	}

	private Optional<OutfitRecommendation> buildOutfitRecommendation(final CurrentWeather currentWeather) {
		return Optional.of(outfitRecommender.provideOutfitRecommendationForCurrentWeather(currentWeather));
	}

	private boolean isWeatherAvailable(final Optional<CurrentWeather> currentWeather) {
		return currentWeather.isPresent();
	}

}
