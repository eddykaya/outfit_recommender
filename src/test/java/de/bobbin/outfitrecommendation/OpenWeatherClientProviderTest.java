package de.bobbin.outfitrecommendation;

import org.junit.Assert;
import org.mockito.internal.util.reflection.Whitebox;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.eddykaya.openweather.client.OpenWeatherClient;

import de.bobbin.outfitrecommendation.openweather.OpenWeatherClientProvider;
import de.bobbin.outfitrecommendation.openweather.OpenWeatherNoProxyClient;
import de.bobbin.outfitrecommendation.openweather.OpenWeatherProxyClient;

public class OpenWeatherClientProviderTest {

	private OpenWeatherClientProvider providerUnderTest;

	@BeforeMethod
	public void beforeMethod() {
		providerUnderTest = new OpenWeatherClientProvider();
	}

	@Test
	public void providesProxyClientIfEnvVariablesSet() {
		Whitebox.setInternalState(providerUnderTest, "proxyHost", "proxy.example.com");
		Whitebox.setInternalState(providerUnderTest, "proxyPort", 8080);

		OpenWeatherClient actualClient = providerUnderTest.openWeatherClient();

		Assert.assertTrue(actualClient instanceof OpenWeatherProxyClient);
	}

	@Test
	public void providesNoProxyClientIfEnvVariablesNotSet() {
		OpenWeatherClient actualClient = providerUnderTest.openWeatherClient();

		Assert.assertTrue(actualClient instanceof OpenWeatherNoProxyClient);
	}


}