public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack<Integer> arr = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            arr.push(i);
            System.out.println(arr.toString());
        }
        arr.pop();
        System.out.println(arr.toString());
    }
}
