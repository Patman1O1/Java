import java.util.AbstractList;

public class SinglyList<E> extends AbstractList<E> {
    /* ---------------------------------------------------Node------------------------------------------------------- */
    protected static class _Node<E> {
        /* ----------------------------------------------Fields------------------------------------------------------ */
        protected E _value;

        protected _Node<E> _next;

        /* -------------------------------------------Constructors--------------------------------------------------- */
        protected _Node() { this._next = null; }

        protected _Node(E value) { this._value = value; this._next = null; }

        protected _Node(E value, _Node<E> next) { this._value = value; this._next = next; }

    }

    /* --------------------------------------------------Fields------------------------------------------------------ */
    private _Node<E> _head;

    private int _size;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public SinglyList() { this._head = null; this._size = 0; }
    
    /* -------------------------------------------------Setters------------------------------------------------------ */
    @Override
    public E set(int index, E value) {
        if (index >= this._size) {
            throw new IndexOutOfBoundsException("\"index\" out of bounds");
        }

        _Node<E> node = this._head;
        for (int i = 0; i < index && node != null; i++) {
            node = node._next;
        }

        if (node == null) {
            throw new NullPointerException("cannot dereference null");
        }

        E oldValue = node._value;
        node._value = value;
        return oldValue;
    }

    /* -------------------------------------------------Getters------------------------------------------------------ */
    @Override
    public E get(int index) {
        if (index >= this._size) {
            throw new IndexOutOfBoundsException("\"index\" out of bounds");
        }

        _Node<E> node = this._head;
        for (int i = 0; i < index && node != null; i++) {
            node = node._next;
        }

        if (node == null) {
            throw new NullPointerException("cannot dereference null");
        }

        return node._value;
    }



    /* -------------------------------------------------Methods------------------------------------------------------ */
    @Override
    public int size() { return this._size; }

}
