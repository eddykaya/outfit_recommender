package de.bobbin.outfitrecommendation.entities;

import java.util.Arrays;

public enum OutfitLevel {

	ONE(1, 26, Integer.MAX_VALUE),
	TWO(2, 21, 26),
	THREE(3, 15, 21),
	FOUR(4, 5, 15),
	FIVE(5,Integer.MIN_VALUE, 5);

	int level;
	int lowerBoundary;
	int higherBoundary;

	OutfitLevel(int level, int lowerBoundary, int higherBoundary) {
		this.level = level;
		this.lowerBoundary = lowerBoundary;
		this.higherBoundary = higherBoundary;
	}

	public OutfitLevel getOutfitLevelForBoundary(Double temperature) {
		int temperatureBeforeDecimals = temperature.intValue();

		return Arrays.asList(OutfitLevel.values()).stream().filter(
			level -> temperatureBeforeDecimals >= level.lowerBoundary &&
					 temperatureBeforeDecimals < level.higherBoundary)
			.findFirst().get();
	}

}
