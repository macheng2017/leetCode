public class LinkedList<E> {

    private class Node<E> {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        // 使用虚拟头结点,应该初始化一个元素为null的结点
        dummyHead = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    // 在链表头添加元素e
    public void addFirst(E e) {
        add(0, e);
    }
    // 在链表的index位置添加新的元素e
    // 在链表中不是一个常用的操作,练习用

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException(" Add failed. Illegal index ");
        }
        // dummyHead指向的是0这个索引位置的元素之前的那个元素
        Node prev = dummyHead;
        // 将prev移动到index 的位置,因为有了虚拟头结点index不需要-1,
        for (int i = 0; i < index; i++) {
            //  向前移动
            prev = prev.next;
        }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * 向链表的末尾添加元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

}
