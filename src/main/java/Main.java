import java.util.Scanner;
public class Main {

	
	public static Node<Integer> returnList(int[] arr){
			
		if (arr.length == 0) 
			return null;
			
		Node<Integer> head = new Node(arr[0]);
		Node<Integer> current = head; 
		for(int i = 1 ; i < arr.length ; i++) {
			Node<Integer> nextNode = new Node(arr[i]);
			current.setNext(nextNode);
			current = nextNode;
		}
		return head;
	}
	
	
	public static void printList(Node<Integer> head) {
        	Node<Integer> current = head;
        	while (current != null) {
            	System.out.println(current.getValue());
            	current = current.getNext();
        	}
	}
	
	public static void recursivePrintList(Node<Integer> head) {
		if(head != null) {
			System.out.println(head.getValue());
			recursivePrintList(head.getNext());
		}
	}
	
	public static void recursivePrintListEnd(Node<Integer> head) {
	    if (head != null) {
	        recursivePrintListEnd(head.getNext());
	        System.out.println(head.getValue());
	    }
	}
	
	public static Node<Integer> inputList(){
		Node<Integer> list = new Node<Integer> (null); //חוליית דמה
		Node<Integer> p = list;
        	Scanner reader = new Scanner(System.in); // Initialize the Scanner
		System.out.println("Enter number or -1 to end:");
		int num = reader.nextInt();
		Node<Integer> x;
		while(num != -1) {
			x = new Node<Integer>(num);
			p.setNext(x);
			p = x;
			System.out.println("Enter number or -1 to end:");
			num = reader.nextInt();
		}
		return list.getNext();
	}
	
	
	public static void evenValues(Node<Integer> head) {
		Node<Integer> current = head;
		while(current != null) {
			if(current.getValue() % 2 == 0 ) {
				System.out.print(current.getValue() + ",");	
			}
			current = current.getNext();
		}	
	}
	
	
	public static boolean numInList(Node<Integer> head, int target) { 
		Node<Integer> current = head;
		while(current != null) {
			if(current.getValue() == target) {
				return true;
			}
			current = current.getNext();
		}
		return false;
	}
	
	
	public static boolean numInListTailRecursion(Node<Integer> head, int target) {
	    if(head == null) {
	    	return false;
	    }
	    if(head.getValue().equals(target)) {
	    	return true;
	    }
	    return numInListTailRecursion(head.getNext() , target);
	}
	
	public static Node<Integer> removeFirst( Node<Integer> head , int target){		
		if (head == null) {
	        	return null;
	    	}
		if (head.getValue() == target) {
	        	return head.getNext();  // מחזירים את הצומת הבאה אחרי הראש
	    	}
		Node<Integer> current = head;
		while (current.hasNext())  {
			if(current.getNext().getValue().equals(target)) {
				current.setNext(current.getNext().getNext()); // דילוג על הצומת עם המספר המבוקש
				return head;
			}
			current = current.getNext();
		}		
		return head;
	}
	public static Node<Integer> removeFirst2( Node<Integer> p , int target){		
		Node<Integer> dummy = new Node<Integer>(-1, p);
		Node<Integer> current = dummy;
		while (current.hasNext())  {
			if(current.getNext().getValue().equals(target)) {
				current.setNext(current.getNext().getNext()); // דילוג על הצומת עם המספר המבוקש
				return dummy.getNext();
			}
			current = current.getNext();
		}		
		return dummy.getNext();
	}

	public static Node<Integer> removeIndexNode(Node<Integer> head , int index){
		if (head == null) {
	        return null;
	    }
		
		if(index == 0) {
			return head.getNext();
		}
		
		Node<Integer> current = head;
	
		for(int i = 0; i< index-1 ; i++) {
			if(current == null || current.getNext() == null) {
				return head;
			}
			current = current.getNext();
		}
		
		if (current.getNext() != null) {
			current.setNext(current.getNext().getNext());
		}
		
		return head;
	}

	public static boolean allValuesInTwoListsTailRec(Node<Integer> L1, Node<Integer> L2) {
		
		if(L1 == null) {
			return true;
		}
		
		if(numInList(L2,L1.getValue()) == false) {
			return false;
		}
		
		return allValuesInTwoListsTailRec(L1.getNext(), L2);
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		//ex1
		int[] array = {2,5,7};
		System.out.println(returnList(array)); 
		
		
		/*
		Node<Integer> node1 = new Node<>(7);
		Node<Integer> node2 = new Node<>(3);
		Node<Integer> node3 = new Node<>(5);
		Node<Integer> node4 = new Node<>(12);
		
		
		node1.setNext(node2);
		node1.getNext();
		node2.setNext(node3);
		node3.setNext(node4);
		
		System.out.println(node1);
		*/
		
		//ex2
		System.out.println(" ");
		//creates a new list
		Node<Integer> head = new Node<>(1);
        	head.setNext(new Node<>(2));
        	head.getNext().setNext(new Node<>(3));
       	 	head.getNext().getNext().setNext(new Node<>(4));
        	head.getNext().getNext().getNext().setNext(new Node<>(5));
        	printList(head);
        
        	//ex2 -recursive
		System.out.println(" ");
        	recursivePrintList(head);
        
        	//ex2 - minus recursion
		System.out.println(" recursive 2 ");
       	 	recursivePrintListEnd(head);
        
        	//ex3
        	//System.out.println(inputList());
        
        	//ex4
		System.out.print("exe 4: ");
        	evenValues(head);
        	System.out.println(" ");
        
        	//ex5
		System.out.print("exe 5: ");
		System.out.println(numInList(head,4));
         
       
		System.out.print("exe 5 - tail recursion: ");
		System.out.println(numInListTailRecursion(head,4));
        
		
		//ex6
		System.out.print("exe 6: ");
		System.out.print(removeFirst(head,3));
        	System.out.println(" ");

        
		// ex7 
		System.out.print("exe 7: ");
		System.out.print(removeIndexNode(head,4));
        	System.out.println(" ");

		// ex8 
		System.out.print("exe 8: ");
		
		Node<Integer> node5 = new Node<>(5);
		Node<Integer> node4 = new Node<>(4, node5);
		Node<Integer> node3 = new Node<>(3, node4);
		Node<Integer> node2 = new Node<>(2, node3);
		Node<Integer> node1 = new Node<>(1, node2);  // L1
		
		
		Node<Integer> nodeA = new Node<>(1);
	    	Node<Integer> nodeB = new Node<>(2, nodeA);
	    	Node<Integer> nodeC = new Node<>(3, nodeB);
	    	Node<Integer> nodeD = new Node<>(4, nodeC);
	    	Node<Integer> nodeE = new Node<>(5, nodeD);  // L2
	    
		System.out.print(allValuesInTwoListsTailRec(node1,nodeE));
				
		

        
	}

}
