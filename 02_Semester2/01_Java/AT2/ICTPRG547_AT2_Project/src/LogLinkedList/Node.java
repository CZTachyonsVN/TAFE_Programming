package LogLinkedList;

public class Node // JavaFX also has a LinkedListNode class
{              // class for LinkedListNodes in a doubly-linked list
	Node prev;              // previous LinkedListNode in a doubly-linked list
	Node next;              // next LinkedListNode in a doubly-linked list
	String log;
	
	Node()
	{                // constructor for head LinkedListNode
		prev = this;           // of an empty doubly-linked list
		next = null;
	}
	
	Node(String newLog)
	{       // constructor for a LinkedListNode with data
		prev = null;
		next = null;
		log = newLog;
	}
	
	public void append(Node newNode)
	{  // attach newLinkedListNode after this LinkedListNode
		newNode.prev = this;
		newNode.next = null;
		next = newNode;
	}
	
	public void insert(Node node)
	{  // attach newLinkedListNode before this LinkedListNode
		node.prev = prev;
		node.next = this;
		prev.next = node;
		prev = node;
	}
	
	public void remove()
	{              // remove this LinkedListNode
		next.prev = prev;                 // bypass this LinkedListNode
		prev.next = next;
	}
}
