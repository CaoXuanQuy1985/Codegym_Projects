package app;
import java.util.Arrays;
import java.util.Scanner;

public class SquareMatrix {
    private static Scanner sc;
    private static float[][] arr2dim;

    private static int getInputLength() {
        sc = new Scanner(System.in);

        if(sc.hasNextInt()){
            return sc.nextInt();
        }

        System.out.print("Length is not valid, try again");
        return getInputLength();
    }

    private static float getInput() {
        sc = new Scanner(System.in);

        if(sc.hasNextFloat()){
            return sc.nextFloat();
        }

        System.out.print("Float is not valid, try again");
        return getInput();
    }

    public static void sum2Diagonals(float[][] arr2dim) {
        float sum = 0;
       
        sum = sumDiagTopLeft(arr2dim) + sumDiagTopRight(arr2dim);

        System.out.println("Tổng các số của 2 đường chéo chính trong ma trận vuông là: " + sum);
    }

    private static float sumDiagTopLeft(float[][] arr2dim) {
        float sum = 0;

        for(int i = 0; i < arr2dim.length; i++){
            for(int j = 0; j < arr2dim[i].length; j++) {
                if (i == j) {
                    sum += arr2dim[i][j];
                }
            }
        }

        return sum;
    }

    private static float sumDiagTopRight(float[][] arr2dim) {
        float sum = 0;

        for(int i = 0; i < arr2dim.length; i++){
            for(int j = 0; j < arr2dim[i].length; j++) {
                if (j == arr2dim.length - i - 1) {
                    sum += arr2dim[i][j];
                }
            }
        }

        return sum;
    }


    public static float[][] takeElemToArr() {
        System.out.println("Nhập số hàng và cột của ma trận vuông: ");
        int numRowCol = getInputLength();

        arr2dim = new float[numRowCol][numRowCol];
        for(int i = 0; i < arr2dim.length; i++){
            for(int j = 0; j < arr2dim[i].length; j++) {
                System.out.println("Nhap phan tu ma tran arr2dim[" + i + "]" + "[" + j + "]");
                arr2dim[i][j] = getInput();
            }
        }

        System.out.println("Mang 2 chieu ban vua nhap vao la: " + Arrays.deepToString(arr2dim));
        return arr2dim;
    }

    public static void main(String[] args){
        takeElemToArr();
        sum2Diagonals(arr2dim);
    }
}