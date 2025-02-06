package main;

import java.lang.reflect.Field;

public class Main {
	@Nullable(true)
	private String field=null;
	@Nullable
	private int a=10;
	public static void main(String[] args) throws IllegalAccessException, FieldNotValidException {
		// TODO Auto-generated method stub
		new Main().validateFields();
	}

	private void validateFields() throws FieldNotValidException, IllegalAccessException {
		for (Field f: this.getClass().getDeclaredFields()) {
			if (f.getAnnotation(Nullable.class).value()) {
				if (f.get(this)==null) throw new FieldNotValidException("Campo "+f.getName()+" esta puesto a nulo");
			} 
		}
	}
}
