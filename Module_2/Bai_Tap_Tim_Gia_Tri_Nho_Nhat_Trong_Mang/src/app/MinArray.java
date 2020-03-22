package app;
import java.util.Scanner;

public class MinArray {
    private static Scanner sc;
    private static int[] arr;

    private static int getInput() {
        sc = new Scanner(System.in);

        if(sc.hasNextInt()){
            return sc.nextInt();
        }

        System.out.print("Integer is not valid, try again");
        return getInput();
    }

    public static void findMin(int[] arr) {
        int min = arr[0];
        int i;
        int flag = 0;
        for( i = 0; i < arr.length; i++) {
                if(min > arr[i]){
                    min = arr[i];
                    flag = i;
                }
        }

        System.out.println("Phan tu nho nhat trong mang la: " + min + " tai vi tri i = " + flag);
    }

    public static int[] takeElemToArr() {
        System.out.println("Nhập chieu dai cua mang: ");
        int len = getInput();

        arr = new int[len];
        for(int i = 0; i < arr.length; i++){
                System.out.println("Nhap phan tu arr[" + i + "]: ");
                arr[i] = getInput();
        }

        return arr;
    }

    public static void main(String[] args){
        findMin(takeElemToArr());
    }
}