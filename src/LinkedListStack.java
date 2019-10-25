public class LinkedListStack<E> implements Stack<E> {
    LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E pick() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("stack: top ");
        // 这里稍微不明白,list 应该是一个 LinkedList怎么能直接添加到 StringBuilder中呢?
        res.append(list);
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> arr = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            arr.push(i);
            System.out.println(arr.toString());
        }
        arr.pop();
        System.out.println(arr.toString());
    }
}
