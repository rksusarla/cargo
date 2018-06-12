package com.artilekt.cargoship;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CargoShipCrewSearchTest {
	private CargoShip ship;
	private final static int SHIP_CAPACITY = 100;
	private static final CrewMember CAPTAIN   = new Officer("abc001", "Bob Dole", 30, "captain"); 
	private static final CrewMember COMMANDER = new Officer("abc0002", "Bob Smith", 35, "commander");
	private static final CrewMember SEAMAN    = new Seaman("abc98714", "Joe Doe", 45, "does basic duties");

	private static final CrewMember CAPTAIN_COPY  = new Officer("abc001", "Bob Dole", 30, "captain"); 
	private static final CrewMember SEAMAN_ASHORE = new Seaman("abc914", "Joe Doe2", 45, "does basic duties2");
	
	@Before
	public void setup() {
		ship = new CargoShip(SHIP_CAPACITY);
		
		ship.addCrewMember(CAPTAIN);
		ship.addCrewMember(COMMANDER);
		ship.addCrewMember(SEAMAN);
	}
		
	
	@Test
	public void findCrewMembersByNamePositive() {
		List<CrewMember> matches = ship.findCrewMembersByName("Bob Dole");
		
		assertTrue(matches.contains(CAPTAIN));
		assertTrue(matches.contains(CAPTAIN_COPY));
		assertTrue(!matches.contains(COMMANDER));
		assertEquals(1, matches.size());
	}

	@Test
	public void findCrewMembersByNamePositiveCaseInsensitive() {
		List<CrewMember> matches = ship.findCrewMembersByName("bob dolE");
		
		assertTrue(matches.contains(CAPTAIN));
		assertTrue(matches.contains(CAPTAIN_COPY));
		assertTrue(!matches.contains(COMMANDER));
		assertEquals(1, matches.size());
	}

	@Test
	public void findCrewMembersNameIdNegative() {
		List<CrewMember> matches = ship.findCrewMembersByName("invalid");

		assertTrue(matches.isEmpty());
	}

	@Test
	public void findCrewMembersByIdPositive() {
		List<CrewMember> matches = ship.findCrewMembersById("abc001");
		
		assertTrue(matches.contains(CAPTAIN));
		assertTrue(matches.contains(CAPTAIN_COPY));
		assertTrue(!matches.contains(COMMANDER));
		assertEquals(1, matches.size());
	}

	@Test
	public void findCrewMembersByIdNegative() {
		List<CrewMember> matches = ship.findCrewMembersById("invalid");

		assertTrue(matches.isEmpty());
	}	

	@Test
	public void findCrewMembersByIdAndName() {
		List<CrewMember> matches = ship.findCrewMembers("abc001", "Bob Dole");

		assertEquals(1, matches.size());
		assertTrue(matches.contains(CAPTAIN));
	}
	
	@Test
	public void findCrewMemberByIdPositive() {
//		assertNotNull(ship.findFirstCrewMemberById("abc001"));
		CrewMember c = ship.findFirstCrewMemberById("abc001");
		assertEquals("abc001", c.getId());
	}

	@Test(expected = CrewMemberNotFoundException.class)
	public void findCrewMemberByIdNegative() {
//		assertNotNull(ship.findFirstCrewMemberById("abc001"));
		CrewMember c = ship.findFirstCrewMemberById("invalid");
//		assertEquals("invalid", c.getId());
	}
	
	


}
