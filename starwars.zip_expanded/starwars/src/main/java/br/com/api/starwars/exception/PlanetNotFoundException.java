package br.com.api.starwars.exception;

public class PlanetNotFoundException extends Exception{

	private static final long serialVersionUID = -8981013741412977504L;

	public PlanetNotFoundException() {
		super();
	}

	public PlanetNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PlanetNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PlanetNotFoundException(String message) {
		super(message);
	}

	public PlanetNotFoundException(Throwable cause) {
		super(cause);
	}

	
}
