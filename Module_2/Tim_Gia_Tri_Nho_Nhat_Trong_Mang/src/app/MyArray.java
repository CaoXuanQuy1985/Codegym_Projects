package app;

class MyArray {
    public static int findMin(int[] arr) {
        int min = arr[0];

        for(int item : arr) {
            if(min > item) {
                min = item;
            }
        }

        return min;
    }
    public static void main(String[] args) {
        int[] arr = {3,9,6,2,100, 89, 94};

        System.out.println("Min = " + findMin(arr));
    }
}