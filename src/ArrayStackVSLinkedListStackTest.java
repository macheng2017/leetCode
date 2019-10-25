import java.util.Random;

public class ArrayStackVSLinkedListStackTest {

    public static double testStack(Stack<Integer> q, int count) {

        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            q.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < count; i++) {
            q.pop();
        }

        long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }

    public static void main(String[] args) {
        int testCount = 100000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        System.out.println(String.format("ArrayStack wast time %s", testStack(arrayStack, testCount)));
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        System.out.println(String.format("LinkedListStack wast time %s", testStack(linkedListStack, testCount)));
    }
}
