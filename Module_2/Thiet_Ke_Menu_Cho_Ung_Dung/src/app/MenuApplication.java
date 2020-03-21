package app;
import java.util.Scanner;

class MenuApplication {
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

    private static void drawSquare(){
        for(int i = 1; i <= 10; ++i){
            for(int j = 1; j <= 30; ++j){
                if(i == 1  || i == 10) {
                    if (j <= 5) {
                        System.out.print(" ");
                    } else {
                        System.out.print("*");
                    }
                } else {
                    if (j == 6 || j == 30){
                        System.out.print("*");
                    } else  {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }

    private static void drawRectangle(){
        for(int i = 1; i <= 10; ++i){
            for(int j = 1; j <= 60; ++j){
                if(i == 1  || i == 10) {
                    if (j <= 5) {
                        System.out.print(" ");
                    } else {
                        System.out.print("*");
                    }
                } else {
                    if (j == 6 || j == 60){
                        System.out.print("*");
                    } else  {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }

    private static void genMenu(){
        System.out.println(
                                      "Menu application: \n" +
                                      "1. Draw a Triangle \n" +
                                      "2. Draw a Square \n" + 
                                      "3. Draw a Rectangle \n" + 
                                      "0. Exit \n" + 
                                      "Please, choicing an option: "
                                  );

    }

    public static void processChoice(int choice){
        if (choice == 1) {
            drawTriangle();
        } else if (choice == 2) {
            drawSquare();
        } else if (choice == 3){
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