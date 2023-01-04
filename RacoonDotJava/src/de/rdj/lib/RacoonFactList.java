package de.rdj.lib;

import java.util.ArrayList;

/**
 * Object containing a list of racoon facts.
 * @author LouiDev
 *
 */
public class RacoonFactList {
	private ArrayList<String> facts;
	
	public RacoonFactList(ArrayList<String> facts) {
		this.facts = facts;
	}
	
	/**
	 * Returns the containing facts as a String list.
	 * @return ArrayList
	 */
	public ArrayList<String> asStringList() {
		return facts;
	}
}
