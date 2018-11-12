package com.nordea.codetest.randomDice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Dice {
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private Integer number;

	public Dice() {
		// Default Constructor for maintaining JPA standards
	}

	public Dice(Integer number) {
		this.number = number;
	}

	public Integer getNumber() {
		return number;
	}
	
	@Override
	public String toString() {
		return String.format("Dice[id=%d, number='%s']", id, number);
	}
}
