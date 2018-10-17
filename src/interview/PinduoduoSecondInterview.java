package interview;

public class PinduoduoSecondInterview<E> {

    private Node<E> head;
    private int size;

    public PinduoduoSecondInterview() {
        this.size = 0;
    }

    public int insert(int pos, E val) {
        if (pos > this.size)
            return -1;
        Node<E> toInsert = new Node(val);
        Node before = null;
        for (int i = 0; i < pos; i++) {
            before = before == null ? head : before.next;
        }
        if (before == null) {
            toInsert.next = head;
            head = toInsert;
        } else {
            toInsert.next = before.next;
            before.next = toInsert;
        }
        this.size++;
        return pos;
    }

    public E remove(int pos) {
        if (pos >= this.size)
            return null;
        Node<E> toRemove = head;
        Node<E> pre = null;
        while (pos-- > 0) {
            toRemove = toRemove.next;
            pre = pre == null ? head : pre.next;
        }
        if (toRemove == head) {
            head = head.next;
        }
        pre.next = toRemove.next;
        this.size--;
        return toRemove.val;
    }

    public int size() {
        return this.size;
    }

    class Node<T> {
        public Node(T e) {
            this.val = e;
            this.next = null;
        }

        public T val;
        public Node<T> next;
    }
}
