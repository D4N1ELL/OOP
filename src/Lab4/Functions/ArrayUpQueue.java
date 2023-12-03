package Lab4.Functions;

public class ArrayUpQueue implements Queue{
    private int[] array;
    private int front;
    private int rear;
    private int size;

    public ArrayUpQueue() {
        array = new int[5];
        front = 0;
        rear = -1;
        size = 0;
    }

    @Override
    public void enqueue(int element) {
        if (size == 5) {
            System.out.println("Queue is full. Cannot enqueue element.");
            return;
        }
        rear++;
        array[rear] = element;
        size++;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int element = peek();
        front++;
        size--;
        return element;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1;
        }
        return array[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}

