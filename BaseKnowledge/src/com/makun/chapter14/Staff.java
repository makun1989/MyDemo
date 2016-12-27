package com.makun.chapter14;

import java.util.ArrayList;

public class Staff extends ArrayList<Position> {

	public void add(String title, Person person) {
		add(new Position(title, person));
	}

	public void add(String... titles) {
		for (String title : titles) {
			add(new Position(title));
		}
	}

	public Staff(String... titles) {
		add(titles);
	}

	public boolean positionAvailable(String title) {
		for (Position position : this) {
			if ((position.getTitle().equals(title)) && (position.getPerson() == Person.NULL))
				return true;
		}
		return false;
	}

	public void fillPosition(String title, Person person) {
		for (Position position : this) {
			if ((position.getTitle().equals(title)) && (position.getPerson() == Person.NULL)) {
				position.setPerson(person);
				return;
			}
		}
		throw new RuntimeException("the title" + title + " is not available.");
	}

}
