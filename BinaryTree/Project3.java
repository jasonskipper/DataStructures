//Michael Skipper, N01162792, COP 3530  
import java.util.Scanner; 
public class Project3 extends Tree {
	public static void main(String[] args) { 
		//creating nodes and setting data inside nodes: 
		Node N55 = new Node();
		N55.setData(55);
		Node N60 = new Node();
		N60.setData(60);
		Node N20 = new Node();
		N20.setData(20);
		Node N85 = new Node();
		N85.setData(85);
		Node N70 = new Node();
		N70.setData(70);
		Node N10 = new Node();
		N10.setData(10);
		Node N30 = new Node();
		N30.setData(30);
		Node N15 = new Node();
		N15.setData(15);
		Node N75 = new Node();
		N75.setData(75);
		Node N50 = new Node();
		N50.setData(50);
		Node N65 = new Node();
		N65.setData(65);
		Node N25 = new Node();
		N25.setData(25);
		Node N80 = new Node();
		N80.setData(80);
		Node N35 = new Node();
		N35.setData(35);
		Node N5 = new Node();
		N5.setData(5);
		//connecting nodes in tree: 
		N55.setLeft(N60);
		N55.setRight(N20);
		N60.setLeft(N85);
		N60.setRight(N70);
		N85.setLeft(N15);
		N85.setRight(N75);
		N70.setLeft(N50);
		N70.setRight(N65);
		N20.setLeft(N10);
		N20.setRight(N30);
		N10.setLeft(N25);
		N10.setRight(N80);
		N30.setLeft(N35);
		N30.setRight(N5);
		//creating a tree and setting the root of the tree (the root is already connected to all of the other nodes) 
		Tree T1 = new Tree();
		T1.setRoot(N55);
		//output trace: 
		//size(): 
		System.out.println("Checking function size()");
		System.out.println("------------------------");
		System.out.println("The size of binary tree T1 is: " + T1.count());
		System.out.println();
		//height():
		System.out.println("Checking function height()");
		System.out.println("------------------------");
		System.out.println("The height of binary tree T1 is: " + T1.height());
		System.out.println();
		//leaves():
		System.out.println("Checking function leaves()");
		System.out.println("------------------------");
		System.out.println("The leaves of the binary tree T1 are: ");
		T1.leaves();
		System.out.println();
		System.out.println();
		//internal():
		System.out.println("Checking function internal()");
		System.out.println("------------------------");
		System.out.println("The internal nodes of the binary tree T1 are: ");
		T1.internal();
		System.out.println();
		System.out.println();
		//in-order, pre-order, and post-order traversals: 
		System.out.println("Checking functions printLDR(), printDLR(), and printLRD()"); 
		System.out.println("----------------------------------------------------------");
		System.out.println("Enter 1 (in-order traversal of T1),");
		System.out.println("      2 (pre-order traversal of T1), or");
		System.out.print("      3 (post-order traversal of T1):");
		Scanner scan = new Scanner(System.in); 
		int something = scan.nextInt();
		switch(something) {
			case 1:
				System.out.println("The nodes of the binary tree T1 in in-order traversal are:");
				T1.printLDR();
				System.out.println();
				break;
			case 2: 
				System.out.println("The nodes of the binary tree T1 in pre-order traversal are:");
				T1.printDLR();
				System.out.println();
				break;
			case 3: 
				System.out.println("The nodes of the binary tree T1 in post-order traversal are:");
				T1.printLRD();
				break;
		}
		System.out.println();	
		System.out.println();
		//search():
		System.out.println("Checking function search()");
		System.out.println("--------------------------");
		System.out.print("Enter element to search: ");
		something = scan.nextInt();
		if(T1.search(something)) {
			System.out.println(something + " belongs in the binary tree T1");
		}
		else {
			System.out.println(something + " does not belong in the binary tree T1");
		}
		System.out.println();
		//path():
		System.out.println("Checking function path()");
		System.out.println("------------------------");
		System.out.print("Enter element to find path for: ");
		something = scan.nextInt();
		System.out.println("The path from the root of T1 to node " + something + " is: ");	
		T1.path(something);			
		System.out.println();
		System.out.println();
		//descendents(): ==> shows the descendants, the descendent nodes
		System.out.println("Checking function descendents()");
		System.out.println("------------------------");
		System.out.print("Enter element to find descendents for: ");
		something = scan.nextInt();
		System.out.println("The descendents of " + something + " in T1 are: ");
		T1.descendents(something);
		scan.close();
		System.out.println();
		//copy(): 
		System.out.println("Checking function copy()");
		System.out.println("------------------------");
		Tree T2 = new Tree();
		T2 = T1.copy();
		System.out.println("Let T2 be a copy of T1");
		System.out.println("The nodes of binary tree T2 in in-order traversal are: ");
		T2.printLDR();
		System.out.println();
		System.out.println();
		//equal():
		System.out.println("Checking function equal()");
		System.out.println("------------------------");
		System.out.println("Let data part of node 80 be 90 in binary tree T1");
		N80.setData(90);
		if(T2.equal(T1))
			System.out.println("Binary Trees T1 and T2 are not equal");
		else 
			System.out.println("Binary Trees T1 and T2 are equal");
		
		System.out.println("let data part of node 80 be 80 in binary tree T1");
		N80.setData(80);
		if(T2.equal(T1))
			System.out.println("Binary Trees T1 and T2 are equal");
		else  
			System.out.println("Binary Trees T1 and T2 are not equal");
	}
}