package de.bobbin.outfitrecommendation.entities;

import lombok.Builder;
import lombok.Data;

/**
 *
 */
@Data
@Builder
public class OutfitRecommendation {

	private double currentTemperature;
	private OutfitLevel outfitLevel;

}
