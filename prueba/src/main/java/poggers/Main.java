package poggers;

public class Main {
	static {
		System.loadLibrary("b");
	}
	public static void main(String[] args) {	
		System.out.println(new Main().f());

	}
	native int f();
}
