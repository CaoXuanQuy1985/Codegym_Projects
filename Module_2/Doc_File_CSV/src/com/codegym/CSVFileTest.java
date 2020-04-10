package com.codegym;

public class CSVFileTest {
    public static void main(String[] args) {
        ReaderCSVFile reader = new ReaderCSVFile();
        String sourceFile = "/root/Documents/Codegym_Projects/Module_2/Doc_File_CSV/src/com/codegym/CodeNational.csv";
        reader.read(sourceFile);
        reader.write("/root/Documents/Codegym_Projects/Module_2/Doc_File_CSV/src/com/codegym/National.csv");
    }
}