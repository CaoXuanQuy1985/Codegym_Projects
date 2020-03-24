package app;
import java.util.Arrays;
import java.util.Random;
import java.util.Date;

public class StopWatch {
    private int sizeArray;
    private int[] array;
    private static Random rand = new Random();
    private long startTime;
    private long endTime;


    public StopWatch() {
        this.sizeArray = 100000;
        this.array = new int[this.sizeArray];
        this.startTime = System.currentTimeMillis();
    }

    public StopWatch(int sizeArray) {
        this.sizeArray = sizeArray;
        this.array = new int[this.sizeArray];
        this.startTime = System.currentTimeMillis();
    }

    public long getStartTime(){
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public long start() {
        System.out.println("Thời gian hiện tại của hệ thống trước khi sắp xếp là: " + new Date());
        this.startTime = System.currentTimeMillis();

        return this.startTime;
    }

    public long stop() {
        System.out.println("Thời gian hiện tại của hệ thống sau khi sắp xếp là: " + new Date());
        this.endTime = System.currentTimeMillis();

        return this.endTime;
    }

    public long measureElapseTime() {
        System.out.println("Thời gian mà thuật toán cần để thực thi hàm sắp xếp các phần tử mảng (Selection sort) là:\n (Tính theo milliseconds)");
        return this.endTime -  this.startTime;
    }

    private static int[] genArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        return array;
    }

    private static int[] shufflingArray(int[] array) {
        int indexRandom = 0;
        int temp = 0;
        for(int i = 0; i < array.length; i++){
            indexRandom = rand.nextInt(array.length - 1);
            temp = array[i];
            array[i] = array[indexRandom];
            array[indexRandom] = temp;
        }

        return array;
    }

    public int[] initialArray(int[] arr) {
        return shufflingArray(genArray(this.array));
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private int[] sortBySelection(int[] array) {
        int min, indexMin;
        int outer, inner;

        start();
        for(outer = 0; outer < array.length; outer++) {
            min = array[outer];
            indexMin = outer;
            for(inner = outer + 1; inner < array.length; inner++) {
                if (min > array[inner]) {
                    min = array[inner];
                    indexMin = inner;
                }
            }
            swap(array, outer, indexMin);
        }
        stop();
        System.out.println(measureElapseTime());

        return array;
    }
    
    public void showArray(){
        genArray(this.array);
        shufflingArray(this.array);
        System.out.println("Mảng trước khi sắp xếp:");
        System.out.println(Arrays.toString(this.array));
        sortBySelection(this.array);
        System.out.println("Mảng sau khi sắp xếp (Selection sort):");
        System.out.println(Arrays.toString(this.array));
    }
}