package Lab4;

import Lab4.Functions.*;
import Lab4.Operations.QueueOperations;
import Lab4.Operations.StackOperations;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("*---Choose a data structure---*");
            System.out.println("|1. Stack (ArrayUpStack)      |");
            System.out.println("|2. Stack (LinkedStack)       |");
            System.out.println("|3. Stack (ArrayDownStack)    |");
            System.out.println("|4. Queue (ArrayUpQueue)      |");
            System.out.println("|5. Queue (LinkedQueue)       |");
            System.out.println("|6. Queue (ArrayDownQueue)    |");
            System.out.println("|0. Exit                      |");
            System.out.println("*-----------------------------*");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Stack arrayUpStack = new ArrayUpStack();
                    StackOperations arrayUpStackOperations = new StackOperations(arrayUpStack);
                    arrayUpStackOperations.performStackOperations(scanner);
                    break;
                case 2:
                    Stack linkedStack = new LinkedStack();
                    StackOperations linkedStackOperations = new StackOperations(linkedStack);
                    linkedStackOperations.performStackOperations(scanner);
                    break;
                case 3:
                    Stack arrayDownStack = new ArrayDownStack();
                    StackOperations arrayDownStackOperations = new StackOperations(arrayDownStack);
                    arrayDownStackOperations.performStackOperations(scanner);
                    break;
                case 4:
                    Queue arrayUpQueue = new ArrayUpQueue();
                    QueueOperations arrayUpQueueOperations = new QueueOperations(arrayUpQueue);
                    arrayUpQueueOperations.performQueueOperations(scanner);
                    break;
                case 5:
                    Queue linkedQueue = new LinkedQueue();
                    QueueOperations linkedQueueOperations = new QueueOperations(linkedQueue);
                    linkedQueueOperations.performQueueOperations(scanner);
                    break;
                case 6:
                    Queue arrayDownQueue = new ArrayDownQueue();
                    QueueOperations arrayDownQueueOperations = new QueueOperations(arrayDownQueue);
                    arrayDownQueueOperations.performQueueOperations(scanner);
                    break;
                case 0:
                    System.out.println("Exiting program");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Write choice number");
            }
        }
    }
}