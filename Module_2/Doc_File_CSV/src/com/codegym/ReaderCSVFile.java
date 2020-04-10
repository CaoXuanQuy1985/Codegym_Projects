package com.codegym;

import java.util.*;
import java.io.*;

public class ReaderCSVFile extends ArrayList<String> {
    public void read(String filename) {
        File file = new File(filename).getAbsoluteFile();
        if (!file.exists()) {
            System.err.println("File is not exist !!!");
            System.exit(1);
        }

        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            try {
                String line;
                while ((line = in.readLine()) != null) {
                    String[] arrayString = line.split(",");
                    this.add(arrayString[arrayString.length - 1]);
                }
            } finally {
                in.close();
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void write(String filename) {
        File file = new File(filename).getAbsoluteFile();
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            PrintWriter out = new PrintWriter(file);
            try {
                for (String national : this) {
                    String nameCountry = national.substring(1, national.length() - 1);
                    out.println(nameCountry);
                }
            } finally {
                out.close();
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}