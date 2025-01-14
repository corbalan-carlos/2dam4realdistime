package a;

public class Main {
	public static void main(String args[]) throws IllegalAccessException {
		String[]  arg = {"CREATE","TABLE","hola"};
		String[]  arg1 = {"CREATE","TEMPORARY","TABLE","hola"};
		String[]  arg2 = {"CREATE","TEMPORARY","TABLE","IF","NOT","EXISTS","hola"};
		String[]  arg3 = {"hola"};
		String[]  arg4 = {"CREATE", "hola"};
		CreateTableSTMT a=new CreateTableSTMT();
		System.out.print(a.parse(arg)+"\n");
		System.out.print(a.parse(arg1)+"\n");
		System.out.print(a.parse(arg2)+"\n");
		System.out.print(a.parse(arg3)+"\n");
		System.out.print(a.parse(arg4)+"\n");
	}
}
