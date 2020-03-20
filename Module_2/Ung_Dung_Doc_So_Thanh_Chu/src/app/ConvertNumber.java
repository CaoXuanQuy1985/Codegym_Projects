package app;
import java.util.Scanner;

public class ConvertNumber {
    private static Scanner sc;

    private static final String TEEN_SUFFIX = "teen";
    private static final String HUNDRED_SUFFIX = "hundred";
    private static final String AND = "and";
    private static final String[] ONES = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final String[] TENS = {"zero", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static final String[] SPECIAL_TEEN = {"ten", "eleven", "twelve", "thirteen", null, "fifteen"};


    private static int getInput(){
        sc = new Scanner(System.in);
        int number = 0;

        if(sc.hasNextInt()){
            number = sc.nextInt();
            if((number < 0) || (number > 999)){
                System.out.println("out of ability !!!");
                return getInput();
            }else{
                return number;
            }
        }
        System.out.println("Number is not format correct, try again !!!");
        return getInput();
    }

    private static String read1Digit(int number){
        String result = "";
        switch(number){
            case 0:
                result = ONES[0];
                break;
            case 1:
                result = ONES[1];
                break;
            case 2:
                result = ONES[2];
                break;
            case 3:
                result = ONES[3];
                break;
            case 4:
                result = ONES[4];
                break;
            case 5:
                result = ONES[5];
                break;
            case 6:
                result = ONES[6];
                break;
            case 7:
                result = ONES[7];
                break;
            case 8:
                result = ONES[8];
                break;
            default:
                result = ONES[9];
                break;
        }

        return result;
    }

    private static String read2Digits(int number){
        String result = "";
        int div, frac;

        div = number / 10;
        frac = number % 10;

        if ((number >= 10) && (number <= 15) && (number != 14)){
            switch (number){
                case 10:
                        result = SPECIAL_TEEN[0];
                        break;
                case 11:
                        result = SPECIAL_TEEN[1];
                        break;
                case 12:
                        result = SPECIAL_TEEN[2];
                        break;
                case 13:
                        result = SPECIAL_TEEN[3];
                        break;
                default:
                        result = SPECIAL_TEEN[5];
                        break;
            }
        } else if (number == 14 || number <= 19) {
            result = ONES[frac] + TEEN_SUFFIX;
        } else {
            if (frac == 0){
                result = TENS[div];
            }else{
                result = TENS[div] + ONES[frac];
            }
        }

        return result;
    }

    private static String read3Digits(int number){
        String result = "";
        int[] digits = new int[3];
        int index = digits.length - 1;
        int div = number, frac = number % 10;

        do{
            digits[index--] = frac;
            div /= 10;
            frac = div % 10;
        }while(div > 0);

        if(digits[1] != 0 && digits[2] == 0){
            result = ONES[digits[0]] + " " + HUNDRED_SUFFIX + " " + AND + " " + TENS[digits[1]];
        } else if (digits[1] == 0 && digits[2] == 0){
            result = ONES[digits[0]] + " " + HUNDRED_SUFFIX;
        } else if(digits[1] == 0 && digits[2] != 0){
            result = ONES[digits[0]] + " " + HUNDRED_SUFFIX + " " + AND + " " + ONES[digits[2]];
        } else if (digits[1] == 1){
                 switch(digits[2]){
                     case 1:
                             result = ONES[digits[0]] + " " +  HUNDRED_SUFFIX + " " + AND + " " + SPECIAL_TEEN[1];
                             break;
                    case 2:
                             result = ONES[digits[0]] + " " + HUNDRED_SUFFIX + " " + AND + " " + SPECIAL_TEEN[2];
                             break;
                    case 3:
                             result = ONES[digits[0]] + " " + HUNDRED_SUFFIX + " " + AND + " " + SPECIAL_TEEN[3];
                             break;
                    case 5:
                             result = ONES[digits[0]] + " " + HUNDRED_SUFFIX + " " + AND + " " + SPECIAL_TEEN[5];
                             break;
                    case 4:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                             result = ONES[digits[0]] + " " + HUNDRED_SUFFIX + " " + AND + " " + ONES[digits[1]] + " " + TEEN_SUFFIX;
                             break;
                 }
        }
        else{
            result = ONES[digits[0]] + " " + HUNDRED_SUFFIX + " " + AND + " " + TENS[digits[1]] + " " + ONES[digits[2]];
        }

        return result;
    }
   
    private static int deterNumDigits(int number){
        int numDigits = 1;

        while((number = number / 10) != 0){
            numDigits++;
        }

        return numDigits;
    }
    public static void main(String[] args){
        System.out.println("Hãy nhập 1 số để chuyển thành chữ: ");
        int number = getInput();
        String result = "";
        
        switch(deterNumDigits(number)){
            case 1:
                    result = read1Digit(number);
                    break;
            case 2: 
                    result = read2Digits(number);
                    break;
            case 3:
                    result = read3Digits(number);
                    break;
        }

        System.out.println(result);
    }
}