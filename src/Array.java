
public class Array {
    private int[] data;
    private int size;

    public Array(int capacity) {
        data = new int[capacity];
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
    public void addFirst(int e) {
        add(0, e);
    }

    // 向数组最后添加新元素
    public void addLastList(int e) {
        add(size, e);
    }

    // 向index位置添加一个元素
    public void add(int index, int e) {
        if (data.length == size) {
            throw new IllegalArgumentException("Add value failed capacity was fulled");
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add value failed");
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
    int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, Index is illegal");
        }
        return data[index];
    }

    /**
     * 修改数组中索引位置的元素
     *
     * @param index
     * @param e
     */
    void set(int index, int e) {
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
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) return true;
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
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) return i;
        }
        return -1;
    }

    /**
     * 删除数组中指定的元素e
     *
     * @param e
     */
    public void removeElement(int e) {
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
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed, Index is illegal");
        }
        int ret = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return ret;
    }

    public int removeFirst() {
        return remove(0);
    }

    public int removeLatest() {
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

    public static void main(String[] args) {
        Array arr = new Array(20);
        for (int i = 0; i < 10; i++) {
            arr.addLastList(i);
        }
        System.out.println(arr);
        arr.add(2, 200);
        System.out.println(arr);
        arr.addFirst(-1);
        System.out.println(arr);
//        System.out.println(arr.get(-1));
        arr.remove(2);
        System.out.println(arr);
        arr.removeElement(200);
        System.out.println(arr);

    }
}
