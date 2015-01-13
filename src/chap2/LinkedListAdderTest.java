package chap2;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListAdderTest {

	@Test
	public void testDoubleNull() {
		assertEquals(new MyLinkedList(),
				LinkedListAdder.addLinkedLists(null, null));

	}
	
	@Test
	public void testOneNull() {
		assertEquals(new MyLinkedList(2,3),
				LinkedListAdder.addLinkedLists(null, new MyLinkedList(2,3)));

	}

	@Test
	public void testOneEmpty() {
		assertEquals(new MyLinkedList(2,3),
				LinkedListAdder.addLinkedLists(new MyLinkedList(), new MyLinkedList(2,3)));

	}
	
	@Test
	public void simpleAdditionSingleDigit() {
		assertEquals(new MyLinkedList(3),
				LinkedListAdder.addLinkedLists(new MyLinkedList(1), new MyLinkedList(2)));

	}
	
	@Test
	public void simpleAdditionMultipleDigits() {
		assertEquals(new MyLinkedList(7,6),
				LinkedListAdder.addLinkedLists(new MyLinkedList(1,5), new MyLinkedList(6,1)));

	}
	
	@Test
	public void additionWithACarry() {
		assertEquals(new MyLinkedList(5,1),
				LinkedListAdder.addLinkedLists(new MyLinkedList(9), new MyLinkedList(6)));

	}
	
	@Test
	public void additionMultipleDigitsWithCarries() {
		assertEquals(new MyLinkedList(8,1,0,1),
				LinkedListAdder.addLinkedLists(new MyLinkedList(9,9), new MyLinkedList(9,1,9)));

	}
	
	@Test
	public void veryDifferentListSizes() {
		assertEquals(new MyLinkedList(9,1,9,3,4,5,6),
				LinkedListAdder.addLinkedLists(new MyLinkedList(9), new MyLinkedList(0,1,9,3,4,5,6)));

	}
}
