package com.portfolio.threecard.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.threecard.model.Card;
import com.portfolio.threecard.model.Deck;
import com.portfolio.threecard.model.HandRank;

@Service
public class GameService {
	
	private static final Logger logger = LoggerFactory.getLogger(GameService.class);
	private final HandEvaluator handEvaluator;
	
	
	@Autowired
	public GameService(HandEvaluator handEvaluator) {
		this.handEvaluator = handEvaluator;
	}
	
	public List<Card> dealHand(){
		Deck deck = new Deck();
		deck.shuffle();
		List<Card> hand = List.of(deck.deal(), deck.deal(), deck.deal());
		logger.info("Hand is dealt "
		+ hand.get(0).toString()
		+ hand.get(1).toString()
		+ hand.get(2).toString());
		return hand;
	}
	
	public HandRank evaluateHand(List<Card> cards) {
		HandRank result = handEvaluator.evaluate(cards);
		logger.info(result.getDescription());
		return result;
	}
	
	

}
