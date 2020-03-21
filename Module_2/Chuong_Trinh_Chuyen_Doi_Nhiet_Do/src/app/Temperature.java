package app;
import java.util.Scanner;

class Temperature {
    private static Scanner sc;

    private static float getInput() {
        sc = new Scanner(System.in);

        if(sc.hasNextFloat()) {
            return sc.nextFloat();
        }

        System.out.println("This format is invalid, try again !!!");
        return getInput();
    }

    private static int getChoice() {
        sc = new Scanner(System.in);
        System.out.println("Ban muon chay ung dung nao 1 hay 2:");

        if(sc.hasNextInt()) {
            return sc.nextInt();
        }

        System.out.println("This format is invalid, try again !!!");
        return getChoice();
    }

    private static float convertFtoC(float fahr) {
        return (5.0f / 9f) * (fahr - 32f);
    }

    private static float convertCtoF(float cel) {
        return (cel / (5.0f / 9f)) + 32;
    }

    public static void processChoice() {
        System.out.println(
                                        "Menu application: \n" +
                                        "1. Convert Fahrenheit to Celcious \n" +
                                        "2. Convert Celcious to Fahrenheit \n" +
                                        "0. Exit"
                                    );
        
        int choice = getChoice();
        if (choice == 1) {
            System.out.println("Hay nhap gia tri Fahrenheit: ");
            float fahr = getInput();
            float cel = convertFtoC(fahr);
            System.out.println("Gia tri Fahrenheit = " + fahr + " chuyen thanh celcious = " + cel);
        } else if (choice == 2) {
            System.out.println("Hay nhap gia tri Celcious: ");
            float cel = getInput();
            float fahr = convertCtoF(cel);
            System.out.println("Gia tri Celcious = " + cel + " chuyen thanh fahrenheit = " + fahr);
        } else {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        processChoice();
    }
}