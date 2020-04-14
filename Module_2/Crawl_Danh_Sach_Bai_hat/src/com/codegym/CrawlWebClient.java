package com.codegym;

import java.io.*;

public class CrawlWebClient {
    public static void main(String[] args) {
        CrawlWebsiteAppliation cwa = new CrawlWebsiteAppliation();
        String targetPath = "/root/Documents/Codegym_Projects/Module_2/Crawl_Danh_Sach_Bai_hat/src/com/codegym/HTML_Content.txt";
        System.out.println("Nhập địa chỉ website để tiến hành crawl danh sách bài hát url = ");
        String urlString = cwa.getURL();
        BufferedReader bf = cwa.readContentWebsite(urlString);

        cwa.writeContentWebsite(targetPath, bf);
        cwa.getListSongs();
    }
}