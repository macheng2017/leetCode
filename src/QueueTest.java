import java.util.Random;

public class QueueTest {

    public static double testQueue(Queue<Integer> q, int count) {

        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < count; i++) {
            q.dequeue();
        }

        long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }

    public static void main(String[] args) {
        int testCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        System.out.println(String.format("ArrayQueue wast time %s", testQueue(arrayQueue, testCount)));
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        System.out.println(String.format("LoopQueue wast time %s", testQueue(loopQueue, testCount)));
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        System.out.println(String.format("linkedListQueue wast time %s", testQueue(linkedListQueue, testCount)));
    }
}
