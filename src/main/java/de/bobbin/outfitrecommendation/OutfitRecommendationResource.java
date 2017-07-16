package de.bobbin.outfitrecommendation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.bobbin.outfitrecommendation.entities.OutfitRecommendation;
import de.bobbin.outfitrecommendation.weather.OutfitRecommendationProvider;

@RestController
public class OutfitRecommendationResource {

	@Autowired
	private OutfitRecommendationProvider outfitRecommendationProvider;

	@RequestMapping(method = RequestMethod.GET, value = "/weather/outfit")
	public ResponseEntity<?> getOutfitRecommendations(@RequestParam("zipCode") String zipCode) {
		Optional<OutfitRecommendation> outfitRecommendation = outfitRecommendationProvider
			.getOutfitRecommendationForCity(zipCode);

		return outfitRecommendation.<ResponseEntity<?>>map(ResponseEntity::ok).orElseGet(
			() -> ResponseEntity.notFound().build());
	}
}
