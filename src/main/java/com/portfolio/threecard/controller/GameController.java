package com.portfolio.threecard.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.threecard.dto.CardDto;
import com.portfolio.threecard.dto.DealResponse;
import com.portfolio.threecard.dto.EvaluateRequest;
import com.portfolio.threecard.dto.EvaluateResponse;
import com.portfolio.threecard.model.Card;
import com.portfolio.threecard.model.HandRank;
import com.portfolio.threecard.model.Rank;
import com.portfolio.threecard.model.Suit;
import com.portfolio.threecard.service.GameService;

@RestController
@RequestMapping("/api")
public class GameController {

	private static final Logger logger = LoggerFactory.getLogger(GameController.class);
	private final GameService gameService;

	@Autowired
	public GameController(GameService gameService) {
		this.gameService = gameService;
	}

	@PostMapping("/deal")
	public ResponseEntity<DealResponse> deal() {
		logger.info("Deal Request received");
		List<Card> cards = gameService.dealHand();
		List<CardDto> cardDto = cards.stream()
				.map(card -> new CardDto(card.getSuit().getDisplayName(), card.getRank().getDisplaySymbol())).toList();
		DealResponse dealResponse = new DealResponse(cardDto);
		logger.debug("number of cards in response are {}", dealResponse.getCards().size());
		return ResponseEntity.ok(dealResponse);
	}

	@PostMapping("/evaluate")
	public ResponseEntity<EvaluateResponse> evaluate(@RequestBody EvaluateRequest request) {
		logger.info("evaluate request received");
		logger.info(request.toString());
		if (request.getCards().size() != 3) {
			logger.warn("Hand does not have 3 cards");
			return ResponseEntity.badRequest()
					.body(new EvaluateResponse("INVALID_REQUEST","Hand has " + request.getCards().size() + " card/s which is not valid for 3 card poker"));
		}
		List<Card> hand = request.getCards().stream()
				.map(card -> new Card(Suit.fromDisplayName(card.getSuit()), Rank.fromDisplayName(card.getRank())))
				.toList();
		HandRank handResult = gameService.evaluateHand(hand);
		EvaluateResponse resp = new EvaluateResponse(handResult.name(), handResult.getDescription());
		return ResponseEntity.ok(resp);

	}

}
