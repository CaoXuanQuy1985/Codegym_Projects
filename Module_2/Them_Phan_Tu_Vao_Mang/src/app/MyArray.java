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

    public static int insertElem(int[] arr, int elem, int posInsert) {
        int space = checkSpace(arr) - 1;
        int lastIndex = arr.length - space - 1;
        if(space == 0){
            System.out.println("Khong gian con thua da het, khong the gan them phan tu vao mang");
            return -1;
        }else{
            for (int i = lastIndex; i >= posInsert; i--) {
                if (i == posInsert) {
                    arr[i + 1] = arr[i];
                    arr[i] = elem;
                }else{
                    arr[i + 1] = arr[i];
                }
            }
        }

        showArray(arr);

        return 0;
    }

    private static int checkSpace(int[] arr) {
        int index;

        for(index = 0; index < arr.length; index++) {
            if (arr[index] == 0) {
                break;
            }
        }

        return arr.length - index + 1;
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
        int[] arr = {5,6,8,2,1,13, 56,19, 0, 0, 0, 0};

        int insertElem = 0, insertPos = 0;
        while(true){
            System.out.println("Nhap phan tu can chen:");
            insertElem = getInput();
            System.out.println("Nhap vi tri can chen:");
            insertPos = getInput();

            if(insertElem(arr, insertElem, insertPos) == -1){
                System.exit(0);
            }
        }
    }
}