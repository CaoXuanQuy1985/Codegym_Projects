package app;
import java.util.Scanner;

public class Array2Dim {
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

    public static void findMax(int[][] arr2dim) {
        int max = arr2dim[0][0];
        int row = 0, col = 0;

        for(int i = 0; i < arr2dim.length; i++) {
            for(int j = 0; j < arr2dim[i].length; j++) {
                if(max < arr2dim[i][j]){
                    max = arr2dim[i][j];
                    row = i;
                    col = j;
                }
            }
        }

        System.out.println("Phan tu lon nhat trng mang la: " + max + " tai vi tri hang i = " + row + " cot j = " + col);
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

        return arr2dim;
    }

    public static void main(String[] args){
        findMax(takeElemToArr());
    }
}