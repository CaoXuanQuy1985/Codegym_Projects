package com.codegym;

public class ConvertTest {
    public static void main(String[] args) {
        ConvertorDecimalToBinary convertor = new ConvertorDecimalToBinary();

        System.out.println("Hẫy nhập 1 số thập phân để chuyển sang hệ nhị phân: ");
        int numberDecimal = convertor.getDecimal();
        convertor.convertToBinary(numberDecimal);
        convertor.showResult();
    }
}