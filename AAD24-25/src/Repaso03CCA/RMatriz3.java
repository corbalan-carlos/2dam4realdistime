package Repaso03CCA;

public class RMatriz3 {
	static private final int numeros[][][] = {{{1,2,3},{4,5,6},{7,8,9}},
		{{10,11,12},{13,14,15},{16,17,18}},
		{{19,20,21},{22,23,24},{25,26,27}}};
	static public void main(String args[]) {
		for (int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				for (int k=0;k<3;k++ ) {
					System.out.print(numeros[i][j][k]+" ");
				}
				System.out.print("\n");
			}
			System.out.print("\n\n\n");
		}
		for (int i[][]: numeros) {
			for (int j[]: i) {
				for (int k: j ) {
					System.out.print(k +" ");
				}
				System.out.print("\n");
			}
			System.out.print("\n\n\n");
		}
	}
}
