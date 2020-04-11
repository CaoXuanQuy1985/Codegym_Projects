package com.codegym;

import java.io.*;

public class AppClient {
    public static void main(String[] args) {
        try {
            System.out.println("Nhập tên file nguồn (File này phải tồn tại trong thư mục: SourceFile.txt)");
            String sourceFile = CopyBinaryFileApp.getStandardIO();
            System.out.println("Nhập tên file đích (File này phải chưa tồn tại trong thư mục)");
            String targetFile = CopyBinaryFileApp.getStandardIO();

            CopyBinaryFileApp copyApp = new CopyBinaryFileApp(sourceFile, targetFile);
            copyApp.copyFile();
        } catch (IOException ex) {
            System.err.println("IOException has been thrown");
        }
    }
}