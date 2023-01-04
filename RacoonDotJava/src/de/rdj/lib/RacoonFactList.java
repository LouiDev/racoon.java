package de.rdj.lib;

import java.util.List;

/**
 * Object containing a list of racoon facts.
 * @author LouiDev
 *
 */
public class RacoonFactList {
	private List<String> facts;
	
	public RacoonFactList(List<String> facts) {
		this.facts = facts;
	}
	
	/**
	 * Returns the containing facts as a String list.
	 * @return ArrayList
	 */
	public List<String> asStringList() {
		return facts;
	}
}
