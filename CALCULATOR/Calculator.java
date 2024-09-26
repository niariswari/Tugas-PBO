import java.util.Scanner;

public class Calculator {
    private NumberDisplay num1;
    private NumberDisplay num2;
    private ResultDisplay resultDisplay;

    public Calculator() {
        num1 = new NumberDisplay();
        num2 = new NumberDisplay();
        resultDisplay = new ResultDisplay();
    }

    public void setNumbers(double number1, double number2) {
        num1.setValue(number1);
        num2.setValue(number2);
    }

    public void add() {
        double result = num1.getValue() + num2.getValue();
        resultDisplay.updateDisplay(result);
    }

    public void subtract() {
        double result = num1.getValue() - num2.getValue();
        resultDisplay.updateDisplay(result);
    }

    public void multiply() {
        double result = num1.getValue() * num2.getValue();
        resultDisplay.updateDisplay(result);
    }

    public void divide() {
        if (num2.getValue() != 0) {
            double result = num1.getValue() / num2.getValue();
            resultDisplay.updateDisplay(result);
        } else {
            System.out.println("Error: Division by zero is not allowed.");
        }
    }

    public void displayResult() {
        System.out.println(resultDisplay.getDisplay());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.println("Enter the first number: ");
        double number1 = scanner.nextDouble();

        System.out.println("Enter the second number: ");
        double number2 = scanner.nextDouble();

        calculator.setNumbers(number1, number2);

        System.out.println("Choose an operation: (+, -, *, /): ");
        char operation = scanner.next().charAt(0);

        switch (operation) {
            case '+':
                calculator.add();
                break;
            case '-':
                calculator.subtract();
                break;
            case '*':
                calculator.multiply();
                break;
            case '/':
                calculator.divide();
                break;
            default:
                System.out.println("Invalid operation! Please choose +, -, *, or /.");
                return;
        }

        calculator.displayResult();
        scanner.close();
    }
}
