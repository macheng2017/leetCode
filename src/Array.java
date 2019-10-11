import java.util.Objects;

// 修改为泛型类
public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity) {
        // java中不允许直接声明泛型类,可以采用间接转换的方式
        data = (E[]) new Object[capacity];
        size = 0;
    }

    // 默认构造函数
    public Array() {
        this(10);
    }

    // 获取数组中的元素个数
    public int getSize() {
        return size;
    }

    // 获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    /***
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    // 向数组最前面添加新元素
    public void addFirst(E e) {
        add(0, e);
    }

    // 向数组最后添加新元素
    public void addLastList(E e) {
        add(size, e);
    }

    // 向index位置添加一个元素
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add value failed");
        }

        if (data.length == size) {
            // 添加动态数组功能
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;

    }

    /***
     * 获取数组中index的元素
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, Index is illegal");
        }
        return data[index];
    }

    public E getLatest() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    /**
     * 修改数组中索引位置的元素
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed, Index is illegal");
        }
        data[index] = e;
    }

    /**
     * 数组中是否存在e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) return true;
        }
        return false;
    }

    /**
     * 查找数组中元素e所对应的索引
     * 如果不存在则返回-1
     *
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) return i;
        }
        return -1;
    }

    /**
     * 删除数组中指定的元素e
     *
     * @param e
     */
    public void removeElement(E e) {
        int index = this.find(e);
        if (index == -1) {
            throw new IllegalArgumentException(" Illegal argument");
        }
        remove(index);
    }

    /**
     * 删除数组中指定的元素索引
     * 并返回删除的元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed, Index is illegal");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        // 当使用容量小于总容量的1/2时,减少数组的总容量
        if (size == data.length / 2) {
            resize(data.length / 2);
        }
        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLatest() {
        return remove(size - 1);
    }

    /***
     * 打印数组中的元素
     * @return
     */
    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();
        str.append(String.format("Array: size = %d ,capacity = %d\n", size, data.length));
        str.append('[');
        for (int i = 0; i < size; i++) {
            str.append(data[i]).append(',');
        }
        str.deleteCharAt(str.lastIndexOf(","));
        str.append(']');
        return str.toString();
    }

    private void resize(int newCapacity) {
        // 创建一个新的数组容量是原来的2倍
        E[] newData = (E[]) new Object[newCapacity];
        // 复制旧数组中元素到新数组中
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        // 更新容量以及data的指向新数组
//        this.size = size;
        data = newData;
    }

//    public static void main(String[] args) {
//        Array<Integer> arr = new Array<>();
//        for (int i = 0; i < 10; i++) {
//            arr.addLastList(i);
//        }
//        System.out.println(arr);
//        arr.add(2, 200);
//        System.out.println(arr);
//        arr.addFirst(-1);
//        System.out.println(arr);
//        arr.removeLatest();
//        System.out.println(arr);
////        System.out.println(arr.get(-1));
//        arr.remove(2);
//        System.out.println(arr);
//        arr.addFirst(222);
//        System.out.println(arr);
//        arr.removeElement(200);
//        System.out.println(arr);
//        arr.removeLatest();
//        System.out.println(arr);
//        arr.removeLatest();
//        System.out.println(arr);
//        arr.addFirst(222);
//        System.out.println(arr);
//    }
}
