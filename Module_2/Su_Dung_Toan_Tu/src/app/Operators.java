package app;
import java.util.Scanner;

public class Operators{
    private static Scanner sc;

    private float readData(){
        sc = new Scanner(System.in);

        if(sc.hasNextFloat()){
            return sc.nextFloat();
        }

        System.out.println("Invalid input data !!!");
        
        return readData();
    }
    public float calArea(float width, float height){
        return width * height;
    }

    public static void main(String[] args){
        Operators obj = new Operators();
        System.out.println("Input Width value = ");
        float width = obj.readData();
        System.out.println("Input Height value = ");
        float height = obj.readData();

        System.out.println("Area of Rectangle is: " + obj.calArea(width, height));
    }
}