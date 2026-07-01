package com.portfolio.threecard.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.portfolio.threecard.service.HandEvaluator;

public class HandEvaluatorTest {
	private HandEvaluator handEvaluator;

	@BeforeEach
	public void testSetup() {
		handEvaluator = new HandEvaluator();
	}

	@ParameterizedTest(name="testStraightFlushHands with {0}")
	@MethodSource("straightFlushHands")
	public void testStraightFlushHands(List<Card> cards) {
		HandRank result = handEvaluator.evaluate(cards);
		assertEquals(HandRank.STRAIGHT_FLUSH, result);
	}

	@ParameterizedTest(name="testThreeOfAKind with {0}")
	@MethodSource("threeOfAKindHands")
	public void testThreeOfAKind(List<Card> cards) {
		HandRank result = handEvaluator.evaluate(cards);
		assertEquals(HandRank.THREE_OF_A_KIND, result);
	}

	@ParameterizedTest(name="testStraight with {0}")
	@MethodSource("straightHands")
	public void testStraight(List<Card> cards) {
		HandRank result = handEvaluator.evaluate(cards);
		assertEquals(HandRank.STRAIGHT, result);
	}
	
	@ParameterizedTest(name="testFlush with {0}")
	@MethodSource("flushHands")
	public void testFlush(List<Card> cards) {
		HandRank result = handEvaluator.evaluate(cards);
		assertEquals(HandRank.FLUSH, result);
	}
	
	@ParameterizedTest(name="testPairs with {0}")
	@MethodSource("pairHands")
	public void testPairs(List<Card>cards) {
		HandRank result = handEvaluator.evaluate(cards);
		assertEquals(HandRank.PAIR, result);
	}
	
	@ParameterizedTest
	@MethodSource("highCardHands")
	public void testHighCards(List<Card> cards) {
		HandRank result = handEvaluator.evaluate(cards);
		assertEquals(HandRank.HIGH_CARD, result);
	}

	static Stream<Arguments> straightFlushHands() {
		return Stream.of(
				Arguments.of(List.of(new Card(Suit.CLUBS, Rank.TWO), new Card(Suit.CLUBS, Rank.THREE),
						new Card(Suit.CLUBS, Rank.FOUR))),
				Arguments.of(List.of(new Card(Suit.DIAMOND, Rank.QUEEN), new Card(Suit.DIAMOND, Rank.KING),
						new Card(Suit.DIAMOND, Rank.ACE))),
				Arguments.of(List.of(new Card(Suit.SPADE, Rank.ACE), new Card(Suit.SPADE, Rank.TWO),
						new Card(Suit.SPADE, Rank.THREE))));
	}

	static Stream<Arguments> threeOfAKindHands() {
		return Stream.of(
				Arguments.of(List.of(new Card(Suit.CLUBS, Rank.ACE), new Card(Suit.DIAMOND, Rank.ACE),
						new Card(Suit.HEARTS, Rank.ACE))),
				Arguments.of(List.of(new Card(Suit.CLUBS, Rank.TWO), new Card(Suit.DIAMOND, Rank.TWO),
						new Card(Suit.SPADE, Rank.TWO))),
				Arguments.of(List.of(new Card(Suit.HEARTS, Rank.KING), new Card(Suit.DIAMOND, Rank.KING),
						new Card(Suit.SPADE, Rank.KING))),
				Arguments.of(List.of(new Card(Suit.HEARTS, Rank.JACK), new Card(Suit.DIAMOND, Rank.JACK),
						new Card(Suit.SPADE, Rank.JACK)))
				
				);
	}

	static Stream<Arguments> straightHands() {
		return Stream.of(
				Arguments.of(List.of(new Card(Suit.CLUBS, Rank.TWO), new Card(Suit.DIAMOND, Rank.THREE),
						new Card(Suit.HEARTS, Rank.FOUR))),
				Arguments.of(List.of(new Card(Suit.SPADE, Rank.QUEEN), new Card(Suit.CLUBS, Rank.KING),
						new Card(Suit.DIAMOND, Rank.ACE))),
				Arguments.of(List.of(new Card(Suit.HEARTS, Rank.ACE), new Card(Suit.CLUBS, Rank.TWO),
						new Card(Suit.DIAMOND, Rank.THREE)))

		);
	}
	
	static Stream<Arguments> flushHands(){
		return Stream.of(
				Arguments.of(List.of(new Card(Suit.CLUBS, Rank.ACE), new Card(Suit.CLUBS, Rank.THREE), 
						new Card(Suit.CLUBS, Rank.FIVE))),
				Arguments.of(List.of(new Card(Suit.DIAMOND, Rank.SEVEN), new Card(Suit.DIAMOND, Rank.NINE),
						new Card(Suit.DIAMOND, Rank.QUEEN))),
				Arguments.of(List.of(new Card(Suit.SPADE, Rank.ACE), new Card(Suit.SPADE, Rank.SEVEN), new Card(Suit.SPADE, Rank.JACK)))
				);
	}
	
	static Stream<Arguments> pairHands(){
		return Stream.of(
				Arguments.of(List.of(new Card(Suit.CLUBS, Rank.ACE), new Card(Suit.DIAMOND, Rank.ACE),
						new Card(Suit.SPADE, Rank.TWO))),
				Arguments.of(List.of(new Card(Suit.SPADE, Rank.TWO), new Card(Suit.HEARTS, Rank.TWO),
						new Card(Suit.DIAMOND, Rank.TEN))),
				Arguments.of(List.of(new Card(Suit.DIAMOND, Rank.KING), new Card(Suit.HEARTS, Rank.KING),
						new Card(Suit.CLUBS, Rank.THREE)))
				);
	}
	
	static Stream<Arguments> highCardHands(){
		return Stream.of(
				Arguments.of(List.of(new Card(Suit.CLUBS, Rank.TWO), new Card(Suit.DIAMOND, Rank.FIVE), 
						new Card(Suit.SPADE, Rank.THREE))),
				Arguments.of(List.of(new Card(Suit.DIAMOND, Rank.JACK), new Card(Suit.DIAMOND, Rank.QUEEN),
						new Card(Suit.SPADE, Rank.ACE))),
				Arguments.of(List.of(new Card(Suit.HEARTS, Rank.NINE), new Card(Suit.CLUBS, Rank.SEVEN),
						new Card(Suit.HEARTS, Rank.KING))),
				Arguments.of(List.of(new Card(Suit.HEARTS, Rank.TEN), new Card(Suit.CLUBS, Rank.JACK),
						new Card(Suit.HEARTS, Rank.ACE)))
				
				);
	}

}
