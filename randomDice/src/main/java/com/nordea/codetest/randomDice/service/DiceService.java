package com.nordea.codetest.randomDice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DiceService {

	private final RestTemplate restTemplate;

	@Value(value = "${url.random.dice}")
	private String randomDiceUrl;

	@Autowired
	public DiceService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Integer getRandomDiceNumber() {
		String rawString = restTemplate.getForObject(randomDiceUrl, String.class);
		return Integer.parseInt(rawString.substring(0, 1)); // Dice number would always be 1 to 6
	}

}
