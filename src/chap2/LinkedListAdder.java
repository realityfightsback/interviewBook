package chap2;

import chap2.MyLinkedList.Node;

public class LinkedListAdder {

	public static class ValueHolder {

		public ValueHolder(Node head) {
			node = head;
		}

		public int value;
		public boolean exhausted;
		public Node node;

	}

	public static void main(String[] args) {

		MyLinkedList one = new MyLinkedList(1, 1, 2);
		MyLinkedList two = new MyLinkedList(1, 1, 2);

		System.out.println(addLinkedLists(one, two));
	}

	public static MyLinkedList addLinkedLists(MyLinkedList one, MyLinkedList two) {
		// return addLinkedListsByLooping(one, two);
		return addLinkedListsByConversion(one, two);
	}

	public static MyLinkedList addLinkedListsByConversion(MyLinkedList one,
			MyLinkedList two) {
		int result = decode(one) + decode(two);
		return encode(result);
	}

	private static MyLinkedList encode(int toBeEncoded) {

		if (toBeEncoded < 0) {
			;
			// HUH how to handle?
		}
		MyLinkedList result = new MyLinkedList();
		while (toBeEncoded > 0) {
			result.addToEnd(toBeEncoded % 10);
			toBeEncoded = toBeEncoded / 10;
		}

		return result;
	}

	private static int decode(MyLinkedList one) {
		int result = 0;
		if (one == null || one.size == 0) {
			return result;
		}
		Node node = one.head;
		result += node.data;

		int power = 1;

		while (node.next != null) {
			node = node.next;
			result += node.data * Math.pow(10, power);
			power++;

		}
		return result;

	}

	public static MyLinkedList addLinkedListsByLooping(MyLinkedList one,
			MyLinkedList two) {
		MyLinkedList result = new MyLinkedList();
		if (one == null && two == null) {
			return result;
		}
		if (one == null || one.size == 0) {
			return two;
		}

		if (two == null || two.size == 0) {
			return one;
		}

		int carry = 0;

		ValueHolder llOneValues = new ValueHolder(one.head);
		ValueHolder llTwoValues = new ValueHolder(two.head);

		do {
			getValueAndAdvance(llOneValues);
			getValueAndAdvance(llTwoValues);

			int additionResult = llOneValues.value + llTwoValues.value + carry;
			carry = additionResult / 10;
			result.addToEnd(additionResult % 10);

		} while ((llOneValues.exhausted == false || llTwoValues.exhausted == false)
				|| carry == 1);

		return result;
	}

	private static void getValueAndAdvance(ValueHolder valueHolder) {

		if (valueHolder.exhausted) {
			valueHolder.value = 0;
		} else {
			valueHolder.value = valueHolder.node.data;
			if (valueHolder.node.next == null) {
				valueHolder.exhausted = true;
			} else {
				valueHolder.node = valueHolder.node.next;
			}
		}
	}
}
