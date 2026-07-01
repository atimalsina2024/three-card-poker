package com.portfolio.threecard.model;

public enum HandRank {

	STRAIGHT_FLUSH("Straight Flush", 6),
	THREE_OF_A_KIND("Three of a Kind", 5),
	STRAIGHT("Straight", 4),
	FLUSH("Flush", 3),
	PAIR("Pair", 2),
	HIGH_CARD("High Card", 1);
	
	private int value;
	private String description;
	
	HandRank(String description, int value){
		this.value = value;
		this.description = description;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public String getDescription() {
		return this.description;
	}
}
