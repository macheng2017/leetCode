public class ArrayStack<E> implements Stack<E> {

    private Array<E> arr;

    public ArrayStack(int capacity) {
        arr = new Array<>(capacity);
    }

    public ArrayStack() {
        arr = new Array<>();
    }


    @Override
    public int getSize() {
        return arr.getSize();
    }

    @Override
    public boolean isEmpty() {
        return arr.isEmpty();
    }

    @Override
    public void push(E e) {
        arr.addLastList(e);
    }

    @Override
    public E pop() {
        return arr.removeLatest();
    }

    @Override
    public E pick() {
        return arr.getLatest();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Stack: ");
        str.append("[");
        for (int i = 0; i < arr.getSize(); i++) {
            str.append(arr.get(i)).append(',');
        }
        str.deleteCharAt(str.lastIndexOf(","));
        str.append("] top");
        return str.toString();
    }

    public int getCapacity() {
        return arr.getCapacity();
    }

}
