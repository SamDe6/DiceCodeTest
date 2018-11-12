package com.nordea.codetest.randomDice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nordea.codetest.randomDice.model.Dice;

@Repository
public interface DiceRepository extends CrudRepository<Dice, Long> {

	Dice save(Dice dice);

	List<Dice> findAll();
}
