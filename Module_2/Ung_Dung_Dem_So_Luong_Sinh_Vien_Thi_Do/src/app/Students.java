package app;
import java.util.Scanner;

public class Students {
    private static Scanner sc;
    private static float[] arr;

    private static int getInputSize() {
        sc = new Scanner(System.in);

        if(sc.hasNextInt()){
            return sc.nextInt();
        }

        System.out.print("Integer is not valid, try again");
        return getInputSize();
    }

    private static float getInputScore() {
        sc = new Scanner(System.in);

        if(sc.hasNextFloat()){
            return sc.nextFloat();
        }

        System.out.print("Float is not valid, try again");
        return getInputScore();
    }

    public static void countPass(float[] arr) {
        int sumPass = 0;
        for(int i = 0; i < arr.length; i++) {
                if(arr[i] >= 5){
                    sumPass++;
                }
        }

        System.out.println("Tổng số sinh viên thi đỗ là: " + sumPass);
    }

    public static float[] takeElemToArr() {
        System.out.println("Nhập chieu dai cua mang sinh vien: ");
        int len = getInputSize();

        arr = new float[len];
        for(int i = 0; i < arr.length; i++){
                System.out.println("Nhap so diem students[" + i + "]: ");
                arr[i] = getInputScore();
        }

        return arr;
    }

    public static void main(String[] args){
        countPass(takeElemToArr());
    }
}