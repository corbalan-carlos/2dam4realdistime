package prueba;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		A a=new A();
		new Thread(a).start();
		new Thread( () ->  {
			try {
				a.hola();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			a.notify();
			
		}).start();
		System.out.print(a.i);
		
		System.out.print(a.i);
	}

}
