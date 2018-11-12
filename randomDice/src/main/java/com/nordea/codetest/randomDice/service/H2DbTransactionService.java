package com.nordea.codetest.randomDice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nordea.codetest.randomDice.model.Dice;
import com.nordea.codetest.randomDice.repository.DiceRepository;

@Service
public class H2DbTransactionService {

	private final DiceRepository diceRepo;

	@Autowired
	public H2DbTransactionService(DiceRepository diceRepo) {
		this.diceRepo = diceRepo;
	}

	public void saveData(int diceNumber) {
		Dice dice = new Dice(diceNumber);
		diceRepo.save(dice);
	}

	public List<Dice> fetchData() {
		return diceRepo.findAll();
	}
}
