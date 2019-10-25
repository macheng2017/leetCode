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
            return e.toString();
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

    // 取出索引位置的链表中的元素
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException(" get failed. Illegal index ");
        }
        // 使用0这个边界代入验证了一下,发现索引0是dummyHead这个不对应该是下一个,所以改为dummyHead.next
        // 对这个虚拟链头理解还是不够,要经常温故才能知新
        Node<E> cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    // 获取链表第一个元素
    public E getFirst() {
        return get(0);
    }

    // 获取链表最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    // 修改链表中的index元素
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException(" set failed. Illegal index ");
        }
        Node<E> cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;

    }

    // 查找链表中是否存在元素e
    public boolean contains(E e) {
        Node<E> cur = dummyHead.next;
//        for (int i = 0; i < size - 1; i++) {
        while (cur.next != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node<E> cur = dummyHead.next;
        // 也可以使用下面这样的循环方式
//        for (Node<E> cur = dummyHead.next; cur != null; cur = cur.next)
        while (cur != null) {
            res.append(cur).append(" -> ");
            cur = cur.next;

        }
        res.append("NULL");
        return res.toString();
    }

    public E remove(int index) {
        // 需要先定义两个概念: cur 当前元素 ,prev 当前元素的上一个元素
        Node<E> cur = dummyHead.next;
        Node<E> prev = dummyHead;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
            prev = prev.next;
        }
        Node<E> delNode = cur;
        Node<E> temp = cur;
        prev.next = delNode.next;

        delNode = null;
        size--;
        return temp.e;
    }

    public static void main(String[] args) {
//        LinkedList<String> ll = new LinkedList<>();
//        ll.addFirst("1王二");
//        ll.addFirst("2哈哈");
//        ll.addFirst("3张三");
//        ll.addFirst("4哈哈");
//
//        System.out.println(ll.toString());
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList.toString());
        }
        linkedList.add(2, 100);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.remove(2));
        System.out.println(linkedList.toString());

    }
}
