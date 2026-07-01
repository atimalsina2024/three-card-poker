package com.portfolio.threecard.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.portfolio.threecard.model.Card;
import com.portfolio.threecard.model.HandRank;
import com.portfolio.threecard.model.Rank;
import com.portfolio.threecard.model.Suit;

@Service
public class HandEvaluator {
	
	public HandRank evaluate(List<Card> cards) {
		
		if(isFlush(cards) && isStraight(cards)) {
			return HandRank.STRAIGHT_FLUSH;
		}
		else if (isThreeOfAKind(cards)) {
			return HandRank.THREE_OF_A_KIND;
		}
		else if (isStraight(cards)) {
			return HandRank.STRAIGHT;
		}
		else if(isFlush(cards)) {
			return HandRank.FLUSH;
		}
		else if(isPair(cards)) {
			return HandRank.PAIR;
		}
		else return HandRank.HIGH_CARD;
		
	}

	private boolean isFlush(List<Card> cards) {
		Set<Suit> suitSet = cards
				.stream()
				.map(card -> card.getSuit())
				.collect(Collectors.toSet());
		if(suitSet.size() == 1) {
			return true;
		}
		return false;
		
	}
	
	private boolean isStraight(List<Card> cards) {
		List<Integer> cardRanks = cards.stream()
				.map(card -> card.getRank().getRankValue())
				.sorted()
				.toList();
		if(cardRanks.contains(2) && cardRanks.contains(3) && cardRanks.contains(14)) {
				return true;
			}
		if(cardRanks.get(2) - cardRanks.get(0) == 2) {
			return true;
		}
		return false;
	}
	
	private boolean isThreeOfAKind(List<Card> cards) {
		Set<Rank> cardRanks = cards.stream()
				.map(card -> card.getRank())
				.collect(Collectors.toSet());
		if(cardRanks.size() == 1) {
			return true;
		}
		return false;
	}
	
	private boolean isPair(List<Card> cards) {
		Set<Rank> cardRanks = cards.stream()
				.map(card -> card.getRank())
				.collect(Collectors.toSet());
		if(cardRanks.size() == 2) {
			return true;
		}
		return false;
	}
}
