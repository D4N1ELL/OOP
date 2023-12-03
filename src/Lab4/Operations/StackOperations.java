package Lab4.Operations;

import Lab4.Functions.Stack;
import java.util.Scanner;

public class StackOperations {
    private Stack stack;

    public StackOperations(Stack stack) {
        this.stack = stack;
    }

    public void performStackOperations(Scanner scanner) {
        while (true) {
            System.out.println("*---Choose a stack operation---*");
            System.out.println("|1. Push                       |");
            System.out.println("|2. Pop                        |");
            System.out.println("|3. Peek                       |");
            System.out.println("|0. Back to Main Menu          |");
            System.out.println("*------------------------------*");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter 1 element to push to stack: ");
                    int element = scanner.nextInt();
                    stack.push(element);
                    break;
                case 2:
                    int poppedElement = stack.pop();
                    if (poppedElement != -1) {
                        System.out.println("Popped element from stack: " + poppedElement);
                    }
                    break;
                case 3:
                    int peekedElement = stack.peek();
                    if (peekedElement != -1) {
                        System.out.println("Peeked element from stack: " + peekedElement);
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
