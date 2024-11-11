package Repaso01CCA;

public class Motor {
	public Motor() {}
	public Motor(int cubicajeCC, int potenciaCV) {
		this.cubicajeCC = cubicajeCC;
		this.potenciaCV = potenciaCV;
		}
	private int cubicajeCC;
	private int potenciaCV;
	private final int  limiteKm=300000;
	private int rodaduraKm=0;
	public void rodar(int km) {
		rodaduraKm+=km;
		if (rodaduraKm> limiteKm) throw new RuntimeException("Kilometraje superado!!");
	}
	public void print() {
		System.out.print("Cubicaje en CC: " + this.cubicajeCC+"\n"+
						"Potencia CV: " + this.potenciaCV +"\n"+ 
						"Limite de Km: " + this.limiteKm + "\n"+
						"Rodadura en Km: " + this.rodaduraKm + "\n"+
						"Kilometraje restante (+) o superado (-): "  + (this.limiteKm-this.rodaduraKm)+ "\n"
				);
	}
	public void println() {
		this.print();
		System.out.print("\n");
	}
	public static void main(String[] args) {
		Motor a= new Motor();
		Motor b=new Motor(10,100);
		b.println();
		b.rodar(1000);
		b.println();
		b.rodar(400000);
	}

}
