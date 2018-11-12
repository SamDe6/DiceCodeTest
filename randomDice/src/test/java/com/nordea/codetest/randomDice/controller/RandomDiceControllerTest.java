package com.nordea.codetest.randomDice.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.nordea.codetest.randomDice.model.Dice;
import com.nordea.codetest.randomDice.service.DiceService;
import com.nordea.codetest.randomDice.service.H2DbTransactionService;

@RunWith(MockitoJUnitRunner.class)
public class RandomDiceControllerTest {

	private RandomDiceController diceController;
	@Mock
	private DiceService diceService;
	@Mock
	private H2DbTransactionService h2DbService;

	@Before
	public void setUp() throws Exception {
		diceController = new RandomDiceController(diceService, h2DbService);
	}

	@After
	public void tearDown() throws Exception {
		diceController = null;
	}

	@Test
	public void shouldReturnEmptyWhenNoEntryInDb() {
		// given there is no Data in the DB
		when(h2DbService.fetchData()).thenReturn(List.of());

		// when fetchDice() method is invoked
		Map<Integer, Long> diceCountMap = diceController.fetchDice();

		// then the response count map is empty
		assertThat(diceCountMap.size(), equalTo(0));
	}

	@Test
	public void shouldReturnCorrectCountWhenMultipleEntryInDb() {
		// given there are multiple entries in the DB
		when(h2DbService.fetchData())
				.thenReturn(List.of(new Dice(4), new Dice(1), new Dice(3), new Dice(1), new Dice(4), new Dice(4)));

		// when fetchDice() method is invoked
		Map<Integer, Long> diceCountMap = diceController.fetchDice();

		// then the response count map is non empty and contains correct data
		assertThat(diceCountMap.size(), equalTo(3));
		assertThat(diceCountMap.get(1), equalTo(2L));
		assertThat(diceCountMap.get(3), equalTo(1L));
		assertThat(diceCountMap.get(4), equalTo(3L));
	}

}
