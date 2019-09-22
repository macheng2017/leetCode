public class Array {
    private  int [] data;
    private  int size;
    public Array(int capacity){
        data = new int[capacity];
        size = 0;
    }
    // 默认构造函数
    public Array (){
        this(10);
    }

    // 获取数组中的元素个数
    public int getSize(){
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
    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        int arr [] =  new int []{100, 20, 10};
        System.out.println(arr);
    }
}
