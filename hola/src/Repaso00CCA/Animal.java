package Repaso00CCA;

public class Animal {
	private int health=100;
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	private String tipo;
	public Animal(String t) {
		this.tipo=t;
	}
	public Animal() {
		this("Animal");
	}
	public String aCadena(Object a) {
		return ("Clase: " + a.getClass().toString() +"\n"
				+ "Health: " + this.health+ "\n" 
				+ "Tipo: " + this.tipo +"\n"
				);
	}
	public void visualiza() {
		System.out.print(this.aCadena(this));
	}
	
}
