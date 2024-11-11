package Repaso01CCA;

public class Coche {
	
	public Coche() {
		this.ruedaDelanteraDerecha = new Rueda(100,10,10,false,false);
		this.ruedaTraseraDerecha = new Rueda(100,10,10,false,false);
		this.ruedaDelanteraIzquierda = new Rueda(100,10,10,false,false);
		this.ruedaTraseraIzquierda = new Rueda(100,10,10,false,false);
		this.motor = new Motor(100,100);
	}
	public Coche(int a,int b,int c, boolean d, boolean e, int f, int g) {
		this.ruedaDelanteraDerecha = new Rueda(a,b,c,d,e);
		this.ruedaTraseraDerecha = new Rueda(a,b,c,d,e);
		this.ruedaDelanteraIzquierda = new Rueda(a,b,c,d,e);
		this.ruedaTraseraIzquierda = new Rueda(a,b,c,d,e);
		this.motor = new Motor(f,g);
	}
	private Rueda ruedaDelanteraDerecha;
	private Rueda ruedaTraseraDerecha;
	private Rueda ruedaDelanteraIzquierda;
	private Rueda ruedaTraseraIzquierda;
	private Motor motor;
	public void rodar(int km ){
		ruedaDelanteraDerecha.rodar(km);
		ruedaDelanteraIzquierda.rodar(km);
		ruedaTraseraIzquierda.rodar(km);
		ruedaTraseraDerecha.rodar(km);
		motor.rodar(km);
	}
	public void print() {
		ruedaDelanteraDerecha.print();
		ruedaDelanteraIzquierda.print();
		ruedaTraseraIzquierda.print();
		ruedaTraseraDerecha.print();
		motor.print();
	}
	public void println() {
		this.print();
		System.out.print("\n");
	}
	public static void main(String args[]) {
		Coche a=new Coche();
		Coche b=new Coche(200,5,10,false,false,34,100);
		b.println();
		b.rodar(100);
		b.println();
	}
}
