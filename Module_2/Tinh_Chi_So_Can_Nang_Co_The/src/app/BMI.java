package app;
import java.util.Scanner;

public class BMI {
    private static Scanner sc;

    private static float getInput(){
        sc = new Scanner(System.in);

        if(sc.hasNextFloat()){
            return sc.nextFloat();
        }

        System.out.println("Format index is invalid, please try again !!!");
        return getInput();
    }

    public static void calBMI(){
        float weight = 0, height = 0, bmi = 0;
        System.out.println("Input your weight: ");
        weight = getInput();
        System.out.println("Input your height: ");
        height = getInput();

        bmi = (weight / (height * height));

        if (bmi < 18.5) {
            System.out.println("Underweight");
        }else{
            if(bmi < 25.0){
                System.out.println("Normal");
            }else{
                if (bmi < 30.0) {
                    System.out.println("Overweight");
                }else{
                    System.out.println("Obese");
                }
            }
        }
    }

    public static void main(String[] args){
        calBMI();
    }
}