package chap2;

import java.util.Stack;

import chap2.MyLinkedList.Node;

public class LinkedListUtils {

	public static void main(String[] args) {
		MyLinkedList ll = new MyLinkedList();
		ll.addToEnd(5, 3, 1, 3, 2, 1, 2, 5, 8);

		System.out.println(returnNthFromLast(ll, 4));
	}
/**
 * Used a stack. Space inefficient. Time of n though
 * @param ll
 * @param nth
 * @return
 */
	public static Node returnNthFromLast(MyLinkedList ll, int nth) {

		if (nth > ll.size - 1) {
			return null;
			// Bogus case. Cant return 5th from last if there are only say 3
			// elements.
		}

		Stack<Node> stack = new Stack<Node>();

		Node curr = ll.head;

		if (curr != null) {
			while (curr != ll.last) {
				stack.push(curr);
				curr = curr.next;
			}
		}
		// Makes the math easier
		stack.push(ll.last);

		for (int i = nth; i > 0; i--) {
			stack.pop();
		}

		return stack.peek();
	}
}
