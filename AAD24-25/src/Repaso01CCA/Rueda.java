package Repaso01CCA;

public class Rueda {
	public Rueda() {
	}
	
	public Rueda(int diametroPulgadas, int anchuraNominalMm, int ratioAspectoPc, boolean pinchada, boolean cambiar) {
		this.diametroPulgadas = diametroPulgadas;
		this.anchuraNominalMm = anchuraNominalMm;
		this.ratioAspectoPc = ratioAspectoPc;
		this.pinchada = pinchada;
		this.cambiar = cambiar;
	}
	private int diametroPulgadas;
	private int anchuraNominalMm;
	private int ratioAspectoPc;
	private boolean pinchada;
	private boolean cambiar;
	final private int limiteKm=60000;
	private int rodadura=0;
	public void pinchar() {
		pinchada=true;
	}
	public void reparar() {
		pinchada=false;
	}
	public void rodar(int km) throws RuntimeException {
		if (this.pinchada) throw new RuntimeException("La rueda está pinchada!!");
		rodadura+=km;
		cambiar=limiteKm<=rodadura?true:false;
	}
	public void print() {
		System.out.print("Diametro en pulgadas: "+ this.diametroPulgadas+"\n"+
				"Anchura Nominal en mm: "+this.anchuraNominalMm+"\n"+
				"Relacion de Aspecto: " + this.ratioAspectoPc+"\n"+
				"Pinchada: " + this.pinchada+"\n"+ 
				"Cambiar: " + this.cambiar+"\n" +
				"Limite Km: " + this.limiteKm +"\n"+
				"Km restantes(+) o excedidos(-):" + (this.limiteKm-this.rodadura)+"\n"
				);
	}
	public void println() {
		this.print();
		System.out.print("\n");
	}
	public static void main (String args[]) {
		Rueda a =new Rueda();
		Rueda b= new Rueda(10,10,10,false,false);
		b.println();
		b.pinchar();
		b.println();
		b.reparar();
		b.rodar(100);
		b.println();
		b.pinchar();
		b.rodar(1);
	}
}
