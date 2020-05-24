//Michael Skipper 
//N01162792 
public class List { 
	
	private int size; 
	private ListNode head; 
	private ListNode tail; 
	
	//nested ListNode class: 
	private static class ListNode {
		private String head; 
		private ListNode next; 
		public ListNode() {} 
		public ListNode(String name) {
			this.head = name; 
		}
		public ListNode(String name, ListNode next) {
			this.head = name; 
			this.next = next;
		}
		
		public void setHead(String head) {
			this.head = head; 
		} 
		public String getHead() {
			return this.head; 
		}
		public ListNode getNext() {
			return this.next;
		} 
		public void setNext(ListNode next) {
			this.next = next; 
		} 
	}
	// end of nested ListNode class 
	
	public List() {} 
	
	public void insertItem(String name) {
		if(head == null) {
			ListNode Item = new ListNode(name);
			this.head = Item; 
			this.tail = Item; 
			} 
		else {
			ListNode Item = new ListNode(name);
			tail.next = Item;
			tail = Item;
		}
		this.size++;
	}
	
	public void insertItem(String name, int pos) {
		
		int index = 0; 
		
		if (size == 0 && pos == 0) {
			insertItem(name);
			//throw new IllegalArgumentException();
		}
		else if(pos < 0 || pos >= size) {
			throw new IllegalArgumentException(); 
		} 
		else {
			if (pos == 0) {
				ListNode newNode = new ListNode(name, head);
				this.head = newNode;
			}
			else { 
				ListNode node = head;
				while(index +1 != pos) {
					node = node.next;
					index++;
				} 
				ListNode after = node.next;
				node.next = new ListNode(name, after);
			} 
			size++;
		} 
	} 
	
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	} 
	
	public int size() {
		return this.size;
	} 
	
	public String get(int index) { 
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException();
		}
		ListNode current = head;
		for(int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.getHead();
	}
	
	@Override
	public String toString() {
		String temp = "";
		int index = -1; 
		if (size == 0) return null;
		else if (size == 1) return temp + get(0);
		else {
			ListNode yaa = head;
			while(yaa.next != null) {
				++index; 
				temp = temp + get(index); 
				yaa = yaa.next;
			} 
		}
		return temp;
	} 
	
	public String toHTMLString() {
		String tempp = "<html>PlayList<br/>";
		int index = -1;
		if (size == 0) return null;
		else if (size == 1) return tempp + get(0) + "</html>";
		else {
			ListNode yes = head;
			while(yes.next != null) {
				++index;
				tempp = tempp + get(index) + "<br/>";
				yes = yes.next;
				
			}
		}
		return tempp + "</html>";
	}    
	
	public boolean contains(String name) {
		boolean found = false;
		ListNode tremp = head;
        for(int i=0;i < size;i++) {
            if(tremp.getHead().equals(name)) {
                found = true;
            }
            tremp = tremp.next;
        }
        return found;
    }  
	
	public void removeItem(int position) {
		if (head == null || position < 0 || position >= size) {
			throw new IllegalArgumentException();
		}
		else if (position == 0) {
			head = head.next;
			size--;
		}
		else if (position == (size -1)) {
			ListNode ccurrent = head;
			for (int i = 0; i < position - 1; i++) {
				ccurrent = ccurrent.next;
			}
			ccurrent.next = null;
			tail = ccurrent;
			size--;
		}
		else {
			ListNode current = head;
			for (int i = 0; i < position; i++) {
				current = current.next;
			}
			current.next = current.next.next;
			size--;
		}
	}
	
	public boolean removeItem(String aname) {
		boolean removed = false; 
		ListNode thelistnode = head; 
		for (int i = 0; i < size; i++) {
			if (thelistnode.getHead().equals(aname)) {
				removeItem(i);
				removed = true;
			}
			thelistnode = thelistnode.next;
		}
		return removed; 
	} 
	
} 
