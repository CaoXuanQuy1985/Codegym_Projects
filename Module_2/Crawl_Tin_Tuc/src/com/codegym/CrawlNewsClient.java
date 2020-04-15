package com.codegym;

import java.io.*;

public class CrawlNewsClient {
    public static void main(String[] args) {
        CrawlNewsAppliation cwa = new CrawlNewsAppliation();
        String targetPath = "/root/Documents/Codegym_Projects/Module_2/Crawl_Danh_Sach_Bai_hat/src/com/codegym/HTML_Content.txt";
        System.out.println("Nhập địa chỉ website để tiến hành crawl tin túc url = ");
        String urlString = cwa.getURL();
        BufferedReader bf = cwa.readContentWebsite(urlString);

        cwa.writeContentWebsite(targetPath, bf);
        cwa.getListNews();
    }
}