package com.codegym;

import java.io.*;
import java.util.Scanner;

public class SumInFileApp {
    private static Scanner sc;
    private File file;

    public SumInFileApp(String filename) throws FileNotFoundException {
        this.file = new File(filename).getAbsoluteFile();
        sc = new Scanner(file);
    }

    public int sum() {
        int sum = 0;
        try {         
            BufferedReader in = new BufferedReader(new FileReader(this.file));
            String line = "";
            try {
                while ((line = in.readLine()) != null) {
                    sum += sc.nextInt();
                }
            } finally {
                in.close();
            }
        } catch (FileNotFoundException ex) {
            System.err.println("File is not found !!!");
            ex.printStackTrace();
        } catch (IOException ex2) {
            ex2.printStackTrace();
        } catch (Exception ex3) {
            ex3.printStackTrace();
        }

        return sum;
    }

    public void displayResult() {
        PrintWriter out = new PrintWriter(System.out, true);
        out.println(sum());
    }
}