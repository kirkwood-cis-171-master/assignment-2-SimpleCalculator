package edu.kirkwood.cis171;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] userInput;
        userInput = scanInput();
        try {
            System.out.print(userInput[0] + " " + userInput[1] + " " + userInput[2]);
        } catch (IndexOutOfBoundsException e) {
            System.err.print("Invalid input: " + e.getMessage());
        }
        String endResult = calculation(userInput);
        outputResult(endResult);
    }

    private static String[] scanInput() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a math problem involving operations: (+,-,/,*) to be solved:");
        String calculation = s.nextLine();
        String[] userInput;
        userInput = calculation.split(" ");
        return userInput;
    }

    public static String calculation(String[] operators) {
        double firstNumber = 0.0;
        double secondNumber = 0.0;
        String operatorType = " ";
        try {
            firstNumber = Double.parseDouble(operators[0]);
            secondNumber = Double.parseDouble(operators[2]);
            operatorType = operators[1];
        } catch (Exception e) {
            System.out.println("Invalid input! Please try again...");
            System.exit(0);
        } if (operatorType.equals("+")) {
            return ("The answer is: " + (String.format("%.3g%n", firstNumber + secondNumber)));

        } else if (operatorType.equals("*")) {
            return("The answer is: " + (String.format("%.3g%n", firstNumber * secondNumber)));

        } else if (operatorType.equals("-")) {
            return("The answer is: " + (String.format("%.3g%n", firstNumber - secondNumber)));

        } else if (operatorType.equals("/")) {
            if (secondNumber == 0) {
                return("ERROR: You cannot divide a number by 0! Please try again...");
            }
            return("The answer is: " + (String.format("%.3g%n", firstNumber / secondNumber)));

        } else {
            return("ERROR: Invalid input! Please try again...");
        }
    }

    public static void outputResult(String result) {
        String outputResult = result;
        System.out.println(outputResult);
    }
}
