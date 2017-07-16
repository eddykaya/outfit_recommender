package de.bobbin.outfitrecommendation;

import java.util.Collections;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.bobbin.outfitrecommendation.entities.OutfitRecommendation;

@RestController
public class OutfitRecommendationResource {

	@RequestMapping(method = RequestMethod.GET, value = "/weather/{zipCode}/outfit")
	public ResponseEntity<?> getOutfitRecommendations(@PathParam("zipCode") String zipCode) {
		return ResponseEntity.ok(new OutfitRecommendation());
	}

	@RequestMapping(method = RequestMethod.GET, value = "/weather/outfits")
	public ResponseEntity<?> getOutfitRecommendationsForMultipleZipCodes(@RequestParam("zipCodes") List<String>
		zipCodes) {
		return ResponseEntity.ok(Collections.emptyList());
	}

}
