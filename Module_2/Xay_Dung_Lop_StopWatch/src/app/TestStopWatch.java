package app;

public class TestStopWatch {
    public static void main(String[] args) {
        System.out.println("Bạn có thể khởi tạo đối tượng mặc đinh với chiều dài mảng là 100.000 phần tử");
        //StopWatch sw = new StopWatch();
        //sw.showArray();

        System.out.println("Hoặc bạn cũng có thê khởi tạo đối tượng với chiều dìa mảng bất kì như sau:");
        StopWatch sw2 = new StopWatch(100);
        sw2.showArray();
    }
}