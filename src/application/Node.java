package application;

/* Node class that contains students as an object and Node object 
 * name next for the linked List */
public class Node<E extends Comparable<E>> {
	
	//Class objects
	private Student student;
	private Node<E> next;

	//Node Class constructor
	public Node(Student student) {
		super();
		this.student = student;
	}

	// Node class getters and setters
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return student.toString();
	}

}
