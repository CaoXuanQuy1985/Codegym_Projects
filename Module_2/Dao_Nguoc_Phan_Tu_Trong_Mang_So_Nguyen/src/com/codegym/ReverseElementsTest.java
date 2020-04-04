package com.codegym;

public class ReverseElementsTest {
    public static void main(String[] args) {
        System.out.println("Đảo ngược mảng số nguyên:");
        Integer[] arrayInt = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ReverseElements<Integer> reInt = new ReverseElements<>(Integer.class);
        Integer[] resultInt = reInt.reverseArray(arrayInt);

        for (Integer elem : resultInt) {
            System.out.print(elem + ", ");
        }
        System.out.println();
        System.out.println("Đảo ngược Chuỗi:");

        ReverseElements<Character> reString = new ReverseElements<Character>(Character.class);
        char[] array = "Cao Xuan Quy Handsome".toCharArray();
        Character[] arrayCharacter = new Character[array.length];

        for (int i = 0; i < array.length; i++) {
            arrayCharacter[i] = array[i];
        }
        Character[] resultChar = reString.reverseArray(arrayCharacter);
        for (Character c : resultChar) {
            System.out.print(c);
        }
        System.out.println();
    }
}