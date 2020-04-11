package com.codegym;

import java.io.*;

public class CopierLargeFileClient {
    public static void main(String[] args) {
        String sourcePath = "/root/Documents/Codegym_Projects/Module_2/Copy_File_Co_Dung_Luong_Lon/src/com/codegym/SourceFile.zip";
        String targetPath = "/root/Documents/Codegym_Projects/Module_2/Copy_File_Co_Dung_Luong_Lon/src/com/codegym/TargetFile.zip";
        String targetPath2 = "/root/Documents/Codegym_Projects/Module_2/Copy_File_Co_Dung_Luong_Lon/src/com/codegym/TargetFile_2.zip";

        CopierLargeFile.copyLargeFileUsingBuffer(sourcePath, targetPath);
        CopierLargeFile.copyLargerFileUsingJava7Files(sourcePath, targetPath2);
    }
}