public class ArrayQueue<E> implements Queue<E> {
    Array<E> arr;

    public ArrayQueue() {
        this.arr = new Array<>();
    }

    public ArrayQueue(int capacity) {
        this.arr = new Array<>(capacity);
    }

    @Override
    public void enqueue(E e) {
        arr.addLastList(e);
    }

    @Override
    public E dequeue() {
        return arr.removeFirst();
    }

    @Override
    public E getFront() {
        return arr.getFirst();
    }

    @Override
    public int getSize() {
        return arr.getSize();
    }

    @Override
    public boolean isEmpty() {
        return arr.isEmpty();
    }

    public int getCapacity() {
        return arr.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("Queue front:"));
        str.append('[');
        for (int i = 0; i < arr.getSize(); i++) {
            str.append(arr.get(i));
            if (i != arr.getSize() - 1) {
                str.append(',');
            }
        }
//        str.deleteCharAt(str.lastIndexOf(","));
        str.append("] tail");
        return str.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arr = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            arr.enqueue(i);
            System.out.println(arr.toString());
            if (i % 3 == 2) {
                arr.dequeue();
                System.out.println(String.format("计数: %d 数组: %s", i, arr.toString()));
            }
        }
    }
}
