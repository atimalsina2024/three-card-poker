package com.portfolio.threecard.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Card Test")
public class CardTest {
	
	private Card firstCard;
	private Card secondCard;
	private Card thirdCard;
	private Card fourthCard;
	
	@BeforeEach
	public void testSetup() {
		firstCard = new Card(Suit.SPADE, Rank.ACE);
		secondCard = new Card(Suit.CLUBS, Rank.ACE);
		thirdCard = new Card(Suit.SPADE, Rank.EIGHT);
		fourthCard = new Card(Suit.SPADE, Rank.ACE);
	}
	
	@Test
	@DisplayName("Comparing Same Cards should return true ")
	public void Test_Compare_Same_Card() {
		assertEquals(firstCard, firstCard);
	}
	
	@Test
	@DisplayName("Comparing Same Cards should return true ")
	public void Test_Compare_Same_Cards_Objects() {
		assertEquals(firstCard, fourthCard);
	}
	
	@Test
	@DisplayName("Comparing Different Cards should return false ")
	public void Test_Compare_Different_Cards_Objects() {
		assertNotEquals(secondCard, thirdCard);
	}

}
