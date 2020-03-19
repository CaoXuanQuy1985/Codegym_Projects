package app;
import java.util.Scanner;

public class LeafYear{
    private static Scanner sc;

    private static int getInput(){
        sc = new Scanner(System.in);

        if(sc.hasNextInt()){
            return sc.nextInt();
        }

        System.out.println("Format year is invalid, please try again");
        return getInput();
    }

    public static void checkYear(){
        System.out.println("Input a year to check: ");
        int year = getInput();
        if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))){
            System.out.println(year + " is a leaf year");
            return;
        }
        System.out.println(year + " is not a leaf year");
    }

    public static void main(String[] args){
        checkYear();
    }
}