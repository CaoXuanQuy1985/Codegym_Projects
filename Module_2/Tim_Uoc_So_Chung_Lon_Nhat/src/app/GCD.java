package app;
import java.util.Scanner;

public class GCD {
    private static Scanner sc;
    private static int max;
    private static int min;
    private static int remainder;

    private static int getInput(){
        sc = new Scanner(System.in);

        if (sc.hasNextInt()){
            return sc.nextInt();
        }

        System.out.println("This is not valid Integer, please try again !!!");

        return getInput();
    }

    public static int findGCD(int num1, int num2){
        if(num1 > num2){
            max = num1;
            min = num2;
        } else { 
            max = num2;
            min = num1;
        }

        remainder = max % min;
        
        if (remainder == 0) {
            return min;
        } else {
            max = remainder;
            return findGCD(max, min);
        }
    }

    public static void main(String[] args){
        System.out.println("Input the first integer = ");
        int firstNum = getInput();
        System.out.println("Input the second integer = ");
        int secondNum = getInput();

        if(firstNum == secondNum){
            System.out.println("GCD is " + firstNum);
        }else if (firstNum == 0 && secondNum != 0) {
            System.out.println("GCD is " + secondNum);
        }else if (firstNum != 0 && secondNum == 0) {
            System.out.println("GCD is " + firstNum);
        }else {
            int gcd = findGCD(firstNum, secondNum);
            System.out.println("GCD is " + gcd);
        }
    }
}