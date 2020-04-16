package com.codegym;

public class DownloadClient {
    public static void main(String[] args) {
        FileDownloaderProxy proxy = new FileDownloaderProxy();
        proxy.download();
    }
}