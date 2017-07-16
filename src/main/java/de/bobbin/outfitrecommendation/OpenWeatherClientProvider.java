package de.bobbin.outfitrecommendation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.github.eddykaya.openweather.client.OpenWeatherClient;

@Component
public class OpenWeatherClientProvider {

	@Value("${openweather.api.key}")
	private String openWeatherMapApiKey;

	@Bean
	public OpenWeatherClient openWeatherClient() {
		return new OpenWeatherClient(openWeatherMapApiKey);
	}

}
