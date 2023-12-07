package filess;

import java.util.NoSuchElementException;

public class MyQueue<E> {
    private MyDoublyLinkedList<E> queue;

    public MyQueue() {
        queue = new MyDoublyLinkedList<>();
    }

    public boolean enqueue(E element) {
        return queue.add(element);
    }

    public E dequeue() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.removeFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void clear() {
        queue.clear();
    }


    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof MyQueue<?>)) {
            return false;
        }
        MyQueue<E> other = (MyQueue<E>) object;

        return this.queue.equals(other.queue);
    }

    public int getSize() {
        return this.queue.getSize();

    }
}

