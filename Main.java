import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        LinkedStack<Integer> undoStack = new LinkedStack<>();
        LinkedStack<Integer> redoStack = new LinkedStack<>();
        boolean valid = true; // will be used to stop the while loop of program when q is used

        System.out.println("Simple Calculator: type z to undo, y to redo, q to quit");

        System.out.print("Enter the first number:\n");
        int value1 = kb.nextInt();
        undoStack.push(value1); // push initial number given to undo stack

        while (valid) {
            System.out.println("Enter the next operation on " + value1 + ":");
            String operation = kb.next(); // The operation to be performed on the 2 values
            // if the operation input is q, break out of loop
            if (operation.equalsIgnoreCase("q")) {
                valid = false;
                System.out.println("Goodbye!");
                //undoStack.displayStack();
            }
            // If "z" is input, it activates the undo functionality
            else if (operation.equalsIgnoreCase("z")) {
                if (undoStack.isEmpty()) {
                    System.out.println("Nothing to undo");
                    System.out.print("Enter the first number:\n");
                    value1 = kb.nextInt();
                    undoStack.push(value1); // push initial number given to undo stack
                } else {
                    // if value1 == undoStack.top(), pop it off, store that value, then push it back later
                    // Basically allows us to not undo back to the current value, and go to previous one in stack
                    if (value1 == undoStack.top()) {
                        int undoCurrentOpValue = undoStack.pop();
                        redoStack.push(undoCurrentOpValue);
                    }
                    int undoValue = undoStack.pop(); // take top value off of undo stack
                    System.out.println("UNDO: " + undoValue);
                    value1 = undoValue;
                    redoStack.push(undoValue); // place undo value in redo stack
                }
            } else if (operation.equalsIgnoreCase("y")) {
                if (redoStack.isEmpty()) {
                    System.out.println("Nothing to redo");
                }
                else {
                    // Basically allows us to not undo back to the current value, and go to previous one in stack
                    if (value1 == redoStack.top()) {
                        int redoCurrentOpValue = redoStack.pop();
                        undoStack.push(redoCurrentOpValue);
                    }
                    int redoValue = redoStack.pop(); // take top value off of redo stack
                    System.out.println("REDO: " + redoValue);
                    value1 = redoValue;
                    undoStack.push(redoValue); // push redo value to undo stack
                }
            } else {
                int value2 = kb.nextInt();
                int result = calculate(value1, value2, operation);
                System.out.println("= " + result);
                undoStack.push(result);
                value1 = result;
            }
        }
    }

    public static int calculate(int value1, int value2, String operation) {
        // use switch statement for each operator
        switch (operation) {
            case "+":
                return value1 + value2;
            case "-":
                return value1 - value2;
            case "*":
            case "x":
                return value1 * value2;
            case "/":
                if (value2 == 0) { // make sure can't divide by 0
                    System.out.println("You can't divide by 0");
                    return 0;
                } else {
                    return value1 / value2;
                }
            default:
                return 0;
        }
    }
}
