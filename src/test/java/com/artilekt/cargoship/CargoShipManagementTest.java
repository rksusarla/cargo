package com.artilekt.cargoship;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CargoShipManagementTest {
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
	public void checkShipCapacityIsCorrect() {
		assertEquals(SHIP_CAPACITY, ship.getShipCapacity());
	}

	@Test
	public void checkShipAvailableSpacesAfterAddingCrew() {
		CargoShip ship = new CargoShip(SHIP_CAPACITY);
		
		ship.addCrewMember(CAPTAIN);
		ship.addCrewMember(COMMANDER);

		assertEquals(SHIP_CAPACITY - 2, ship.getAvailableSpaces());
	}
	
	@Test
	public void checkSpacesAvailableReport() {
		assertTrue(ship.isSpaceAvailable());
	}
	
	@Test
	public void checkSpacesAvailableReportAtFullCapacity() {
		CargoShip ship = new CargoShip(2);
		
		ship.addCrewMember(CAPTAIN);
		ship.addCrewMember(COMMANDER);

		assertFalse(ship.isSpaceAvailable());
	}
	
	@Test(expected = ShipOutOfSpaceException.class)
	public void addingBeyondShipCapacity() {
		CargoShip ship = new CargoShip(2);
		
		ship.addCrewMember(CAPTAIN);
		ship.addCrewMember(COMMANDER);
		ship.addCrewMember(SEAMAN);
		
		// no-op - should not get here
	}
	
	@Test
	public void removalOfExistingCrewMemberByReference() {
		assertTrue(ship.removeCrewMember(CAPTAIN));
	}

	@Test
	public void removalOfExistingCrewMemberByCopy() {
		assertTrue(ship.removeCrewMember(CAPTAIN_COPY));
	}

	@Test
	public void removalOfNonExistingCrewMember() {
		assertFalse(ship.removeCrewMember(SEAMAN_ASHORE));
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void checkForImmutabilityOfReturnedCrewMemebers() {
		List<CrewMember> crew = ship.getCrewMembers();
		crew.add(CAPTAIN_COPY);
	}
	
	@Test
	public void canOnlyAddUniqueCrewMembers() {
		// get current size of the crew
		int size = ship.getCrewSize();
		
		// add someone who is already on the ship
		// validate return is 'false'
		assertFalse(ship.addCrewMember(CAPTAIN));
		
		// check that the size of the crew remained unchanged
		assertEquals(size, ship.getCrewSize());
		
		// add an exact clone of the captian; collection shoudln't change
		assertFalse(ship.addCrewMember(CAPTAIN_COPY));
		
		// check that the size of the crew remained unchanged
		assertEquals(size, ship.getCrewSize());
		
		// add someone with new ID
		assertTrue(ship.addCrewMember(SEAMAN_ASHORE));
		
		// check that the size of the crew remained unchanged
		assertEquals(size + 1, ship.getCrewSize());
	}
	
}
