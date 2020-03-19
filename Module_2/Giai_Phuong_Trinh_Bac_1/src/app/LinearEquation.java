package app;
import java.util.Scanner;

public class LinearEquation{
    private static Scanner sc;

    private static double getInput(){
        sc = new Scanner(System.in);

        if(sc.hasNextFloat()){
            return sc.nextFloat();
        }
        System.out.println("Invalid input data, please try again");

        return getInput();
    }

    public static void calculate(double a, double b, double c){
        if(a == 0){
            if((b + c) == 0){
                System.out.println("Phương trình có vô số nghiệm");
            }else{
                System.out.println("Phương trình vô nghiêm");
            }
        }else{
            System.out.println("Phương trình có 1 nghiệm duy nhất x = " + (-(b + c) / a));
        }
    }

    public static void main(String[] args){
        System.out.println("Hãy nhập hệ số a = ");
        double a = getInput();
        System.out.println("Hãy nhập hệ số b = ");
        double b = getInput();
        System.out.println("Hãy nhập hệ số c = ");
        double c = getInput();

        calculate(a, b, c);
    }
}