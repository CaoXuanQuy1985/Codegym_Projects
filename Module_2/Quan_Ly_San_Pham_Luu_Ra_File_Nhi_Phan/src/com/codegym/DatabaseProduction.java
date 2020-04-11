package com.codegym;

import java.util.*;
import java.io.*;

public class DatabaseProduction<T extends Production> {
    private LinkedList<T> storageProduction;
    private String storagePathBinary = "/root/Documents/Codegym_Projects/Module_2/Quan_Ly_San_Pham_Luu_Ra_File_Nhi_Phan/src/com/codegym/ProductionStorageBinaryData.txt";
    private String storagePathFormatText = "/root/Documents/Codegym_Projects/Module_2/Quan_Ly_San_Pham_Luu_Ra_File_Nhi_Phan/src/com/codegym/ProductionStorage.txt";

    public DatabaseProduction() {
        this.storageProduction = new LinkedList<T>();
    }

    public boolean add(T item) {
        String sourceBinaryPath = "/root/Documents/Codegym_Projects/Module_2/Quan_Ly_San_Pham_Luu_Ra_File_Nhi_Phan/src/com/codegym/ProductionStorageBinaryData.txt";
        boolean result = this.storageProduction.add(item);
        writeToFileBinary();
        writeToFileFormat(sourceBinaryPath);

        return result;
    }

    private void writeToFileBinary() {
        File file = new File(storagePathBinary).getAbsoluteFile();
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            try {
                for (T item : this.storageProduction) {
                    out.writeObject(item);
                }
            } finally {
                out.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void writeToFileFormat(String targetPath) {
        File file = new File(targetPath).getAbsoluteFile();
        String sourceFormatPath = "/root/Documents/Codegym_Projects/Module_2/Quan_Ly_San_Pham_Luu_Ra_File_Nhi_Phan/src/com/codegym/ProductionStorage.txt";
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            PrintWriter out = new PrintWriter(sourceFormatPath);
            try {
                out.format("%70s\n", "DANH SÁCH SẢN PHẨM");
                out.format("%5s %20s %20s %20s %10s %15s", "Id", "Tên Sản Phẩm", "Mã Sản Phẩm", "Hãng Sản Xuất", "Giá",
                        "Số Lượng\n");
                out.format(
                        "----------------------------------------------------------------------------------------------------------------------\n");
                for (int i = 0; i < this.storageProduction.size(); i++) {
                    Production production = (Production) in.readObject();
                    out.format("%5s", production.getId());
                    out.format("%20s", production.getName());
                    out.format("%30s", production.getCode());
                    out.format("%25s", production.getOriginal());
                    out.format("%17s", production.getPrice());
                    out.format("%15s\n", production.getQuantity());
                }
                out.format(
                        "----------------------------------------------------------------------------------------------------------------------");
            } finally {
                out.close();
                in.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public boolean findProduct(String name) {
        String resultPath = "/root/Documents/Codegym_Projects/Module_2/Quan_Ly_San_Pham_Luu_Ra_File_Nhi_Phan/src/com/codegym/ProductionExtractTable.txt";
        ByteArrayOutputStream bount = new ByteArrayOutputStream();
        try {
            ObjectOutputStream out = new ObjectOutputStream(bount);
            ObjectInputStream in = null;
            PrintWriter out2 = new PrintWriter(new File(resultPath).getAbsoluteFile());
            try {
                for (T item : this.storageProduction) {
                    if (item.getName().equals(name)) {
                        out.writeObject(item);
                        in = new ObjectInputStream(new ByteArrayInputStream(bount.toByteArray()));
                        
                        Production production = (Production) in.readObject();

                        out2.format("%70s\n", "KẾT QUẢ TÌM KIẾM");
                        out2.format("%5s %20s %20s %20s %10s %15s", "Id", "Tên Sản Phẩm", "Mã Sản Phẩm",
                                "Hãng Sản Xuất", "Giá", "Số Lượng\n");
                        out2.format(
                                "----------------------------------------------------------------------------------------------------------------------\n");
                        out2.format("%5s", production.getId());
                        out2.format("%20s", production.getName());
                        out2.format("%30s", production.getCode());
                        out2.format("%25s", production.getOriginal());
                        out2.format("%17s", production.getPrice());
                        out2.format("%15s\n", production.getQuantity());
                        out2.format(
                                "----------------------------------------------------------------------------------------------------------------------\n");

                        return true;
                    }
                }
                out2.format("%20s", "Sản phẩm bạn tìm kiếm không có trong danh sách sản phẩm !!!");
                return false;

            } finally {
                out.close();
                if (in != null){
                    in.close();
                }
                out2.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return false;
    }
}