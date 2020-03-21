package app;

public class SequencePrimeNumber {
    private static  int[] sieveErator = new int[100];
    private static  int[] result = new int[50];

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

    public static void showSequence(int[] arr){
        for (int num : arr){
            if (num < 100 && num != 0){
                System.out.print(num + ", ");
            }
        }

        System.out.println();
    }

    public static void main(String[] args){
        System.out.println("Showing prime number that less than 100:");
        genSieveErator();
        showSequence(result);
    }
}