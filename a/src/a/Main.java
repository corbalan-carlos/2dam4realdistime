package a;

import java.util.Arrays;

public class Main {
	static final int[][] startingArr= {{1,2,3},{4,5,6}};
	static Main.Tuple[] hash=new Tuple[720];
	public static void main(String[] args) throws InterruptedException {
		
	}
	static int hash(int a[][]) {
		int k=720;
		int r=0;
		for (int i[]:a) {
			for (int j:i) {
				k/=j+1;
				r+=k;
			}
		}
		return r;
	}
	static class Tuple {
		boolean a;
		int b;
		Tuple(int b){
			this.b=b;
			a=true;
		}
	}
	
}
 