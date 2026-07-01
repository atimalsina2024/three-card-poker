package com.portfolio.threecard.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class DeckTest {
	
	private Deck deck;
	
	@BeforeEach
	public void setup() {
		deck = new Deck();
	}
	
	@DisplayName("Validate Deck has 52 cards")
	@Test
	public void Test_Deck_Has_52_Cards() {
		assertEquals(52, deck.getCards().size());
	}
	
	@DisplayName("Validate All Cards in Deck are unique")
	@Test
	public void Test_Deck_Does_Not_Contain_Duplicate_Cards() {
		Set<Card> deckSet = new HashSet<>(deck.getCards());
		assertEquals(deck.getCards().size(), deckSet.size());
	}
	
	@DisplayName("Validate shuffle changes the order of deck")
	@RepeatedTest(3)
	@Test
	public void Test_Deck_Shuffle() {
		List<Card> originalOrder = new ArrayList<>(deck.getCards());
		deck.shuffle();
		assertNotEquals(originalOrder, deck.getCards());
	}
	
	@DisplayName("Validate dealt card is removed fromdeck")
	@Test
	public void Test_Deck_Size_After_Deal() {
		deck.deal();
		assertEquals(51, deck.getCards().size());
	}
	
	@DisplayName("Validate dealt card is not null")
	@Test
	public void Test_Null_Card_Is_Not_Dealt() {
		assertNotNull(deck.deal());
	}
	
	@DisplayName("Validate OutOfIndexException caught")
	@Test
	public void Test_Dealing_53rd_Card() {
		for(int i=0; i<=52; i++) {
			if(i != 52) {
				deck.deal();
			}
			else {
				assertThrows(IllegalStateException.class, () -> deck.deal());
			}
			
		}
	}
	
	
	

}
