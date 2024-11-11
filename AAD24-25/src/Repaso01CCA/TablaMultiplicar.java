package Repaso01CCA;

import java.io.IOException;
import java.util.Stack;

public class TablaMultiplicar {
	public static void main(String args[]) throws IOException {
		Stack<Integer> stack=new Stack<Integer>();
		int a=0;
		int buffer=0;
		while (a<1 || a> 30000) {
		a=0;
		/*
		 * solo funciona en windows por lo del CR antes de meter el newline, para que funcione
		 * en linux supongo que habria que cambiar el 13 por un 10
		 */
		while (stack.push(System.in.read())!=13);
			stack.pop();
			for (int i=0;!stack.empty();i++) {
				buffer=stack.pop()-48;
				a+=buffer*Math.pow(10, i);
			}
			stack.clear();
			
		}
		for (int i=0;i<=10;i++) {
			System.out.println(i*a);
		}
	}
}
