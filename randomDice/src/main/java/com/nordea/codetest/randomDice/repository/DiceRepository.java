package com.nordea.codetest.randomDice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nordea.codetest.randomDice.model.Dice;

public interface DiceRepository extends CrudRepository<Dice, Long> {

	<S extends Dice> S save(Dice dice);

	List<Dice> findAll();
}
