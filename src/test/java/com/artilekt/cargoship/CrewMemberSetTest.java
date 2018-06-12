package com.artilekt.cargoship;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class CrewMemberSetTest {
	@Test
	public void testSet1() {
		Set<CrewMember> cms = new HashSet<>();
		
		cms.add(new CrewMember("a001", "member1", 30));
		cms.add(new CrewMember("a002", "member2", 30));
		cms.add(new CrewMember("a002", "member3", 40));
		cms.add(new CrewMember("a001", "member1", 30));
		
		Iterator<CrewMember> iter = cms.iterator();
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	@Test
	public void testList() {
		List<CrewMember> cms = new ArrayList<>();
		
		cms.add(new CrewMember("a", "cap", 30));
		cms.add(new CrewMember("a", "cap", 30));
		cms.add(new CrewMember("a", "cap", 30));
		cms.add(new CrewMember("a", "cap", 30));
		cms.remove(new CrewMember("a", "cap", 30));
		
		Iterator<CrewMember> iter = cms.iterator();
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
