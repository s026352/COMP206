package filess;

public interface MyList<E> extends Iterable<E>{
    int getSize();
    boolean isEmpty();
    boolean add(E element);
    void clear();
    E remove();
}
