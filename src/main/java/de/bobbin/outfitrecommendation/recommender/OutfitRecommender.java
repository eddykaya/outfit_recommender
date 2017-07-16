package de.bobbin.outfitrecommendation.recommender;

import org.springframework.stereotype.Component;

import com.github.eddykaya.openweather.entities.external.CurrentWeather;

import de.bobbin.outfitrecommendation.entities.OutfitLevel;
import de.bobbin.outfitrecommendation.entities.OutfitRecommendation;

@Component
public class OutfitRecommender {

	public OutfitRecommendation provideOutfitRecommendationForCurrentWeather(CurrentWeather currentWeather) {
		double currentTemperature = currentWeather.getCurrentTemperature();

		OutfitLevel outfitLevelForTemperature = OutfitLevel.ONE.getOutfitLevelForBoundary(currentTemperature);

		return OutfitRecommendation.builder().currentTemperature(currentTemperature).outfitLevel
			(outfitLevelForTemperature).build();
	}

}
