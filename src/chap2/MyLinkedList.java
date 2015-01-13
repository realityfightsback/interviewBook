package chap2;

public class MyLinkedList {

	public static void main(String[] args) {
		MyLinkedList ll = new MyLinkedList();
		ll.addToEnd(5, 3, 1, 3, 2, 1, 2, 5, 8);
		System.out.println(ll);
	}

	public MyLinkedList(int... d) {
		this.addToEnd(d);

	}

	public class Node {
		public Node(int d) {
			this.data = d;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}

		Node next;
		int data;
	}

	int size = 0;
	Node head;
	Node last;

	public void addToEnd(int... d) {
		for (int i : d) {
			addToEnd(i);
		}
	}

	public void addToEnd(int d) {
		size++;
		if (head == null) {
			head = new Node(d);
			last = head;
		} else {
			last.next = new Node(d);
			last = last.next;
		}
	}

	/**
	 * 
	 * @param d
	 *            - removes node with data matching d
	 * @return int - number of nodes removed
	 */
	public int remove(int d) {
		if (head == null) {
			return 0;
		}
		int initialSize = size;
		Node curr = head;
		// Lack a previous node to start (only have head at the beginning).
		Node prev = null;
		do {
			if (d == curr.data) {
				// We found data matching our criteria
				size--;
				if (curr == head) {
					// We have no previous node if this is the head, special
					// case

					// Do we have any other elements in the list?
					if (curr.next != null) {
						head = curr.next;
					} else {
						curr = null;
						last = null;
					}
				} else {
					// Standard non-head case. Cut out node.
					if (prev == null) {
						System.err
								.println("Something very wrong in the logic. Prev is not being set before being used");
					}
					prev.next = curr.next;
				}

				prev = curr;
				curr = curr.next; // Blindly do this, so include null check in
									// while condition
			}
		} while (curr != null && curr.next != null);

		return initialSize - size;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("MyLinkedList size=" + size);
		if (size > 0) {
			Node curr = head;
			sb.append("[");
			while (curr.next != null || curr == last) {
				sb.append(curr.data);
				if (curr.next != null) {
					sb.append(",");
					curr = curr.next;
				} else {
					break;
				}
			}

			sb.append("]");
		}
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + size;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyLinkedList other = (MyLinkedList) obj;
		if (size != other.size)
			return false;

		if (size > 0) {
			Node node = head;
			Node otherNode = other.head;

			if (node.data != otherNode.data) {
				return false;
			}
			while (node.next != null) {
				node = node.next;
				otherNode = otherNode.next;

				if (node.data != otherNode.data) {
					return false;
				}
			}
		}
		return true;
	}
}
