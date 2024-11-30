package Repaso01CCA;

public class Camion extends Coche {
	
	public Camion(int tara, int pma, int n) {
		super();
		this.tara = tara;
		this.pma = pma;
		this.ra=new Rueda[n];
	}
	public Camion() {
		super();
	}
	public Camion(int tara, int pma, int n,int a,int b,int c, boolean d, boolean e, int f, int g) {
		super(a,b,c,d,e,f,g);
		this.tara = tara;
		this.pma = pma;
		this.ra=new Rueda[n];
		for (Rueda r: ra ) r=new Rueda(a,b,c,d,e);
	}
	public Camion(int a,int b,int c, boolean d, boolean e, int f, int g) {
		super(a,b,c,d,e,f,g);
	}
	private int tara;
	private int pma;
	private Rueda ra[];
	@Override
	public void rodar(int km) {
		super.rodar(km);
		for (Rueda r: ra) {
			r.rodar(km);
		}
	}
	@Override
	public void print() {
		System.out.print("PMA: " + this.pma+ "\n"+
						"Tara: " + this.tara +"\n"
				);
		for (Rueda r: ra) {
			r.print();
		}
		super.print();
	}
	@Override
	public void println() {
		this.print();
		System.out.print("\n");
	}
	public static void main() {
		Camion a = new Camion (1000, 150,4 ,200,5,10,false,false,34,100);
		a.println();
		a.rodar(100);
		a.println();
	}
}
