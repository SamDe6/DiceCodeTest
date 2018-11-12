package com.nordea.codetest.randomDice.controller;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nordea.codetest.randomDice.model.Dice;
import com.nordea.codetest.randomDice.service.DiceService;
import com.nordea.codetest.randomDice.service.H2DbTransactionService;

@RestController
public class RandomDiceController {
	private final DiceService diceService;
	private final H2DbTransactionService h2DbService;

	@Autowired
	public RandomDiceController(DiceService diceService, H2DbTransactionService h2DbService) {
		this.diceService = diceService;
		this.h2DbService = h2DbService;
	}

	@RequestMapping(value = "/fetchDiceCount", method = RequestMethod.GET)
	public Map<Integer, Long> fetchDice() {
		return h2DbService.fetchData().stream().map(Dice::getNumber)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

	}

	@Scheduled(fixedDelayString = "${fixedDelay.in.milliseconds}")
	private void scheduleFetchingAndPushingTask() {
		Integer randomDiceNumber = diceService.getRandomDiceNumber();
		h2DbService.saveData(randomDiceNumber);
	}
}
