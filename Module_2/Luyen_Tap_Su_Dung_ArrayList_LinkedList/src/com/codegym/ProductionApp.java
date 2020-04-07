package com.codegym;

public class ProductionApp {
    public static void main(String[] args) {
        Production vinaMilk = new Milk("Vinamilk", 3.5);
        Production sugarVietnam = new Sugar("Sugar Viet Nam", 1.5);
        Production riceDienBien = new Rice("Rice Dien Bien", 5.3);
        Production hollandMilk = new Milk("Holland Milk", 7.6);
        Production sugarSingapore = new Sugar("Sugar Singapore", 2.5);
        Production riceEigth = new Rice("Rice Eight", 5.9);
        Production vinaMilk2 = new Milk("Vinamilk2", 1.8);
        Production sugarVietnam2 = new Sugar("Sugar Viet Nam2", 15.9);
        Production riceDienBien2 = new Rice("Rice Dien Bien2", 12.2);
        Production vinaMilk3 = new Milk("Vinamilk3", 8.5);
        Production sugarVietnam4 = new Sugar("Sugar Viet Nam 4", 10);
        Production riceDienBien4 = new Rice("Rice Dien Bien4", 11.7);

        ProductionDatabase<Production> database = new ProductionDatabase<Production>();
        System.out.println("Thực hiện thao tác thêm Item:");
        database.addItem(vinaMilk);
        database.addItem(sugarVietnam);
        database.addItem(riceDienBien);

        System.out.println("Sau khi thêm sản phẩm vào cơ sở dữ liệu, database có chứa các sản phẩm sau: ");
        database.displayStorageProduct();

        System.out.println("Sửa lại thông tin cho sản phẩm: ");
        database.editInformation(2, "Sugar American", 12.8);
        database.editInformation(3, "Rice Tam Thai", 9);
        database.displayStorageProduct();

        System.out.println("Xóa sản phẩm theo id: ");
        database.removeProduction(1);
        database.displayStorageProduct();

        System.out.println("Tìm sản phẩm theo tên: ");
        System.out.println(database.findProductByName("Sugar American2"));

        database.addItem(vinaMilk);
        database.addItem(sugarVietnam);
        database.addItem(riceDienBien);
        database.addItem(hollandMilk);
        database.addItem(sugarSingapore);
        database.addItem(riceEigth);
        database.addItem(vinaMilk2);
        database.addItem(sugarVietnam2);
        database.addItem(riceDienBien2);
        database.addItem(vinaMilk3);
        database.addItem(sugarVietnam4);
        database.addItem(riceDienBien4);

        System.out.println("List chưa được sắp xếp: ");
        database.displayStorageProduct();

        System.out.println("Sắp xếp sản phẩm theo giá tăng dần: ");
        database.sortPriceAscending();
        database.displayStorageProduct();

        System.out.println("Sắp xếp sản phẩm theo giá giảm dần: ");
        database.sortPriceDescending();
        database.displayStorageProduct();
    }
}