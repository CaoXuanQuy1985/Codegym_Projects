package com.codegym;

public class Test {
    public static void main(String[] args) {
        System.out.println("BEGIN TESTING SINGLETON PATTERN");

        BookBorrower borrower1 = new BookBorrower();
        BookBorrower borrower2 = new BookBorrower();

        borrower1.borrowBook();
        System.out.println("BookBorrower1 asked to borrow the book");
        System.out.println("BookBorrower1 Author and Title: ");
        System.out.println(borrower1.getTitleAndAuthor());


        borrower2.borrowBook();
        System.out.println("BookBorrower2 asked to borrow the book");
        System.out.println("BookBorrower2 Author and Title: ");
        System.out.println(borrower2.getTitleAndAuthor());

        borrower1.returnBook();
        System.out.println("BookBorrower1 returned the book");

        borrower2.borrowBook();
        System.out.println("BookBorrower2 Author and Title: ");
        System.out.println(borrower2.getTitleAndAuthor());

        System.out.println("END TESTING SINGLETON PATTERN");
    }
}