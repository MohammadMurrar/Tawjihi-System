package application;

import java.util.Iterator;

/* Linked List class that contains all the method of this data structure 
 * for the project insert,delete...., with best time complexity */
public class LinkedList<E extends Comparable<E>> {

	// define the head of the LL
	private Node<E> head;

	// Method to insert new Student sorted by average to the list
	public void insertSorted(Student std) {// O(n)
		Node<E> node = new Node<E>(std); // create new node
		if (head == null) {// First case : the head is null so we add the node at head
			head = node;
		} else { /*
					 * Second and third case : insert the node between or at the end of nodes
					 * according the average, create two pointer to check the nodes
					 */
			Node<E> curr = head;
			Node<E> prev = null;
			while (curr != null && curr.getStudent().getAverage() > std.getAverage()) {
				/*
				 * loop that make the current check the nodes and put the node it in the right
				 * place
				 */
				prev = curr;
				curr = curr.getNext();
			}
			if (prev == null) {
				node.setNext(head);
				head = node;
			} else {
				node.setNext(curr);
				prev.setNext(node);
			}
		}

	}

	// Method to delete Students from the Linked list
	public void delete(int seatNumber) {// O(n)
		if (head == null) {// First case : the head is null so there's no list
			System.out.println("It's an Empty LinkedList");
			return; // Return early since there's nothing to delete
		}

		if (head.getStudent().getSeatNumber() == seatNumber) {
			// Second case: Deleting the head node
			head = head.getNext();
			return;
		}
		Node<E> curr = head;
		Node<E> prev = null;
		while (curr != null && curr.getStudent().getSeatNumber() != seatNumber) {
			/*
			 * Third and last cases : create two pointer as we do in insert method, almost
			 * for the same purpose with an additional condition to stop the current with
			 * out checks all the nodes
			 */
			prev = curr;
			curr = curr.getNext();
		}

		if (curr == null) {
			System.out.println("Node with seat number " + seatNumber + " not found.");
			return; // Return if the node to delete wasn't found
		}

		/*
		 * last Case: Deleting a node that's not the head, when the current and previous
		 * pointers stop in the right places the will delete
		 */
		prev.setNext(curr.getNext());
	}

	public Node<Student> search(int seatNumber) {
		if (head == null) {
			return null;
		}
		Node<E> curr = head;
		while (curr != null) {
			if (curr.getStudent().getSeatNumber() == seatNumber)
				return (Node<Student>) curr;
			curr = curr.getNext();
		}
		return null;
	}

	public String top10() {
		String str = "";
		Node<E> curr = head;
		Node<E> prev = null;
		int j = 0;
		while (curr != null && curr.getNext() != null && j <= 9) {
			str += curr.toString();
			prev = curr;
			curr = curr.getNext();
			if (prev.getStudent().getAverage() == curr.getStudent().getAverage()) {
				str += curr.toString();
				prev = curr;
				curr = curr.getNext();
			}
			j++;
		}
		return "\n" + str;
	}

	public double mean() { // Method to calculate the mean with basic operations
		int count = 0;
		double sum = 0;
		Node<E> curr = head;
		while (curr != null) {
			sum += curr.getStudent().getAverage();
			count++;
			curr = curr.getNext();
		}
		double avg = sum / count;
		return avg;
	}

	public double mode() {
		double mode = 0, current = 0;
		int maxCount = 0, count = 0;
		Node<E> curr = head;
		while (curr != null) {
			if (curr.getStudent().getAverage() == current) {
				count++;
			} else {
				count = 1;
				current = curr.getStudent().getAverage();
			}
			if (count > maxCount) {
				maxCount = count;
				mode = current;
			}
			curr = curr.getNext();
		}
		return mode;
	}

	public String numberAndPercentage(double sGrade) {/*
														 * Method to calculate number and percentage of students, whom
														 * grade above or equal a specific grade
														 */
		int i = 0; // For students whom above above or equal a specific grade
		double count = 0; // For all students in the list to calculate the %
		Node<E> curr = head;
		while (curr != null) {
			if (curr.getStudent().getAverage() >= sGrade) {
				i++;
			}
			count++;
			curr = curr.getNext();
		}
		// String.format("%.2f",SgazaList.mean())+"%");
		double percentage = (i / count);
		return "The Number of Scientific Student " + i + " and the Percentage is " + String.format("%.2f", percentage)
				+ "%\n\n";
	}

	public String scientificPrint() {
		String s = "";
		Node<E> curr = head;
		while (curr != null) {
			if (curr.getStudent().getBranch().equals("Scientific")) {
				s += curr.toString();
			}
			curr = curr.getNext();
		}
		return s + " ";

	}

	public String LiteraryPrint() {
		String s = "";
		Node<E> curr = head;
		while (curr != null) {
			if (curr.getStudent().getBranch().equals("Literary")) {
				s += curr.toString();
			}
			curr = curr.getNext();
		}
		return s + " ";

	}

	@Override
	public String toString() {
		String s = "";
		Node<E> curr = head;
		while (curr != null) {
			s += curr.toString();
			curr = curr.getNext();
		}
		return s + " ";
	}

}
