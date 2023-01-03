package de.rdj.lib;

import java.util.ArrayList;

public class RacoonFactList {
	private ArrayList<String> facts;
	
	public RacoonFactList(ArrayList<String> facts) {
		this.facts = facts;
	}
	
	public ArrayList<String> asStringList() {
		return facts;
	}
}
