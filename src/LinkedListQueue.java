public class LinkedListQueue<E> implements Queue<E> {

    class Node<E> {
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

    private Node<E> head, tail;
    private int size;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void enqueue(E e) {

        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next; // 这里的意思是 tail向后挪了一位,我没有理解这句话的根本原因是我没有理解java语言中的引用类型

//           代码 tail.next = new Node(e);
//            在当前链表的末尾后面又加了一个元素
//                    tail = tail.next;
//            上面的添加以后，tail已经不再指向最后一个元素了，所以要维护一下tail，让tail指向最后一个元素
        }
        size++;
    }

    @Override
    public E dequeue() {

        if (isEmpty()) {
            throw new IllegalArgumentException("Can not dequeue the empty queue");
        }

        Node<E> retNode = head;
        head = head.next;
        retNode.next = null;

        // 如果链表中只有一个元素,这个tail也是指向这个元素的
        if (head == null)
            tail = null;
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can not dequeue the empty queue");
        }

        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");
        Node cur = head;
        while (cur != null) {
            res.append(cur).append("->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> arr = new LinkedListQueue<>();
        for (int i = 0; i < 15; i++) {
            arr.enqueue(i);
            System.out.println(arr.toString());
            if (i % 3 == 2) {
                arr.dequeue();
                System.out.println(String.format("计数: %d 数组: %s", i, arr.toString()));
            }
        }
    }
}
