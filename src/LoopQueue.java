
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
      this(10);
    }


    @Override
    public void enqueue(E e) {
        // 使用取模这种方式可以让index循环起来,仔细想想其中的关键点
        // 先判断数组中是否满了 (tail + 1) % data.length == front
        if ((tail + 1) % data.length == front) {
            // add capacity
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        // 因为需要让index 循环起来所以使用了取模这种方式
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];

        // 新数组的索引是从i = 0开始的,而旧数组中的索引是从i = front开始的,那么旧数组中的偏移量(就是每次i++的量) 为
        //
        for (int i = front; i != (tail + 1) % newData.length; i = (i + 1) % data.length) {
            int j = 0;
            newData[j] = data[i];
            j++;
        }
        front = 0;
        tail = data.length;
        size = data.length;
        data = newData;
    }

    @Override
    public E dequeue() {
        // 与视频代码对比有以下不足:
        // 1. 数组为空的情况没有判断(数据校验)
        // 2. front++ 没有考虑到循环索引的情况
        // 3. dequeue 没有size--
        // 4. 没有动态缩容

        if (isEmpty()) {
            throw new IllegalArgumentException("dequeue is failed queue is empty");
        }
        E result = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        // 这里的capacity /2 !=0 怎么理解?
        if (size == capacity / 4 && capacity / 2 != 0) {
            resize(capacity / 2);
        }
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
        return data.length;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Stack: Front ");
        str.append("[");
        for (int i = 0; i < data.length; i++) {
            str.append(data[i % data.length]).append(',');
        }
        str.deleteCharAt(str.lastIndexOf(","));
        str.append(String.format("] tail size: %d capacity: %d",getSize(),getCapacity()));
        return str.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> arr = new LoopQueue<>();
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
