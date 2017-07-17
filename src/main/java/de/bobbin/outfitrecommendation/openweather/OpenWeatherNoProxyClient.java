package de.bobbin.outfitrecommendation.openweather;

import com.github.eddykaya.openweather.client.OpenWeatherClient;

/**
 * A client which requests the openweathermap API directly
 */
public class OpenWeatherNoProxyClient extends OpenWeatherClient{

	OpenWeatherNoProxyClient(final String apiKey) {
		super(apiKey);
	}


}
