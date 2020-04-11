package com.codegym;

import java.io.*;
import java.nio.file.*;

public class CopierLargeFile {
    private static byte[] readFileUsingBuffer(String sourcePath) {
        File sourceFile = new File(sourcePath).getAbsoluteFile();
        byte[] buffer = null;
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(sourceFile));
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

    private static boolean writeFileUsingBuffer(byte[] buffer,String targetPath) {
        File file = new File(targetPath).getAbsoluteFile();
        try {
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
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

    public static void copyLargeFileUsingBuffer(String sourcePath, String targetPath) {
        byte[] buffer = readFileUsingBuffer(sourcePath);
        writeFileUsingBuffer(buffer, targetPath);
    }

    public static void copyLargerFileUsingJava7Files(String sourcePathStr, String targetPathStr) {
        FileSystem system = FileSystems.getDefault();
        Path sourcePath = system.getPath(sourcePathStr);
        Path targetPath = system.getPath(targetPathStr);

        try {
            Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}