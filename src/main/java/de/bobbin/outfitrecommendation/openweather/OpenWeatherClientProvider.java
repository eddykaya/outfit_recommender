package de.bobbin.outfitrecommendation.openweather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.github.eddykaya.openweather.client.OpenWeatherClient;

@Component
public class OpenWeatherClientProvider {

	@Value("${openweather.api.key}")
	private String openWeatherMapApiKey;

	@Value("${proxy.host}")
	private String proxyHost;

	@Value("${proxy.port}")
	private int proxyPort;

	@Value("${proxy.user}")
	private String proxyUser;

	@Value("${proxy.pass}")
	private String proxyPass;

	@Bean
	public OpenWeatherClient openWeatherClient() {
		if (isProxyWithoutAuth()) {
			return new OpenWeatherProxyClient(openWeatherMapApiKey, proxyHost, proxyPort, "", "");
		}
		if (isProxyWithAuth()) {
			return new OpenWeatherProxyClient(openWeatherMapApiKey, proxyHost, proxyPort, proxyUser, proxyPass);
		}
		return new OpenWeatherNoProxyClient(openWeatherMapApiKey);
	}

	private boolean isProxyWithoutAuth() {
		return !StringUtils.isEmpty(proxyHost) && proxyPort != 0;
	}

	private boolean isProxyWithAuth() {
		return !StringUtils.isEmpty(proxyHost)
			   && proxyPort != 0
			   && StringUtils.isEmpty(proxyUser)
			   && StringUtils.isEmpty(proxyPass);
	}
}
