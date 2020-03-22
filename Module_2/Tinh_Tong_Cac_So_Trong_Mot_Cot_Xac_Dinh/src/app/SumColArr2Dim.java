package app;
import java.util.Arrays;
import java.util.Scanner;

public class SumColArr2Dim {
    private static Scanner sc;
    private static int[][] arr2dim;

    private static int getInput() {
        sc = new Scanner(System.in);

        if(sc.hasNextInt()){
            return sc.nextInt();
        }

        System.out.print("Integer is not valid, try again");
        return getInput();
    }

    public static void sumCol(int[][] arr2dim, int noCol) {
        int sum = 0;
        for(int i = 0; i < arr2dim.length; i++) {
            for(int j = 0; j < arr2dim[i].length; j++) {
                if (j == noCol - 1) {
                    sum += arr2dim[i][j];
                }
            }
         }

        System.out.println("Tong so gia tri cac phan tu mang tai vi tri cot thu " + noCol + " la: " + sum);
    }

    public static int[][] takeElemToArr() {
        System.out.println("Nhập so hàng mảng 2 chieu: ");
        int numRow = getInput();
        System.out.println("Nhập so cột mảng 2 chieu: ");
        int numCol = getInput();

        arr2dim = new int[numRow][numCol];
        for(int i = 0; i < arr2dim.length; i++){
            for(int j = 0; j < arr2dim[i].length; j++) {
                System.out.println("Nhap phan tu arr2dim[" + i + "]" + "[" + j + "]");
                arr2dim[i][j] = getInput();
            }
        }

        System.out.println("Mang 2 chieu ban vua nhap vao la: " + Arrays.deepToString(arr2dim));
        return arr2dim;
    }

    public static void main(String[] args){
        takeElemToArr();
        System.out.println("Ban muon tinh tong cac phan tu o cot thu may");
        int noCol = getInput();
        sumCol(arr2dim, noCol);
    }
}