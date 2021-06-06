import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node{
	int data;
	Node left, right;
	public Node(int data) {
		this.data = data;
	}
}

class Tree{
	static Node root;
	
	static void insert(Node node, int data) {		
		if(node == null) {
			root = new Node(data);
		}
		else {
			if(data > node.data) {
				if(node.right != null) insert(node.right, data);
				else node.right = new Node(data);
			}
			else {
				if(node.left != null) insert(node.left, data);
				else node.left = new Node(data);
			}
		}
	}
	
	static void postOrder(Node node) {
		if(node.left != null) postOrder(node.left);
		if(node.right != null) postOrder(node.right);
		System.out.println(node.data);
	}
}

public class 이진_검색_트리 {	
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		Tree tr = new Tree();
		while (true) {
			String num = br.readLine();
			if(num == null || num.isEmpty()) break;
			int data = Integer.parseInt(num);
			tr.insert(tr.root, data);
        }
		tr.postOrder(tr.root);	
	}
}