package com.codegym;

public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList<Integer>(Integer.class);

        for (int i = 0; i < 40; i++) {
            arrayList.add(new Integer(i), Integer.class);
        }

        arrayList.displayArrayList();

        System.out.println("Láy phần tử có chỉ số index = 5 : " + arrayList.get(5));
        System.out.println("Láy phần tử có chỉ số index = 13: " + arrayList.get(13));
    }
}