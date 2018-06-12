package com.artilekt.cargoship;

public enum OfficerRank {
	OF_1("OF-1", "Fo-Leifteanant", "Sub Lieutenant"),  // public static OfficerRank OF_1 = new OfficerRank();
	OF_2("OF-2", "Leifteanant", "Lieutenant"),  // public static OfficerRank OF_2 = new OfficerRank();
	OF_3("OF-3", "Leifteanant-Cheannasaí", "Lieutenant Commander"),  // ...
	OF_4("OF-4", "Ceannasaí", "Commander"),
	OF_5("OF-5", "Captaen", "Captain"),
	OF_6("OF-6", "Ceannasóir", "Commodore"),
	OF_7("OF-7", "Seachaimiréal", "Rear Admiral"),
	OF_8("OF-8", "Leas-Aimiréal", "Vice Admiral");
	//--------
	
	private String natoCode, irishSpelling, englishSpelling;
	
	private OfficerRank(String natoCode, String irishSpelling, String englishSpelling) {
		this.natoCode = natoCode;
		this.irishSpelling = irishSpelling;
		this.englishSpelling = englishSpelling;
	}

	public String getNatoCode() {
		return natoCode;
	}

	public String getIrishSpelling() {
		return irishSpelling;
	}

	public String getEnglishSpelling() {
		return englishSpelling;
	}
	
	public static final OfficerRank valueOfLegacy(String legacyRank) {
		switch(legacyRank.toLowerCase()) {
			case "commander":	return OF_4;
			case "captain":		return OF_5;
			default:			throw new IllegalArgumentException("["+legacyRank+"] can't be converted to existin OfficerRank enums");
		}
	}	
	
}
