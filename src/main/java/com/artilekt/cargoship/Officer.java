package com.artilekt.cargoship;

public class Officer extends CrewMember {
	private OfficerRank rank;

	public Officer(String id, String name, int age, OfficerRank rank) {
		super(id, name, age);
		this.rank = rank;
	}
	
	public Officer(String id, String name, int age, String rank) {
		super(id, name, age);
		this.rank = OfficerRank.valueOfLegacy(rank);
	}
	
	public Officer(String id, String name, int age) {
		this(id, name, age, OfficerRank.OF_3);
	}

	public String getRank() {
		return rank.toString();
	}
	
}
