package com.codegym;

import java.io.*;
import java.net.*;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FileDownloader implements Downloader {
    private String url = "http://ipv4.download.thinkbroadband.com/5MB.zip";
    private String dest = "/root/Documents/Codegym_Projects/Module_2/Trien_Khai_Proxy_Pattern/src/com/codegym/DownloadedFile.zip";
    private String userAgent;

    public FileDownloader() {
        userAgent = "Mozilla/5.0 Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11";
    }

    public void download() {
        try {
            URLConnection urlConnection = new URL(url).openConnection();
            urlConnection.setRequestProperty("User-Agent", this.userAgent);
            urlConnection.setUseCaches(false);
            urlConnection.connect();
            Files.copy(urlConnection.getInputStream(), Paths.get(dest));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}