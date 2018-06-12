package com.artilekt.cargoship;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CargoShip {
	private Set<CrewMember> crewMembers = new HashSet<>();
	private int totalCapacity;

	/**
	 * Creates a new ship with a fixed capacity.
	 * @param totalCapacity Total number of crew members the ship can accomodate
	 */
	public CargoShip(int totalCapacity) {
		this.totalCapacity = totalCapacity;
	}

	/**
	 * Adds a crew member to the ship.
	 * Returns 'true' if member was successfully added; 'false' otherwise (if crewMember already exists)
	 * @param crewMember
	 * @throws ShipOutOfSpaceException if there is no more space in the ship
	 */
	public boolean addCrewMember(CrewMember crewMember) {
		if (!isSpaceAvailable())
			throw new ShipOutOfSpaceException("can't add more people");

		if (crewMembers.contains(crewMember))	return false;
		
		crewMembers.add(crewMember);
		
		return true;
	}
	
	/**
	 * Removes crew member if it exists
	 * @return <tt>true</tt> if crew member was in the collection; false - otherwise 
	 */
	public boolean removeCrewMember(CrewMember crewMember) {
		return crewMembers.remove(crewMember);
	}

	public boolean isSpaceAvailable()   { return totalCapacity - crewMembers.size() > 0; }
	public int     getAvailableSpaces() { return totalCapacity - crewMembers.size();     }
	public int     getShipCapacity()    { return totalCapacity;                          }
	public int     getCrewSize()        { return crewMembers.size(); }

	
	/**
	 * get crew members as 'read-only' list to prevent from external modification
	 * @return
	 */
	public List<CrewMember> getCrewMembers() {
		return Collections.unmodifiableList(new ArrayList<CrewMember>(crewMembers));
	}
	
	
	//--- Extra methods to facilitate search through list of crew members ---//
	/**
	 * Finds all crew members on the ship where name matches (ignoring case)
	 * @param crewMemberName Name of the crew member to search by
	 * @return unmodifiable list of crew members matching {@code crewMemberName}
	 */
	public List<CrewMember> findCrewMembersByName(String crewMemberName) {
		crewMemberName = crewMemberName.toLowerCase();
		List<CrewMember> matches = new ArrayList<CrewMember>();
		
		for (CrewMember crewMember: crewMembers) {
			if (crewMember.getName().toLowerCase().equals(crewMemberName))
				matches.add(crewMember);
		}
		return matches;
	}

	/**
	 * Finds all crew members on the ship where id matches (case sensitive)
	 * @param crewMemberId id of the crew member to search the list by
	 * @return unmodifiable list of crew members matching {@code crewMemberName}
	 */
	public List<CrewMember> findCrewMembersById(String crewMemberId) {
		List<CrewMember> matches = new ArrayList<CrewMember>();
		for (CrewMember crewMember: crewMembers) {
			if (crewMember.getId().equals(crewMemberId))
				matches.add(crewMember);
		}
		return Collections.unmodifiableList(matches);
	}
	
	public List<CrewMember> findCrewMembers(String crewMemberId) {
		return findCrewMembersById(crewMemberId);
	}
	
	public List<CrewMember> findCrewMembers(String crewMemberId, String crewMemberName) {
		List<CrewMember> matches = new ArrayList<CrewMember>();
		crewMemberName = crewMemberName.toLowerCase();
		for (CrewMember crewMember: crewMembers) {
			if (crewMember.getId().equals(crewMemberId) &&
				crewMember.getName().toLowerCase().equals(crewMemberName))
					matches.add(crewMember);
		}
		return Collections.unmodifiableList(matches);
	}
	
	
	public CrewMember findFirstCrewMemberById(String crewMemberId) {
		for (CrewMember crewMember: crewMembers) {
			if (crewMember.getId().equals(crewMemberId))   return crewMember;
		}
		throw new CrewMemberNotFoundException("Crew member with id ["+crewMemberId+"] not found");
	}

	public List<CrewMember> sortCrewMembers() {
		List<CrewMember> copy = new ArrayList<>(crewMembers);
		Collections.sort(copy);
		return copy;
	}
	
	public List<CrewMember> sortCrewMembersByName() {
		List<CrewMember> copy = new ArrayList<>(crewMembers);
		Collections.sort(copy, new Comparator<CrewMember>() {
			@Override
			public int compare(CrewMember o1, CrewMember o2) {
				return o1.getName().compareTo(o2.getName());
			}			
		});
		return copy;
	}
	
/*
	// this is a more traditional version of 'sort' implementation
  	public List<CrewMember> sortCrewMembersById() {
		List<CrewMember> copy = new ArrayList<>(crewMembers);
		Collections.sort(copy, new IdComparator());
		return copy;
	}	
*/

	/**
	 * java8 implementation using Lambdas & method reference
	 * @return
	 */
	public List<CrewMember> sortCrewMembersById() {
		List<CrewMember> copy = new ArrayList<>(crewMembers);
		Collections.sort(copy,  Comparator.comparing(CrewMember::getId));
		return copy;
	}

//	public List<CrewMember> sortCrewMembersByAge() {
//		throw new UnsupportedOperationException("not yet implemented");
//	}
	
	
}
