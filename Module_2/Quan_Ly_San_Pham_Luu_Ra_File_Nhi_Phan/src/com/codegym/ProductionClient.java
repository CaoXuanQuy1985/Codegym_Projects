package com.codegym;

public class ProductionClient {
    public static void main(String[] args) throws Exception {
        DatabaseProduction<Production> database = new DatabaseProduction<Production>();

        System.out.println("Mô tả chương trình: ");
        System.out.println("Chương trình sử dụng các lớp trong thư viện IO cụ thê: ObjectOutputStream, ObjectinputStream " +
        " Kết hợp với thực thi interface Serializable để tạo và luu các đối tượng sản phẩm vào file nhị phân sử dụng cách xử lý với các byte nhị phân để tăng tốc độ xử lý");
        System.out.println("Chương trình có 2 file rỗng, ProductionStorage file thể hiện các sản phẩm hiện có trong cơ sỏ dữ liệu" +
        " ProductionExtractTable file thể hiện những san phẩm mà user tìm kiếm nếu có sản phẩm sẽ xuất hiện trong file này");
        System.out.println("Đầu tiên file Sản phẩm trống nên ta sẽ nhập vài sản phẩm với câu lênh add() sau đó kiểm tra lại file sản phẩm" +
        "Bạn sẽ thấy  danh sách sản phẩm lần lượt xuất hiện trong file ");
        Milk milk1 = new Milk("Milk1", "M001", "VIet Nam", 1.5, 10);
        Milk milk2 = new Milk("Milk2", "M002", "VIet Nam", 1.8, 20);
        Milk milk3 = new Milk("Milk3", "M003", "VIet Nam", 3.4, 50);
        Coffee coffe1 = new Coffee("Coofee1", "C001", "China", 7, 15);
        Coffee coffe2 = new Coffee("Coofee2", "C002", "China", 4, 25);
        Coffee coffe3 = new Coffee("Coofee3", "C003", "China", 9.3, 18);
        Coffee coffe4 = new Coffee("Coofee4", "C004", "China", 7, 20);
        Sugar sugar1 = new Sugar("Sugar1", "S001", "American", 2, 15);
        Sugar sugar2 = new Sugar("Sugar2", "S002", "American", 9, 15);

        database.add(milk1);
        database.add(milk2);
        database.add(milk3);
        database.add(coffe1);
        database.add(coffe2);
        database.add(coffe3);
        database.add(coffe4);
        database.add(sugar1);
        database.add(sugar2);

        System.out.println("Hãy kiểm tra file ProductionStorage.txt để kiểm tra chương trình hoạt động chính xác");
        
        System.out.println("Sau khi đã có các sản phẩm tồn tại trong database giờ ta sẽ thực hiện phép sử lý tìm kiếm để tìm kiếm sản phẩm theo tên" + 
        ", nếu có bạn hãy kiểm tra file Resutl để xem sản phẩm tìm kiếm xuất hiện trong file đó");

        database.findProduct("Milk2");
        System.out.println("Hãy kiểm tra file ProductionẼtractTable.txt để kiểm tra sản phẩm đã được tìm ra được ghi vào file đó");
        database.findProduct("Coofee2");
        System.out.println("Hãy kiểm tra file ProductionẼtractTable.txt để kiểm tra sản phẩm đã được tìm ra được ghi vào file đó");
    }
}