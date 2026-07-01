package com.portfolio.threecard.dto;

import java.util.List;

public class EvaluateRequest {
	
	private List<CardDto> cards;
	
	public EvaluateRequest() {}
	
	public EvaluateRequest(List<CardDto> cards) {
		this.cards = cards;
	}

	public List<CardDto> getCards() {
		return cards;
	}

	public void setCards(List<CardDto> cards) {
		this.cards = cards;
	}

}
