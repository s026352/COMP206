package filess;

import java.util.Iterator;

public abstract class MyLinkedList<E> implements MyList<E> {
    protected int size;
    public MyLinkedList(){
        size=0;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int getSize() {
        return size;
    }

}
