package app;

import java.util.Scanner;

public class Concurrency {
    private static final float RATE = 23000;
    private static Scanner sc;

    private static float getInput(){
        sc = new Scanner(System.in);

        if(sc.hasNextFloat()){
            return sc.nextFloat();
        }

        System.out.println("Format's currency is invalid, please try again !");
        return getInput();
    }

    public static float exchToVND(float usd){
        return usd * RATE;
    }

    public static void main(String[] args){
        System.out.println("Hãy nhập vào số USD để chuyển đổi thành tiền VND:");
        float usd = getInput();

        System.out.println("Số tiền VND tương ứng là: " + exchToVND(usd) + " VND");
    }
}