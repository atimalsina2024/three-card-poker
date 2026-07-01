package com.portfolio.threecard.model;

public enum Rank {
	
	ACE("A",14),
	TWO("2", 2),
	THREE("3",3),
	FOUR("4", 4),
	FIVE("5",5),
	SIX("6", 6),
	SEVEN("7",7),
	EIGHT("8", 8),
	NINE("9", 9),
	TEN("10",10),
	JACK("J", 11),
	QUEEN("Q",12),
	KING("K", 13);
	
	private String displaySymbol;
	private int value;
	
	Rank(String displaySymbol, int value) {
		this.displaySymbol = displaySymbol;
		this.value = value;
	}
	
	public String getDisplaySymbol() {
		return this.displaySymbol;
	}
	public int getRankValue() {
		return this.value;
	}
	
	public static Rank fromDisplayName(String displayName) {
		for(Rank rank: Rank.values()) {
			if(rank.displaySymbol.equalsIgnoreCase(displayName)) {
				return rank;
			}
		}
		throw new IllegalArgumentException("Not a valid rank " + displayName);
	}

}
