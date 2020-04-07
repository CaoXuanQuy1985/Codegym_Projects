package com.codegym;

import java.lang.Math;

public class ConsequenceString {
    String result = "";
    int maxLength = 0;
    int maxIndex = 0;
    int length = 1;
    int index = 0;
    static char[] arrayChar;

    private int recursion(int startSequence) {
        if (index > arrayChar.length - 2) {
            System.out.println("Chuỗi liên tiếp có chiều dài lớn nhất = " + maxLength + " có vị trí tại index = " + maxIndex);
            System.out.print("Chuỗi đó là: ");
            for (int i = 1; i <= maxLength; i++) {
                result += arrayChar[maxIndex++];
            }
            System.out.println(result);
            return index;
        }
        while ((index < arrayChar.length - 1) && ((int)arrayChar[index + 1] >= (int)arrayChar[index])) {
            length++;
            if (maxLength < length) {
                maxLength = length;
                maxIndex = Math.abs(length - index - 2);
            }
            index++;
        } 
        length = 1;
        index++;
        return recursion(index);
    }

    public void findMaxLength(String source) {
        arrayChar = source.toCharArray();  
        recursion(index); 
    }
}