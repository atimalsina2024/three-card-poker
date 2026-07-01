package com.portfolio.threecard.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	private final List<Card> deck = new ArrayList<>();
	
	public Deck() {
		buildNewDeck();
	}
	
	public void buildNewDeck() {
		
		for(Suit suit: Suit.values()) {
			for(Rank rank: Rank.values()) {
				deck.add(new Card(suit, rank));
			}
		}
	}
	
	public List<Card> getCards(){
		return Collections.unmodifiableList(deck);
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public Card deal() {
		if(!deck.isEmpty()) {
			Card dealtCard = deck.get(0);
			deck.remove(0);
			return dealtCard;
		}
		throw new IllegalStateException("Deck is empty");
		
	}
	
	

}
