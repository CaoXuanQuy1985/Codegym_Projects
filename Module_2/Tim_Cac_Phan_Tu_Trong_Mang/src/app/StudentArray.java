package app;
import java.util.Scanner;

class StudentArray {
    private static final String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
    private static Scanner sc;

    private static String getInput() {
        sc = new Scanner(System.in);
        System.out.println("Hay nhập vào tên sinh viên để tìm kiếm: ");

        if (sc.hasNextLine()) {
            return sc.nextLine();
        }

        System.out.println("This student is not exist, try with another student");
        return getInput();
    }

    public static int checkExist(String nameStudent) {
        for (int i = 0; i < students.length; i++) {
            if (nameStudent.equals(students[i])) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String name = getInput();
        String result = "";
        int index = checkExist(name);

        result = (index != -1) ? "Vị trí của sinh vien " + name + " là: " + index : "Sinh viên này không tồn tại trong mảng"; 
        System.out.println(result);
    }
}