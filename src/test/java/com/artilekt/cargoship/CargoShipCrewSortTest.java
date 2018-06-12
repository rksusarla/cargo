package com.artilekt.cargoship;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CargoShipCrewSortTest {
	private CargoShip ship;
	private final static int SHIP_CAPACITY = 100;
	private static final CrewMember LOWEST_ID   = new Officer("a001", "Bob Dole", 37, "captain"); 
	private static final CrewMember LOWEST_NAME   = new Officer("z01", "Aaron Ace", 37, "captain"); 
	private static final CrewMember CAPTAIN   = new Officer("ge001", "Bob Dole", 37, "captain"); 
	private static final CrewMember COMMANDER = new Officer("hsc0002", "Bob Smith", 35, "commander");
	private static final CrewMember COMMANDER2 = new Officer("abc0002", "Bob Smith", 25, "commander");
	private static final CrewMember SEAMAN    = new Seaman("x714", "Joe Doe2", 83, "does basic duties");
	private static final CrewMember SEAMAN2    = new Seaman("abc98714", "Joe Doe", 45, "does basic duties");
	private static final CrewMember SEAMAN3    = new Seaman("awg714", "Joe Doe", 45, "does basic duties");

	private static final CrewMember CAPTAIN_COPY  = new Officer("abc001", "Bob Dole", 30, "captain"); 
	private static final CrewMember SEAMAN_ASHORE = new Seaman("abc914", "Joe Doe2", 45, "does basic duties2");
	
	@Before
	public void setup() {
		ship = new CargoShip(SHIP_CAPACITY);
		
		ship.addCrewMember(CAPTAIN);
		ship.addCrewMember(COMMANDER);
		ship.addCrewMember(COMMANDER2);
		ship.addCrewMember(SEAMAN);
		ship.addCrewMember(LOWEST_ID);
		ship.addCrewMember(SEAMAN2);
		ship.addCrewMember(LOWEST_NAME);
		ship.addCrewMember(SEAMAN3);
	}

	
	@Test
	public void validateSortingById() {
		List<CrewMember> sortedList = ship.sortCrewMembersById();
//		assertEquals(CAPTAIN, ship.getCrewMembers().get(0));
		assertEquals(LOWEST_ID, sortedList.get(0));
	}

	@Test
	public void validateSortingByName() {
		List<CrewMember> sortedList = ship.sortCrewMembersByName();
//		assertNotEquals(LOWEST_NAME, ship.getCrewMembers().get(0));
		assertEquals(LOWEST_NAME, sortedList.get(0));
	}


	
	@Test
	public void printOrderedListForCrewMembers() {
		List<CrewMember> unsortedList = ship.getCrewMembers();
		printCrewMembers("Unsorted List", unsortedList);
		List<CrewMember> sortedList = ship.sortCrewMembers();
		printCrewMembers("Sorted List", sortedList);
	}

	private void printCrewMembers(String msg, List<CrewMember> list) {
		System.out.println(msg);
		for (CrewMember crewMember: list) {
			System.out.println(crewMember);
		}
	}
	
	

}
