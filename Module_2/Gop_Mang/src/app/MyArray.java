package app;
import java.util.Scanner;

class MyArray {
    private static Scanner sc;

    private static int getInput() {
        sc = new Scanner(System.in);

        if(sc.hasNextInt()){
            return sc.nextInt();
        }

        System.out.print("Integer is not valid, try again");
        return getInput();
    }

    public static int[] joinArray(int[] arr1, int[] arr2) {
        int[] resultArr = new int[arr1.length + arr2.length];
        int resultIndex = 0;

        for(int item : arr1) {
            resultArr[resultIndex++] = item;
        }

        for(int item : arr2) {
            resultArr[resultIndex++] = item;
        }

        return resultArr;
    }

    public static void showArray(int[] arr) {
        System.out.print("[");
        for(int i = 0; i < arr.length; i++){
            if(i != arr.length - 1) {
                System.out.print(arr[i] + ", ");
            }else{
                System.out.print(arr[i]);
            }
        }
        System.out.println("]");

    }

    public static void main(String[] args){
        System.out.println("Nhập chiều dài mảng arr1: ");
        int len1 = getInput();
        int[] arr1 = new int[len1];
        for(int i = 0; i < len1; i++){
            System.out.println("Nhập phần tử arr1[" + i + "]");
            arr1[i] = getInput();
        }
        System.out.println("Nhập chiều dài mảng arr2: ");
        int len2 = getInput();
        int[] arr2 = new int[len2];
        for(int i = 0; i < len2; i++){
            System.out.println("Nhập phần tử arr2[" + i + "]");
            arr2[i] = getInput();
        }

        showArray(joinArray(arr1, arr2));
    }
}