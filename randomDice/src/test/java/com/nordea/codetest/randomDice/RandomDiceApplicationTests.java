package com.nordea.codetest.randomDice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nordea.codetest.randomDice.controller.RandomDiceController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RandomDiceApplicationTests {

	@Autowired
	private RandomDiceController controller;

	@Test
	public void testContextLoads() {
		assertThat(controller).isNotNull();
	}

}
