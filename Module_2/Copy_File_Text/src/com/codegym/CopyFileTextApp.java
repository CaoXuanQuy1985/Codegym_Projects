package com.codegym;

import java.io.*;

public class CopyFileTextApp {
    private static String path = "/root/Documents/Codegym_Projects/Module_2/Copy_File_Text/src/com/codegym/";
    private String sourceFile;
    private String targetFile;
    private File sourceFileObj;
    private File targetFileObj;

    private boolean checkExistFile(String sourceFile, String targetFile) {
        this.sourceFile = path + sourceFile;
        this.targetFile = path + targetFile;

        this.sourceFileObj = new File(this.sourceFile).getAbsoluteFile();
        this.targetFileObj = new File(this.targetFile).getAbsoluteFile();

        if (!sourceFileObj.exists()) {
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

    public CopyFileTextApp(String sourceFile, String targetFile) {
        if (!checkExistFile(sourceFile, targetFile)) {
            return;
        }
    }

    public void copyFile() {
        try {
            BufferedReader in = new BufferedReader(new FileReader(this.sourceFileObj));
            PrintWriter out = new PrintWriter(this.targetFileObj);

            String line;
            try {
                while ((line = in.readLine()) != null) {
                    out.println(line);
                }
            } finally {
                out.close();
                in.close();
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String getStandardIO() throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        return stdin.readLine();
    }
}