package a;

import java.lang.reflect.Field;

public class CreateTableSTMT {
	private  int CREATE;
	private  int TABLE;
	private  int IF;
	private  int EXISTS;
	private  int TEMPORARY;
	private  int INDEX;
	private  int KEY;
	private  int FULLTEXT;
	private  int SPATIAL;
	private  int CONSTRAINT;
	private  int PRIMARY;
	private  int UNIQUE;
	private  int FOREIGN;
	private  int NOT;
	private  int NULL;
	private  int VISIBLE;
	private  int INVISIBLE;
	private  int AUTO_INCREMENT;
	private  int COMMENT;
	private  int COLLATE;
	private  int COLUMN_FORMAT;
	private  int FIXED;
	private  int DYNAMIC;
	private  int DEFAULT;
	private  int ENGINE_ATTRIBUTE;
	private  int SECONDARY_ENGINE_ATTRIBUTE;
	private  int STORAGE;
	private  int DISK;
	private  int MEMORY;
	private  int GENERATED;
	private  int ALWAYS;
	private  int AS;
	private  int VIRTUAL;
	private  int STORED;
	private  int ASC;
	private  int DESC;
	private  int USING;
	private  int BTREE;
	private  int HASH;
	private  int KEY_BLOCK_SIZE;
	private  int WITH;
	private  int PARSER;
	private  int CHECK;
	private  int ENFORCED;
	private  int REFERENCES;
	private  int MATCH;
	private  int FULL;
	private  int PARTIAL;
	private  int SIMPLE;
	private  int ON;
	private  int DELETE;
	private  int UPDATE;
	private  int RESTRICT;
	private  int CASCADE;
	private  int SET;
	private  int NO;
	private  int ACTION;
	private  int AUTOEXTEND_SIZE;
	private IntTree root;
	private BTree<String> btree;
	public CreateTableSTMT() throws IllegalAccessException {
		btree=new BTree<String>().bTreeF(Keywords.KEYWORDS);
		Field[] a=this.getClass().getDeclaredFields();
		if (a.length==0) throw new RuntimeException();
		for (Field i:a) {
			if (i.getType().equals(IntTree.class)|| i.getType().equals(BTree.class)) continue;
			i.setInt(this, btree.search(i.getName()));
			System.out.print(i.getName()+" "+i.getInt(this)+"\n");
		}
		root=new IntTree();
		IntTree[] arr;
		IntTree[] arr1;
		IntTree cnode;
		root.val=CREATE;
		arr=new IntTree[2];
		arr[0]=new IntTree();
		arr[1]=new IntTree();
		arr[0].val=TABLE;
		arr[1].val=TEMPORARY;
		root.children=arr;
		arr1=new IntTree[1];
		arr1[0]=new IntTree();
		arr1[0]=arr[0];
		arr[1].children=arr1;
		cnode=arr[0];
		arr=new IntTree[2];
		arr1=new IntTree[1];
		arr1[0]=new IntTree();
		cnode.children=arr;
		arr[0]=new IntTree();
		arr[1]=new IntTree();
		arr[0].val=-1;
		arr[1].val=IF;
		arr1[0].val=NOT;
		cnode.children[1].children=arr1;
		arr1=new IntTree[1];
		arr1[0]=new IntTree();
		arr1[0].val=EXISTS;
		cnode.children[1].children[0].children=arr1;
		cnode.children[1].children[0].children[0].children=arr;
	}
	//Metodo temporaneo para comprabar la funcionalidad de parseamiento sintactico
	public boolean parse(String[] a) {
		int[] b= new int[a.length];
		for (int i=0;i<a.length;i++) {
			b[i]=btree.search(a[i]);
		}
		IntTree cNode=root;
		if (b[0]!=root.val) return false;
		int n=1;
		boolean breakable=false;
		for (;;) {
			if (cNode.children==null) break;
			breakable=false;
			for (IntTree i:cNode.children) {
				if (i.val==b[n]) {
					
					cNode=i;
					breakable=true;
					break;
				}
			}
			n++;
			if (breakable) continue;
			break;
		}
		return breakable;
	}
}
