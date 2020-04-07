package com.codegym;

import java.util.Scanner;

public class AlgorithmComplexityTest {
    private static char[] arrayCharacters;
    private static int[] arrayFrequent = new int[255];
    private static Scanner sc;

    private static String getString() {
        sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            return sc.nextLine();
        }

        return getString();
    }

    private static int findMaxOcurrenceCharacter(String source) {
        arrayCharacters = source.toCharArray();

        int max = arrayFrequent[0];
        int index = 0, indexMax = 0;
        for (char c : arrayCharacters) {
            index = (int)c;
            arrayFrequent[index]++;
            if (max < arrayFrequent[index]) {
                max = arrayFrequent[index];
                indexMax = index;
            }
        }

        System.out.println("Kí tự xuất hiên nhiều nhất là: " + (char)indexMax + ", tần suất là: " + max);
        return max;
    }
    public static void main(String[] args) {
        System.out.println("Hay nhap vao 1 chuoi ki tu: ");
        String source = getString();
        findMaxOcurrenceCharacter(source);
    }
}