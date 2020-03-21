package app;
import java.util.InputMismatchException;
import java.util.Scanner;

class MyArray {
    private static Scanner sc;

    private static <T> T getInputValue(Class<T> classObj) throws Exception {
        sc = new Scanner(System.in);
        T input = null;

        try {
            if(classObj == Integer.class) {
                input = (T) classObj.cast(Integer.valueOf(sc.nextInt()));
            } else if (classObj == Float.class) {
                input = (T) classObj.cast(Float.valueOf(sc.nextFloat()));
            } else if (classObj == Double.class) {
                input = (T) classObj.cast(Double.valueOf(sc.nextDouble()));
            } else if (classObj == Long.class) {
                input = (T) classObj.cast(Long.valueOf(sc.nextLong()));
            } else if (classObj == String.class) {
                input = (T) classObj.cast(String.valueOf(sc.next()));
            }
        } catch (InputMismatchException ex) {
            throw new Exception(ex);
        }

        return input;
    }

    @SuppressWarnings("unchecked")
    private static <T> T[] getInputChoice() throws Exception {
        String type = "";
        T[] resultArray = null;

        System.out.println("Hãy nhập kiểu của các phần tử mà mảng lưu giữ: \n \"String\", \"int\", \"long\", \"float\", \"double\": ");
        sc = new Scanner(System.in);

        if(sc.hasNext()) {
            type = sc.next();
            if (type.equals("String")) {
                System.out.println("Hãy nhập chiều dài của mảng có kiểu chuỗi: ");
                resultArray = (T[]) processChoice(String.class);
            } else if (type.equals("int")) {
                System.out.println("Hãy nhập chiều dài của mảng có kiểu int: ");
                resultArray = (T[]) processChoice(Integer.class);
            } else if (type.equals("long")) {
                System.out.println("Hãy nhập chiều dài của mảng có kiểu long: ");
                resultArray = (T[]) processChoice(Long.class);
            } else if (type.equals("float")) {
                System.out.println("Hãy nhập chiều dài của mảng có kiểu long: ");
                resultArray = (T[]) processChoice(Float.class);
            } else if (type.equals("double")) {
                System.out.println("Hãy nhập chiều dài của mảng có kiểu long: ");
                resultArray = (T[]) processChoice(Double.class);
            }
        }

        return resultArray;
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] reverseArray(T[] originalArray) {
        T[] resultArray = (T[])new Object[originalArray.length];

        int index = 0;
        for(int i = resultArray.length - 1; i >= 0; i--) {
            resultArray[index++] = originalArray[i];
        }

        System.out.println("Mảng ban đầu:");
        showArray(originalArray);

        System.out.println("Mảng sau khi đảo ngược:");
        showArray(resultArray);

        return resultArray;
    }

    private static <T> void showArray(T[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.print(array[i]);
            }
        }
        System.out.println("]");
    }

    @SuppressWarnings("unchecked")
    private static <T> T[] processChoice(Class<T> classObj) throws Exception {
        T[] resultArray = null;
        if (sc.hasNextInt()) {
            int lenArr = 0;
            lenArr = sc.nextInt();
            resultArray = (T[]) new Object[lenArr];
            System.out.println("OK !!! chúng ta đã có kiểu và chiều dài của mảng, giờ bạn hãy nhập vào từng phần tử để thực hiện việc đảo ngược mảng: ");
            try {
                for (int i = 0; i < lenArr; ++i) {
                    resultArray[i] = (T) getInputValue(classObj);
                }
            } catch (Exception ex) {
                System.out.println("Bạn đã nhập sai kiểu dữ liệu của mảng mà bạn đã chọn rồi !!!");
            }
        }

        return resultArray;
    }

    public static void main(String[] args) throws Exception{
        try {
            reverseArray(getInputChoice());
        } catch (Exception ex) {
            System.out.println("Bạn đã nhập sai kiểu dữ liệu của mảng mà bạn đã chọn rồi, hãy chọn lại nhé !!!");
            reverseArray(getInputChoice());
        }
    }
}