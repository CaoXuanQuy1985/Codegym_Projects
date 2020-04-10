package com.codegym;

import java.io.FileNotFoundException;
import java.io.*;

public class AppTest {
    public static void main(String[] args) throws FileNotFoundException {
        SumInFileApp app = new SumInFileApp("/root/Documents/Codegym_Projects/Module_2/Tinh_Tong_Cac_So_Trong_File_Text/src/com/codegym/numbers.txt");
        app.displayResult();
    }
}