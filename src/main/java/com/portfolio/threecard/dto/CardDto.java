package com.portfolio.threecard.dto;


public class CardDto {

	private String suit;
	private String rank;
	
	public CardDto(String suit, String rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
}
