package com.artilekt.cargoship;

import java.util.Comparator;

public class IdComparator implements Comparator<CrewMember> {

	@Override
	public int compare(CrewMember o1, CrewMember o2) {
		return o1.getId().compareTo(o2.getId());
	}

}
