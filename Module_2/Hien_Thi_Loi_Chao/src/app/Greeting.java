package app;
import java.util.Scanner;

public class Greeting {
    private static Scanner sc;

    public String sayHello(){
        sc = new Scanner(System.in);
        System.out.println("Input your name");

        if (sc.hasNextLine()){
            return "Hello " + sc.nextLine();
        }
        System.out.println("This name is not valid format, try again !!!");
        return sayHello();
    }
    public static void main(String[] args){
        Greeting obj = new Greeting();
        System.out.println(obj.sayHello());
    }
}