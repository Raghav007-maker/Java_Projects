package Basic_Projects;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Calculator");
        System.out.println();

        ChoseOperation();
    }

    public static void ChoseOperation() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choice One Operation:");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Devide");
        System.out.println();
        System.out.print("Select The Operation:");

        int Operation = sc.nextInt();
        // Taking Numbers from User After taking the Operator
        UserInput(Operation);
    }

    public static void UserInput(int Operation) {
        Scanner sc = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;

        switch (Operation) {
            case 1:
                System.out.println("Lets PerForm Addition");

                break;
            case 2:
                System.out.println("Lets PerForm Subtraction");

                break;
            case 3:
                System.out.println("Lets PerForm Multiplication");

                break;
            case 4:
                System.out.println("Lets PerForm Devision");
                break;
            default:
                // Condition For Invalid Operator
                System.out.println("INVALID OPERATOR!!");
                return;

        }
        System.out.println("Give Two Number on Two Line");
        System.out.print("Number 1:");
        num1 = sc.nextInt();//Taking number 1 Input
        System.out.print("Number 2:");
        num2 = sc.nextInt();//Taking number 2 Input
        Calculate(num1, num2, Operation);
    }

    public static void Calculate(int num1, int num2, int op) {
        switch (op) {
            case 1:
                System.out.println(num1 + num2);
                break;
            case 2:
                System.out.println(num1 - num2);
                break;
            case 3:
                System.out.println(num1 * num2);
                break;
            case 4:
                try {
                    double ans = devide(num1, num2);
                    System.out.println(ans);

                }
                catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                }
                catch (Exception e) {
                System.out.println(e.getMessage());  
                }
                break;
            default:
                break;
        }
    }

    public static double devide(int num1, int num2) throws ArithmeticException {
        if (num2 == 0) {
            throw new ArithmeticException("Devide By Zero INVALID!!");
        }
        double devide = num1 / (double) num2;
        return devide;
    }
}
