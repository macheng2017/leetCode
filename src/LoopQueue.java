
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;


    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
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

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];

        // 新数组的索引是从i = 0开始的,而旧数组中的索引是从i = front开始的,那么旧数组中的偏移量(就是每次i++的量) 为
        //
//        for (int i = front; i != tail; i = (i + 1) % data.length) {
////            int j = 0;
////            newData[j] = data[i];
////            j++;
////        }
        // 为什么上面的方式有问题？会多删掉一个元素
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        front = 0;
        tail = size;
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
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return result;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty");
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
        return data.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Stack: Front ");
        str.append("[");
        for (int i = 0; i < size; i++) {
            str.append(data[(i + front) % data.length]).append(',');
            // 为什么下面这个会按照数组中元素的实际位置进行排列？
//            str.append(data[i % data.length]).append(',');
        }
        // 为什么上面的那个循环中会将数组中没有元素的位置打印出null？ 因为使用了data.length （是capacity） 而不是size（是元素数量）
        // 如果使用data.length 实际上是将未使用的空间也打印了出来,所以会出现null
//        for (int i = front; i != tail; i = (i + 1) % data.length) {
//            str.append(data[i]).append(',');
//        }

        str.deleteCharAt(str.lastIndexOf(","));
        str.append(String.format("] tail size: %d capacity: %d", getSize(), getCapacity()));
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
