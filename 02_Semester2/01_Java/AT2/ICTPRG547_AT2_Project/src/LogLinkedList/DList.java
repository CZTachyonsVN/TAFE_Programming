package LogLinkedList;

import java.util.ArrayList;

public class DList
{
	
	Node head;
	Node tail;
	boolean isEmpty = true;
	int length = 0;
	
	public DList()
	{
		head = new Node();
		tail = null;
	}
	
	public DList(String newLog)
	{
		head = new Node(newLog);
		tail = null;
		isEmpty = false;
	}
	
	public Node Find(String targetLog)
	{          // find LinkedListNode containing x
		for (Node current = head.next; current != head; current = current.next)
		{
			if (current.log.compareToIgnoreCase(targetLog) == 0)
			{        // is x contained in current LinkedListNode?
				System.out.println("Data " + targetLog + " found");
				return current;               // return LinkedListNode containing x
			}
		}
		return null;
	}
	
	//This Get method Added by Matt C
	public Node Get(int i)
	{
		Node current = this.head;
		if (i < 0 || current == null)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		while (i > 0)
		{
			i--;
			current = current.next;
			if (current == null)
			{
				throw new ArrayIndexOutOfBoundsException();
			}
		}
		return current;
	}
	
	public String ToString()
	{
		String output = "";
		if (head.next == head)
		{             // list is empty, only header LinkedListNode
			return "List Empty";
		}
		output = "list content = ";
		for (Node current = head.next; current != head && current != null; current = current.next)
		{
			output += current.log;
		}
		return output;
	}
	
	public ArrayList<String> GetLogList()
	{                  // print content of list
		ArrayList<String> output = new ArrayList<>();
		Node current = head;
		if (head.next == head)
		{             // list is empty, only header LinkedListNode
			return new ArrayList<>();
		}
		do{
			output.add(current.log);
			current = current.next;
		}
		while (current.next != null);
		
		return output;
	}
	
	public void Add(String newLog){
		Node newNode = new Node(newLog);
		if(isEmpty){
			head.log = newNode.log;
			tail = head;
			isEmpty = false;
		}
		else{
			tail.append(newNode);
			tail = newNode;
		}
		length++;
	}
	
	public void Debug()
	{
		String output;
		Node i = head;
		int count = 0;
		while (i != null)
		{
			if (i.next != null)
			{
				System.out.println(i.hashCode() + ", pointer:" + i.next.hashCode());
				i = i.next;
			}
			else
			{
				System.out.println(i.hashCode() + " is tail");
				i = null;
			}
			count++;
		}
		System.out.println("LogList length = " + count + "," + length);
	}
}
