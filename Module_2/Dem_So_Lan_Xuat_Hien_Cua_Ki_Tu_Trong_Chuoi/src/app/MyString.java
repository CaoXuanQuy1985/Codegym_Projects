package app;
import java.util.Scanner;

public class MyString {
    private static Scanner sc;

    private static char getChar() {
        sc = new Scanner(System.in);

        if(sc.hasNext()) {
            char c = sc.next().charAt(0);
            return c;
        }

        System.out.println("Hay nhap vao 1 ky tu thoi");
        return getChar();
    }

    public static int countChar(String str, char c) {
        int countChar = 0;

        for (char elem : str.toCharArray()) {
            countChar = (Character.compare(elem, c) == 0) ? countChar + 1 : countChar;
        }

        return countChar;
    }

    public static void main(String[] args) {
        String sourceStr = "Xin chao Viet Nam";

        System.out.println("Hay nhap 1 ki tu de tim so lan ki tu do xuat hien trong chuoi: ");
        char c = getChar();
        System.out.println("Ki tu: " + c + " xuat hien " + countChar(sourceStr, c) + " lan trong chuoi");
    }
}