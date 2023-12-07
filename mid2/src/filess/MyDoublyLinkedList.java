package filess;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyDoublyLinkedList<E> extends MyLinkedList<E> { 

	private DNode head;
	private DNode tail;
	
	
	/*
	 * ADD YOUR CODE HERE
	 */
	public boolean add(E element){
		DNode newNode = new DNode();
		newNode.element = element;
		if (this.isEmpty()){
			head = newNode;
			tail = head;
		}else {
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;

	 	}
		size++;
		return true;
	}

	public E remove(){
		if (isEmpty()){
			throw new NoSuchElementException();
		}
		E element = tail.element;
		if (size == 1){
			head = null;
			tail = null;
		}else{
			tail = tail.prev;
			tail.next = null;
		}
		size--;
		return element;
	}

	public boolean addFirst(E element){
		DNode newNode = new DNode();
		newNode.element = element;
		if (isEmpty()){
			head = newNode;
			tail = head;
		}else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		size++;
		return true;
	}

	public boolean addLast(E element){
		return add(element);
	}

	public E removeFirst(){
		if (isEmpty()){
			throw new NoSuchElementException();
		}
		E element = head.element;
		if (size == 1){
			head = null;
			tail = null;
		}else{
			head = head.next;
			head.prev = null;
		}
		size--;
		return element;
	}

	public E removeLast(){
		return remove();
	}

	public E peekFirst(){
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return head.element;
	}

	public E peekLast(){
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return tail.element;
	}

	public void clear(){
		head = null;
		tail = null;
		size = 0;
	}

	public boolean equals(Object object){
		if (object == this){
			return true;
		}
		if (!(object instanceof MyDoublyLinkedList)){
			return false;
		}
		MyDoublyLinkedList<E> other = (MyDoublyLinkedList<E>) object;
		if (this.size != other.size){
			return false;
		}
		Iterator<E> i1 = this.iterator();
		Iterator<E> i2 = other.iterator();
		while (i1.hasNext()){
			if(!i1.next().equals(i2.next())){
				return false;
			}
		}
		return true;
	}


	private class DNode {
		private E element;
		private DNode next;
		private DNode prev;

		/*public DNode(E element, DNode prev, DNode next){
			this.element = element;
			this.prev = prev;
			this.next = next;
		}*/
	}
	
	public Iterator<E> iterator() {
		return new DLLIterator();
	}
	
	private class DLLIterator implements Iterator<E> {
		DNode curr;

		public DLLIterator() {
			this.curr = head;
		}

		public boolean hasNext() {
			return this.curr != null;
		}

		public E next() {
			if (!this.hasNext())
				throw new NoSuchElementException();

			E element = this.curr.element;
			this.curr = this.curr.next;
			return element;
		}
	}
}
