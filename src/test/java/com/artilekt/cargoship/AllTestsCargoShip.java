package com.artilekt.cargoship;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CargoShipInitializationTest.class,
				CargoShipManagementTest.class, 
				CargoShipCrewSearchTest.class,
				CargoShipCrewSortTest.class
			})
public class AllTestsCargoShip {

}
