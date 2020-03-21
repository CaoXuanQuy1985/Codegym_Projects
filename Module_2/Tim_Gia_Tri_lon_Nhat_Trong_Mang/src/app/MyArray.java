package app;
import java.util.Scanner;

class MyArray {
    private static Scanner sc;
    private static float[] arrEstate = new float[20];

    private static float getInput() {
        sc = new Scanner(System.in);

        if (sc.hasNextFloat()) {
            return sc.nextFloat();
        }

        System.out.println("Format estate is invalid, please try again !!!");
        return getInput();
    }

    private static float[] initialArray(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Nhap gia tri tai san cua ty phu " + i + ": ");
            arr[i] = getInput();
        }

        return arr;
    }

    public static void findMax(float[] arr) {
        float max = arr[0];
        int mark = 0;

        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                mark = i;
            }
        }

        System.out.println("Ty phu co so tai san lon nhat la: " + max + " cua ty phu thu[" + mark + "]");
    }

    public static void main(String[] args) {
        initialArray(arrEstate);
        findMax(arrEstate);
    }
}