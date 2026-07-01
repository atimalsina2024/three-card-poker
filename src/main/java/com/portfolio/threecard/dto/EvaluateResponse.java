package com.portfolio.threecard.dto;

public class EvaluateResponse {

	private String hand;
	private String description;
	
	public EvaluateResponse() {}
	
	public EvaluateResponse(String hand, String description) {
		this.hand = hand;
		this.description = description;
	}

	public String getHand() {
		return hand;
	}

	public void setHand(String hand) {
		this.hand = hand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
