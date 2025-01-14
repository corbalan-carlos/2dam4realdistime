package a;

import java.util.LinkedList;
import java.util.List;

public class BTree<T  extends Comparable<T>> {
	private BTreeNode top;
	public int search(T comp) {
		BTreeNode currentNode=top;
		int compR=currentNode.val.compareTo(comp);
		while(true) {
			if (currentNode==null) return -1;
			compR=comp.compareTo(currentNode.val);
			if  (compR>0) {
				currentNode=currentNode.right;
			} else if (compR<0) {
				currentNode=currentNode.left;
			} else {
				return currentNode.map;
			}
		}
	}
	private class BTreeNode {
		BTreeNode left;
		BTreeNode right;
		T val;
		final int map;
		public BTreeNode(int map) {
			this.map = map;
		}
	}
	public BTree<T> bTreeF(T arr[]) {
		LinkedList<BTreeNode> list=new LinkedList<BTreeNode>();
		LinkedList<T> list1=new LinkedList<T>();
		for (int i=0;i<arr.length;i++) {
			list1.add(arr[i]);
		}
		top=new BTreeNode(0);
		list.add(top);
		int n=1;
		for (int i=1;i<arr.length;i=i<<1) {
			for (int j=0;j<i;j+=2) {		
				BTreeNode node=new BTreeNode(n++);
				list.get((i>>1)+(j>>1)).left=node;
				list.add(node);
				if (i+j==arr.length-2) break;
				node=new BTreeNode(n++);
				list.get((i>>1)+(j>>1)).right=node;
				list.add(node);
			}
			
		}
		fillRecursively(list1,top);
		return this;
	}
	private void fillRecursively(List<T> list,BTreeNode node) {
		if (node.left==null&&node.right==null) {
			node.val=list.remove(0);
			return;
		} 
		if (node.right==null) {
			fillRecursively(list,node.left);
			node.val=list.remove(0);
		} else if (node.left==null){
			node.val=list.remove(0);
			fillRecursively(list,node.right);
		} else {
			fillRecursively(list,node.left);
			node.val=list.remove(0);
			fillRecursively(list,node.right);
		}
		
	}
}
