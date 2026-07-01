package com.portfolio.threecard.dto;

import java.util.List;

public class DealResponse {

	private List<CardDto> cards;
	
	public DealResponse(List<CardDto> cards) {
		this.cards = cards;
	}
	
	public List<CardDto> getCards(){
		return this.cards;
	}
}
