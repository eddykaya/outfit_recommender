package de.bobbin.outfitrecommendation.openweather;

import com.github.eddykaya.openweather.client.OpenWeatherClient;

/**
 * A openweather client which uses a http proxy to request the openweathermap API
 */
public class OpenWeatherProxyClient extends OpenWeatherClient {

	OpenWeatherProxyClient(final String apiKey, final String httpProxyHost, final int httpProxyPort,
		final String httpProxyUser,
		final String httpProxyPass) {
		super(apiKey, httpProxyHost, httpProxyPort, httpProxyUser, httpProxyPass);
	}
}
