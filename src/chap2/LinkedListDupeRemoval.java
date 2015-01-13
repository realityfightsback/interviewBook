package chap2;

import java.util.Collections;
import java.util.LinkedList;

public class LinkedListDupeRemoval {

	public static void main(String[] args) {


		
		LinkedList<Integer> ll = new LinkedList<Integer>();

		ll.add(1);
		ll.add(-1);
		ll.add(1);
		ll.add(4);
		ll.add(3);
		System.out.println(ll);

		Collections.sort(ll);
		System.out.println(ll);

		for (int i = 0; i < ll.size(); i++) {

			int backPtrValue = ll.get(i);
			int backPtrIndex = i;

			// iterate through removing all dupes from the sorted list
			while (i + 1 != ll.size() && ll.get(++i) == backPtrValue) {
				ll.remove(i);
			}

			if (i + 1 == ll.size()) {
				break;
			}

		}
		System.out.println(ll);

	}

}
