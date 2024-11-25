package a;

import java.util.Arrays;

public class Main {
	static final int[][] startingArr= {{1,2,3},{4,5,0}};
	static Tree root;
	static Main.Tuple[] hash=new Tuple[46656];
	public static void main(String[] args) throws InterruptedException {
		int n=getHash(startingArr);
		//Thread.sleep(30000);
		root=new Main.Tree();
		root.a=n;
		root.branches=new Tree[4];
		root.branches[0]=new Tree();
		root.branches[1]=new Tree();
		root.branches[2]=new Tree();
		root.branches[3]=new Tree();
		createTree(1,2,startingArr,root,0);
		//runTTree(root, 0);
		int i;
		int j =0;
		for (i=0;i<46656;i++ ) {
			if (hash[i].a) {
				System.out.print("permutacion "+i+ " equivalente al puzzle "+ pToString(i)+"\n");
				j++;
			}
		}
		System.out.print("N total de permutaciones: "+j+"\n");
	}
	static void bRunTTree (Tree branch,int c) {
		
	}
	static void runTTree (Tree branch,int d) {
		if (branch==null) return;
		for (Tree a:branch.branches) {
			runTTree(a,d+1);
		}
		System.out.print(branch.a+" at depth "+d+" with puzzle "+pToString(branch.a)+"\n");
	}
	static String pToString(int a) {
		if (a==-1||a==0) return "Puzzle no asignable";
		int[][] b=unhash(a);
		StringBuilder c=new StringBuilder();
		for (int[] i:b) {
			for (int j:i) {
				c.append(j+".");
			}
			c.append("/");
		}
		return c.toString();
	}
	static int createTree(int x,int y,int[][] arr,Tree branch,int depth) {
		int n=getHash(arr);
		if (hash[n].a) {
			if (hash[n].b>depth) return n;
		} else {
			hash[n].a=true;
		}
		int[] a=new int[4];
		int buf;
		branch.a=n;
		branch.branches=new Tree[4];
		branch.branches[0]=new Tree();
		branch.branches[1]=new Tree();
		branch.branches[2]=new Tree();
		branch.branches[3]=new Tree();
		if (y<2) {
			buf=arr[x][y+1];
			arr[x][y+1]=0;
			arr[x][y]=buf;
			a[0]=createTree(x,y+1,arr,branch.branches[0],depth+1);
			arr[x][y+1]=buf;
			arr[x][y]=0;
		} 
		if (y>0) {
			buf=arr[x][y-1];
			arr[x][y-1]=0;
			arr[x][y]=buf;
			a[1]=createTree(x,y-1,arr,branch.branches[1],depth+1);
			arr[x][y-1]=buf;
			arr[x][y]=0;
		}
		if (x==0) {
			buf=arr[1][y];
			arr[1][y]=0;
			arr[0][y]=buf;
			a[2]=createTree(1,y,arr,branch.branches[2],depth+1);
			arr[0][y]=0;
			arr[1][y]=buf;
		}
		if (x==1) {
			buf=arr[0][y];
			arr[0][y]=0;
			arr[1][y]=buf;
			a[3]=createTree(0,y,arr,branch.branches[3],depth+1);
			arr[1][y]=0;
			arr[0][y]=buf;
		}
		branch.branches[0].a=a[0];
		branch.branches[1].a=a[1];
		branch.branches[2].a=a[2];
		branch.branches[3].a=a[3];
		return n;
	}
	static int[][] unhash(int hash) {
		int[] a=new int[6];
		int[][] r=new int[2][3];
		int j=0;
		int k=1;
		for (int i=7776;i>0;i/=6) {
			a[j++]=hash/i;
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
	static int getHash(int[][] hasheable) {
			int r;
			int c=1;
			r=hasheable[0][0]*(c);
			r+=hasheable[0][1]*(c*=6);
			r+=hasheable[0][2]*(c*=6);
			r+=hasheable[1][0]*(c*=6);
			r+=hasheable[1][1]*(c*=6);
			r+=hasheable[1][2]*(c*=6);
			return r;
	}
	static public class Tree {
		int a;
		Tree[] branches;
		public Tree() {
			branches=new Tree[4];
		}
	}
	static class Tuple {
		boolean a;
		int b;
	}
}
