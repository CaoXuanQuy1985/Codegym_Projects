package com.codegym;

import java.util.Scanner;
import java.io.*;
import java.net.*;
import java.util.regex.*;
import java.util.*;

public class CrawlWebsiteAppliation {
    private static Scanner sc;

    public String getURL() {
        sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            return sc.nextLine();
        }
        return getURL();
    }

    public BufferedReader readContentWebsite(String urlString) {
        BufferedReader in = null;
        try {
            URL url = new URL(urlString);
            in = new BufferedReader(new InputStreamReader(url.openStream()));
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return in;
    }

    public void writeContentWebsite(String targetPath, BufferedReader bf) {
        PrintWriter out = null;
        String line = "";
        File file = new File(targetPath).getAbsoluteFile();
        try {
            try {
                out = new PrintWriter(file);
                while ((line = bf.readLine()) != null) {
                    out.println(line);
                }
            } finally {
                out.close();
                bf.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void getListSongs() {
        String sourcePath = "/root/Documents/Codegym_Projects/Module_2/Crawl_Danh_Sach_Bai_hat/src/com/codegym/HTML_Content.txt";
        String regex = "\"name_song\" title=\"(.*?) -";
        StringBuilder sb = new StringBuilder();
        File file = new File(sourcePath).getAbsoluteFile();
        BufferedReader in = null;
        try {
            try {
                String line;
                in = new BufferedReader(new FileReader(file));
                while ((line = in.readLine()) != null) {
                    sb.append(line);
                }
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(sb.toString());

                LinkedList<String> list = new LinkedList<>();
                while (matcher.find()) {
                    list.add(matcher.group(1));
                }
                display(list);
            } finally {
                in.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void display(LinkedList<String> list) {
        String targetPath = "/root/Documents/Codegym_Projects/Module_2/Crawl_Danh_Sach_Bai_hat/src/com/codegym/ListSongs.txt";
        PrintWriter out = null;
        try {
            try {
                out = new PrintWriter(new File(targetPath).getAbsoluteFile());
                String line;
                int count = 0;

                out.println("Danh Sách Bài Hát");
                out.println("-------------------------");
                while ((line = list.pollFirst()) != null) {
                    count++;
                    out.println(count + ": " + line);
                }
                out.println("-------------------------");
                System.out.println("Done");
            } finally {
                out.close();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}