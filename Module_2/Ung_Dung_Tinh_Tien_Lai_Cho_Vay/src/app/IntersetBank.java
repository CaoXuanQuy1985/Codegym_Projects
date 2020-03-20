package app;
import java.util.Scanner;

public class IntersetBank {
    private static Scanner sc;

    private static float getInput(){
        sc = new Scanner(System.in);

        if (sc.hasNextFloat()){
            return sc.nextFloat();
        }

        System.out.println("This is invalid format, please try again !!!");

        return getInput();
    }

    public static float calTotalInterset(float month, float money, float intersetRate){
        float totalInterset = 0;

        for(int i = 0; i < month; i++){
            totalInterset += money * (intersetRate / 100) / 12;
        }

        return totalInterset;
    }
    
    public static void main(String[] args){
        System.out.println("Nhap vao month = ");
        float month = getInput();
        System.out.println("Nhap vao money = ");
        float money = getInput();
        System.out.println("Nhap vao intersetRate = ");
        float intersetRate = getInput();

        System.out.println("So tien lai trong " + month + " thang la: " + calTotalInterset(month, money, intersetRate));
    }
}