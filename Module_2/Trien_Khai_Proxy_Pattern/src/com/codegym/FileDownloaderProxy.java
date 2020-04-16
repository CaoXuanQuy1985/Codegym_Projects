package com.codegym;

public class FileDownloaderProxy implements Downloader {
    public void download() {
        FileDownloader fileDownloader = new FileDownloader();
        fileDownloader.download();
    }
}