package Lab4.Operations;

import Lab4.Functions.Queue;
import java.util.Scanner;

public class QueueOperations {
    private Queue queue;

    public QueueOperations(Queue queue) {
        this.queue = queue;
    }

    public void performQueueOperations(Scanner scanner) {
        while (true) {
            System.out.println("*---Choose a queue operation---*");
            System.out.println("|1. Enqueue                    |");
            System.out.println("|2. Dequeue                    |");
            System.out.println("|3. Peek                       |");
            System.out.println("|0. Back to Main Menu          |");
            System.out.println("*------------------------------*");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter 1 element to enqueue to queue: ");
                    int element = scanner.nextInt();
                    queue.enqueue(element);
                    break;
                case 2:
                    int dequeuedElement = queue.dequeue();
                    if (dequeuedElement != -1) {
                        System.out.println("Dequeued element from queue: " + dequeuedElement);
                    }
                    break;
                case 3:
                    int peekedElement = queue.peek();
                    if (peekedElement != -1) {
                        System.out.println("Peeked element from queue: " + peekedElement);
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Write choice number");
            }
        }
    }
}

