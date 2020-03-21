package app;
import java.util.Scanner;

class Shape {
    private static Scanner sc;

    private static int getInput(){
        sc = new Scanner(System.in);

        if (sc.hasNextInt()){
            return sc.nextInt();
        }

        System.out.println("The choice is invalid, try again !!!");
        return getInput();
    }

    private static void drawTriangle(){
        for (int i = 1; i <= 20; ++i) {
            for (int j = 1; j <= i; ++j ){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        for (int i = 1; i <= 20; ++i) {
            for (int j = 1; j <= 20 - i; ++j ){
                System.out.print(" ");
            }
            for (int j = 1; j <= i; ++j ){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        for (int i = 1; i <= 20; ++i) {
            for (int j = 1; j <= 20 - i; ++j ){
                System.out.print("*");
            }
            for (int j = 1; j <= i; ++j ){
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        for (int i = 1; i <= 20; ++i) {
            for (int j = 1; j <= i; ++j ){
                System.out.print(" ");
            }
            for (int j = 1; j <= 20 - i; ++j ){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    private static void drawIsosceleTriangle(){
        int step = 0;
        for (int i = 1; i <= 10; ++i) {
            for (int j = 1; j <= 30; ++j ){
                if (j == (15 - i)){
                    for (int k = 1; k <= (i + step); ++k){
                        System.out.print("*");
                    }
                    j = j + i;
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
            step = i;
        }
        System.out.println();
    }

    private static void drawRectangle(){
        for(int i = 1; i <= 6; ++i){
            for(int j = 1; j <= 30; ++j){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void genMenu(){
        System.out.println(
                                      "Menu application: \n" +
                                      "1. Print a Rectangle \n" + 
                                      "2. Print a Square Triangle \n" +
                                      "3. Print  Isosceles Triangle \n" + 
                                     
                                      "0. Exit \n" + 
                                      "Please, choicing an option: "
                                  );

    }

    public static void processChoice(int choice){
        if (choice == 2) {
            drawTriangle();
        } else if (choice == 3) {
            drawIsosceleTriangle();
        } else if (choice == 1){
            drawRectangle();
        } else {
            System.exit(0);
        }
    }
    public static void main(String[] args){
        while (true) {
              genMenu();
              int choice = getInput();
              processChoice(choice);
        }
    }
}