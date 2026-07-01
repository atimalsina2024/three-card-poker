package com.portfolio.threecard.model;

public enum Suit {
	HEARTS("Hearts","♥"),
	DIAMOND("Diamonds","♦"),
	CLUBS("Clubs","♣"),
	SPADE("Spade", "♠");
	
	private String displayName;
	private String symbol;
	
	Suit(String displayName, String symbol){
		this.displayName = displayName;
		this.symbol = symbol;
		
	}
	
	public String getDisplayName() {
		return this.displayName;
	}
	
	public String getSymbol() {
		return this.symbol;
	}
	
	public static Suit fromDisplayName(String displayName) {
		for(Suit suit : Suit.values()) {
			if(suit.displayName.equalsIgnoreCase(displayName)) {
				return suit;
			}
		}
		throw new IllegalArgumentException("Invalid suit "+displayName);
	}
}
