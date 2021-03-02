//Michael Skipper, N01162792, COP 3530 
public class Tree {
	Node root;
	Tree() {
		root = null; 
	}
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node newRoot) {
		root = newRoot;
	}
	public boolean empty() {
		return count() == 0;
	}
	public int count() {
		return countNodes(root);
	}
	public int countNodes(Node N) {
		//base case: 
		if(N == null) return 0;
		//recursive calls: 
		else return 1 + countNodes(N.getLeft()) + countNodes(N.getRight());
	}
	public boolean equal(Tree T) {
		return equalNodes(root, T.root);
	}
	public boolean equalNodes(Node N, Node M) {
		//base cases: 
		if(N == null && M == null) return true;
		if(N == null && M != null) return false;
		if(N == null && M != null) return false;
		if(N.getData() != M.getData()) return false; 
		//recursive calls: 
		if(equalNodes(N.getLeft(), M.getLeft())) return true;
		if(equalNodes(N.getRight(), M.getRight())) return true;
		return false;
	}
	public boolean search(int element) { 
		return searchNodes(root, element);
	}
	public boolean searchNodes(Node N, int element) {
		//base case: 
		if(N == null) return false; 
		//recursive calls: 
		else {
			if(N.getData() == element) return true;
			if(searchNodes(N.getLeft(), element)) return true;
			if(searchNodes(N.getRight(), element)) return true;
			return false;
		}
	}
	public void printLDR() { // in-order 
		printLDRNodes(root);
	}
	public void printLDRNodes(Node N) {
		//base case: 
		if (N == null) return;
		//recursive calls: 
		printLDRNodes(N.getLeft());
		System.out.print(N.getData() + " ");
		printLDRNodes(N.getRight()); 
	} 
	public void printLRD() { // post-order 
		printLRDNodes(root);
	}
	public void printLRDNodes(Node N) {
		//base case: 
		if (N == null) return; 
		//recursive calls: 
		else {
			printLRDNodes(N.getLeft());
			printLRDNodes(N.getRight());
			System.out.print(N.getData() + " ");
		}
	}
	public void printDLR() { // pre-order 
		printDLRNodes(root);
	} 
	public void printDLRNodes(Node N) {
		//base case: 
		if(N == null) return;
		//recursive calls: 
		else {
			System.out.print(N.getData() + " ");
			printDLRNodes(N.getLeft());
			printDLRNodes(N.getRight());
		}
	} 
	public Tree copy() {
		Tree cpTree = new Tree();
		Node cpNode = copyNodes(root);
		cpTree.setRoot(cpNode);
		return cpTree;
	}
	public Node copyNodes(Node N) {
		//base case: 
		if(N == null) return N;
		//recursive calls: 
		Node cp = new Node();//creates a new node 
		cp.setData(N.getData());//copies data of node to new node 
		cp.setLeft(copyNodes(N.getLeft()));// copies data of left child node to left child of new node 
		cp.setRight(copyNodes(N.getRight()));// copies data of right child node to right child of new node 
		return cp;
	}
	public void leaves() {
		leavesNodes(root);
	} 
	public void leavesNodes(Node N) {
		//base case: 
		if (N == null) return;
		//recursive calls: 
		else {
			if(N.getLeft() == null && N.getRight() == null) 
				System.out.print(N.getData() + " ");
			leavesNodes(N.getLeft());
			leavesNodes(N.getRight());
		}
	} 
	public void internal() {
		internalNodes(root);
	} 
	public void internalNodes(Node N) {
		//base case: 
		if (N == null) return;
		//recursive calls: 
		else {
			if(N.getLeft() != null || N.getRight() != null) 
				if (N != root) System.out.print(N.getData() + " ");
			internalNodes(N.getLeft());
			internalNodes(N.getRight());
		}
	}
	public void path(int element) {
		pathNodes(element, root);
	} 
	public void pathNodes(int element, Node N) {
		// base case: 
		if(!searchNodes(N, element)) return;
		//recursive calls: 
		else {
			System.out.print(N.getData() + " ");
			if(N.getData() == element) return;
			pathNodes(element, N.getLeft());
			pathNodes(element, N.getRight());
		}
	}   
	public int height() {
		return heightNodes(root);
	} 
	public int heightNodes(Node N) {
		//base cases: 
		if (N == null) return 0;
		if(N.getLeft() == null && N.getRight() == null) return 0;
		//recursive calls: 
		if(heightNodes(N.getLeft()) > heightNodes(N.getRight()))  return 1 + heightNodes(N.getLeft());
		return 1 + heightNodes(N.getRight());
	} 
	public void descendents(int element) {
		descendentsNodes(root, element);
	} 
	public void descendentsNodes(Node N, int element) {
		if(searchNodes(N, element)) {
			//base case: 
			if(N.getData() == element) {
				printLDRNodes(N.getLeft());
				printLDRNodes(N.getRight());
				System.out.println();
				//in accordance with the desired output, I did not print the node itself as a descendant 
				//((a node v is a descendant of a node u if u is an ancestor of v) 
				//(a node u is an ancestor of a node v is u = v or if u is an ancestor of the parent of v)
			} 
			//recursive calls: 
			else {
				descendentsNodes(N.getLeft(), element);
				descendentsNodes(N.getRight(), element);
			}
		} 
	} 
} 