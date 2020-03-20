package app;
import java.util.Scanner;

public class PrimeNumber {
    private static Scanner sc;
    private static  int[] sieveErator = new int[10000];
    private static  int[] result = new int[10000];

    private static int getInput() {
        sc = new Scanner(System.in);

        if(sc.hasNextInt()){
            return sc.nextInt();
        }

        System.out.println("This is not a integer number, try again !!!");
        return getInput();
    }

    private static int[] genSieveErator(){
        for(int i = 2; i < sieveErator.length + 2; i++){
            sieveErator[i - 2] = i;
        }

        for(int i =0; i < sieveErator.length; i++){
            if(sieveErator[i] == -1){
                continue;
            }
            for(int j = i + 1; j < sieveErator.length; j++){
                if(sieveErator[j] % sieveErator[i] == 0){
                    sieveErator[j] = -1;
                }
            }
        }

        int index = 0;
        for(int i = 0; i < sieveErator.length; i++){
            if(sieveErator[i] != -1){
                result[index++] = sieveErator[i];
            }
        }

        return result;
    }

    public static boolean checkPrime(int number){
        genSieveErator();
        for(int elem : result){
            if(elem == number)
                return true;
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println("Input a number to check prime");
        int number = getInput();
        boolean result = checkPrime(number);
        if(result)
            System.out.println(number + " is a prime number");
        else
            System.out.println(number + " is NOT a prime number");
    }
}