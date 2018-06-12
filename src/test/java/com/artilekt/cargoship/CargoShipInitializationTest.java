package com.artilekt.cargoship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CargoShipInitializationTest {
	private static final int SHIP_CAPACITY = 100;
	private static final CrewMember CAPTAIN   = new Officer("abc001", "Bob Dole", 30, "captain"); 
	private static final CrewMember COMMANDER = new Officer("abc0002", "Bob Smith", 35, "commander");
	private static final CrewMember SEAMAN    = new Seaman("abc98714", "Joe Doe", 45, "does basic duties");
	
	@Test
	public void validateShipConstruction() {
		CargoShip ship = new CargoShip(SHIP_CAPACITY);
		
		// no-op - expect to pass with no exceptions
	}
	
	@Test
	public void validateAddCrewMembersCall() {
		CargoShip ship = new CargoShip(SHIP_CAPACITY);
		ship.addCrewMember(CAPTAIN);
		ship.addCrewMember(COMMANDER);
		ship.addCrewMember(SEAMAN);
		
		// no-op - expect to pass with no exceptions
	}

}
