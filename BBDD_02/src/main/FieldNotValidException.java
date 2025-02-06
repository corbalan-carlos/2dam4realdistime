package main;

public class FieldNotValidException extends Exception {
	private static final long serialVersionUID = 1L;
	public FieldNotValidException(String message) {
		super(message);
	}

}
