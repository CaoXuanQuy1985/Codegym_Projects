package app;
import java.util.Scanner;

class MyArray {
    private static Scanner sc;

    private static int getInput() {
        sc = new Scanner(System.in);

        if(sc.hasNextInt()) {
            return sc.nextInt();
        }

        System.out.println("Value is invalid");
        return getInput();
    }

    public static void removeElem(int[] arr, int elem) {
        int index;
        for (index = 0; index < arr.length; index++) {
            if(elem == arr[index])
                break;
        }

        if (index == arr.length) {
            System.out.println("Khong tim thay phan tu can xoa trong mang, nen mang kong thay doi");
        } else {
            System.out.println("Da tim thay phan tu can xoa: " + arr[index] + " sau khi xoa mang tro thanh: ");
            for (int j = index; j < arr.length - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[arr.length - 1] = 0;
        }

        showArray(arr);
    }
    
    private static void showArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                System.out.print(arr[i] + ", ");
            } else {
                System.out.print(arr[i]);
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] arr = {5,6,8,2,1,13, 56,19};
        System.out.println("Nhap phan tu can xoa:");
        int removeElem = getInput();
        removeElem(arr, removeElem);
        System.out.println("Nhap phan tu can xoa:");
        removeElem = getInput();
        removeElem(arr, removeElem);
        System.out.println("Nhap phan tu can xoa:");
        removeElem = getInput();
        removeElem(arr, removeElem);
    }
}