package com.mycompany.heromarsspring.exceptions;

public class InsufficientActionPointsException extends Exception {
	@Override
	public String toString() {
		return "Nincs elég akciópontod a művelet végrehajtásához.";
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return toString();
	}
	
	
}
