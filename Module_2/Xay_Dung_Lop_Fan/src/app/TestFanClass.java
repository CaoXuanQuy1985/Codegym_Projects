package app;

public class TestFanClass {
    public static void main(String[] args){
        MyFan fan_1 = new MyFan(MyFan.FAST, true, 10, "yellow");
        MyFan fan_2 = new MyFan(MyFan.MEDIUM, false, 5, "blue");

        System.out.println("Information fan_1: \n");
        System.out.println(fan_1.toString());
        System.out.println("Information fan_2: \n");
        System.out.println(fan_2.toString());
    }
}