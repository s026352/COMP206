package filess;

import java.util.NoSuchElementException;

public class MyStack<E> {
    private MyDoublyLinkedList<E> stack;

    public MyStack(){
        this.stack = new MyDoublyLinkedList<E>();
    }
    public boolean push(E element){
        return this.stack.addLast(element);
    }
    public E pop(){
        if(this.stack.isEmpty()){
            throw new NoSuchElementException();
        }
        return this.stack.removeLast();
    }

    public E peek() {
        if (this.stack.isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.stack.peekLast();
    }

    public  boolean isEmpty(){
        return this.stack.isEmpty();
    }

    public void clear(){
        this.stack.clear();
    }
    public int getSize(){
        return this.stack.getSize();
    }

}
