package de.rdj.lib;

/**
 * Object containing a single racoon fact.
 * @author LouiDev
 *
 */
public class RacoonFact {
	private String fact;
	
	public RacoonFact(String fact) {
		this.fact = fact;
	}
	
	/**
	 * Returns the containing fact as a String object.
	 * @return String
	 */
	public String asString() {
		return fact;
	}
}
