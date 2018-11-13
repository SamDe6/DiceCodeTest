package com.nordea.codetest.randomDice.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiceServiceTest {

	@Autowired
	private DiceService diceService;

	@Test
	public void shouldReturn1to6WhenInvokedMultipleTimes() {
		int min = 1; // Minimum Dice number
		int max = 6; // Maximum Dice number
		IntStream.range(0, 100).parallel().forEach(n -> {
			assertThat(diceService.getRandomDiceNumber()).matches(actual -> actual >= min && actual <= max);
		});
	}

}
