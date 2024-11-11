package Repaso00CCA;

public class Cat extends Mammal {
	private int lifes=7;
	Cat() {
		super("Cat");
	}
	Cat(String a) {
		super(a);
	}
	@Override
	public String aCadena(Object a) {
		return (super.aCadena(this)+"Vidas: "+this.lifes+"\n");
		
	}
	
}
