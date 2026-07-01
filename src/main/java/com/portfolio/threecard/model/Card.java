package com.portfolio.threecard.model;

public class Card {

	private final Suit suit;
	private final Rank rank ;
	
	public Card(Suit suit, Rank rank) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public Suit getSuit() {
		return this.suit;
	}
	
	public Rank getRank() {
		return this.rank;
	}
	
	@Override
	public String toString() {
		return this.suit.getSymbol() + this.rank.getDisplaySymbol();
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(!( o instanceof Card other)) return false;
		return this.rank == other.rank && this.suit == other.suit;
		
	}
	
	@Override
	public int hashCode() {
		return 31* suit.ordinal() + rank.ordinal();
	}
	
	
}
