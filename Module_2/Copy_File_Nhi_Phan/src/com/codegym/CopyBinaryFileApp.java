package com.codegym;

import java.io.*;
import java.nio.file.*;

public class CopyBinaryFileApp {
    private static String path = "/root/Documents/Codegym_Projects/Module_2/Copy_File_Nhi_Phan/src/com/codegym/";
    private String sourceFile;
    private String targetFile;
    private File sourceFileObj;
    private File targetFileObj;

    private boolean checkExistFile(String sourceFile, String targetFile) {
        this.sourceFile = path + sourceFile;
        this.targetFile = path + targetFile;

        this.sourceFileObj = new File(this.sourceFile).getAbsoluteFile();
        this.targetFileObj = new File(this.targetFile).getAbsoluteFile();

        if (!this.sourceFileObj.exists()) {
            System.out.println("File nguồn không tồn tại !!!");
            return false;
        }

        if (targetFileObj.exists()) {
            System.out.println("File đích đã tồn tại !!!");
            return false;
        }

        try {
            this.targetFileObj.createNewFile();
        } catch (IOException ex) {
            System.err.println("IOException has been thrown");
        }

        return true;
    }

    public CopyBinaryFileApp(String sourceFile, String targetFile) {
        if (!checkExistFile(sourceFile, targetFile)) {
            return;
        }
    }

    private byte[] readFileUsingBuffer() {
        byte[] buffer = null;
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(sourceFileObj));
            buffer = new byte[in.available()];
            try {
                in.read(buffer);
            } finally {
                in.close();
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Source File is not exists !!!");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.err.println("IOException has been thrown");
            ex.printStackTrace();
        }

        return buffer;
    }

    private boolean writeFileUsingBuffer(byte[] buffer) {
        try {
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(targetFileObj));
            try {
                out.write(buffer);
            } finally {
                out.close();
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Target File is not found !!!");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return true;
    }

    public void copyFile() {
        byte[] buffer = readFileUsingBuffer();
        writeFileUsingBuffer(buffer);
    }

    public static String getStandardIO() throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        return stdin.readLine();
    }
}