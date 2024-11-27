package a;

import java.util.Arrays;

public class Main {
<<<<<<< HEAD
	static final int[][] startingArr= {{1,2,3},{4,5,6}};
	static Main.Tuple[] hash=new Tuple[720];
	public static void main(String[] args) throws InterruptedException {
		
	}
	static int hash(int a[][]) {
		int k=720;
		int r=0;
		for (int i[]:a) {
=======
	static final int[][] mults= {{6*6*6*36,6*6*36,6*36},{36,6,1}};
	static final int[][] startingArr= {{1,2,3},{4,5,0}};
	static  int[][] hash=new int[6][60];
	public static void main(String[] args) throws InterruptedException {
		int n=getAsInt(startingArr);
		//Thread.sleep(30000);
		//createTree(1,2,n,0);
		//runTTree(root, 0);
	/*	int i;
		int j =0;
		for (i=0;i<46656;i++ ) {
			if (hash[i]==null) continue;
			if (hash[i].a) {
				System.out.print("permutacion "+i+ " equivalente al puzzle "+ pToString(i)+" a la profundidad " +hash[i].b+"\n");
				j++;
			}
		}
		System.out.print("N total de permutaciones: "+j+"\n");
	}
	static String pToString(int a) {
		if (a==-1||a==0) return "Puzzle no asignable";
		int[][] b=unhash(a);
		StringBuilder c=new StringBuilder();
		for (int[] i:b) {
>>>>>>> 7872f2056c0aae170188b8ca7a136f1b837f8e6e
			for (int j:i) {
				k/=j+1;
				r+=k;
			}
		}
<<<<<<< HEAD
		return r;
	}
	static class Tuple {
		boolean a;
		int b;
		Tuple(int b){
			this.b=b;
=======
		return c.toString();
	}
	/*static void createTree(int x,int y,int n,int depth) {
		
			int buf;
			if (y<2) {
				buf=n;
				n/=mults[x][y+1];
				n%=6;
				n=buf-n*(mults[x][y+1])+(n*mults[x][y]);
				
				n=buf;
			} 
			if (y>0) {
				buf=n;
				n/=mults[x][y-1];
				n%=6;
				n=buf-n*(mults[x][y-1])+n*(mults[x][y]);
				createTree(x,y-1,n,depth+1);
				n=buf;
			}
			if (x==0) {
				buf=n;
				n/=mults[1][y];
				n%=6;
				n=buf+(n*mults[x][y])-n*(mults[1][y]);
				createTree(1,y,n,depth+1);
				n=buf;
			}
			if (x==1) {
				buf=n;
				n/=mults[0][y];
				n%=6;
				n=buf+(n*mults[x][y])-n*(mults[0][y]);
				createTree(0,y,n,depth+1);
				n=buf;
			}
		}
		return;
	}*/
	static int[][] unInt(int hash) {
		int[] a=new int[6];
		int[][] r=new int[2][3];
		int j=5;
		for (int i=7776;i>0;i/=6) {
			a[j--]=hash/i;
			hash%=i;
		}
		r[0][0]=a[5];
		r[0][1]=a[4];
		r[0][2]=a[3];
		r[1][0]=a[2];
		r[1][1]=a[1];
		r[1][2]=a[0];
		return r;
	}
	static int getAsInt(int[][] hasheable) {
			int r;
			int c=1;
			r=hasheable[1][2]*(c);
			r+=hasheable[1][1]*(c*=6);
			r+=hasheable[1][0]*(c*=6);
			r+=hasheable[0][2]*(c*=6);
			r+=hasheable[0][1]*(c*=6);
			r+=hasheable[0][0]*(c*=6);
			return r;
	}
	static void putHash(int[][] hasheable) {
		int r=hasheable[0][0];
		hash[r]
	}
	static class Tuple {
		boolean a;
		int b;
		Tuple (int n) {
			this.b=n;
>>>>>>> 7872f2056c0aae170188b8ca7a136f1b837f8e6e
			a=true;
		}
	}
	
}
 