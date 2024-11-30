package Repaso00CCA;

public class Dog extends Mammal {
	private String size=null;
	Dog(String tipo, String size) {
		super(tipo);
		this.size=size;
	}
	Dog(String tipo) {
		super(tipo);
	}
	Dog() {
		super("Dog");
	}
	@Override
	public String aCadena(Object a) {
		return (super.aCadena(a)+"Tamaño: "+this.size+"\n");
		
	}
}
