package Lab4.Functions;

public class ArrayDownQueue implements Queue {
    private int[] array;
    private int front;
    private int rear;
    private int size;

    public ArrayDownQueue() {
        array = new int[5];
        front = 4;
        rear = 0;
        size = 5;
    }

    @Override
    public void enqueue(int element) {
        if (front == -1) {
            System.out.println("Queue is full. Cannot enqueue element.");
            return;
        }
        array[front] = element;
        front--;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int element = peek();
        for (int i = size - 1; i > front + 1; i--){
            array[i] = array[i-1];
        }
        front += 1;
        return element;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1;
        }
        int peekIndex = size-1;
        return array[peekIndex];
    }

    @Override
    public boolean isEmpty() {
        return front == size-1;
    }
}
