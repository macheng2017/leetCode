
public class LoopQueue<E> implements Queue<E> {
    private int capacity;
    private E[] data;
    private int front, tail;
    private int size;


    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        data = (E[]) new Object[10];
        front = 0;
        tail = 0;
        size = 0;
    }


    @Override
    public void enqueue(E e) {

        if (size < capacity) {
            data[size] = e;
            tail++;
        } else if (size == capacity) {
            // 转到头部,被删掉的元素空位
            int index = (tail + 1) % size;
            data[index] = e;
            tail = index + 1;
        }
        size++;


        if (tail + 1 == front) {
            // add capacity
        }
    }

    @Override
    public E dequeue() {
        E result = data[front];
        data[front] = null;
        front++;
        return result;
    }

    @Override
    public E getFront() {
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        // define
        return front == tail;
    }

    public int getCapacity() {
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Stack: ");
        str.append("[");
        for (int i = front; i < size; i++) {
            str.append(data[i]).append(',');
        }
        str.deleteCharAt(str.lastIndexOf(","));
        str.append("] top");
        return str.toString();
    }
}
