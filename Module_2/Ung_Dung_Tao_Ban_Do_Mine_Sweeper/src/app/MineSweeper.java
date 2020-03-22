package app;
import java.util.Arrays;
import java.util.Scanner;

public class MineSweeper {
    private static Scanner sc;
    private static int[][] arr2dim;

    private static int getInput() {
        sc = new Scanner(System.in);

        if(sc.hasNextInt()){
            return sc.nextInt();
        }

        System.out.print("Integer is not valid, try again");
        return getInput();
    }

    private static int sweepMine(int[][] arr2dim, int xPosItem, int yPosItem) {
        int countMine = 0;
        int numRow = arr2dim.length;
        int numCol = arr2dim[0].length;
        
        if (arr2dim[xPosItem][yPosItem] == -1) {
            return -1;
        } else {
            if ((!checkDown(xPosItem, yPosItem, numRow, numCol)) && (arr2dim[xPosItem + 1][yPosItem] == -1)) {
                countMine++;
            }
            if ((!checkForward(xPosItem, yPosItem, numRow, numCol)) && (arr2dim[xPosItem][yPosItem + 1] == -1)){
               countMine++;
            }
            if ((!checkBackward(xPosItem, yPosItem, numRow, numCol)) && (arr2dim[xPosItem][yPosItem - 1] == -1)){
                countMine++;
            }
            if ((!checkUp(xPosItem, yPosItem, numRow, numCol)) && (arr2dim[xPosItem - 1][yPosItem] == -1)){
                countMine++;
            }
            if ( (!checkDown(xPosItem, yPosItem, numRow, numCol)) && (!checkForward(xPosItem, yPosItem, numRow, numCol)) && arr2dim[xPosItem + 1][yPosItem + 1] == -1){
                countMine++;
            }
            if ((!checkUp(xPosItem, yPosItem, numRow, numCol)) && (!checkBackward(xPosItem, yPosItem, numRow, numCol)) && arr2dim[xPosItem - 1][yPosItem - 1] == -1){
                countMine++;
            }
            if ((!checkUp(xPosItem, yPosItem, numRow, numCol)) && (!checkForward(xPosItem, yPosItem, numRow, numCol)) && arr2dim[xPosItem - 1][yPosItem + 1] == -1){
                countMine++;
            }
            if ((!checkDown(xPosItem, yPosItem, numRow, numCol)) && (!checkBackward(xPosItem, yPosItem, numRow, numCol)) && arr2dim[xPosItem + 1][yPosItem - 1] == -1){
                countMine++;
            }
        }

        return countMine;
    }

    private static boolean checkForward(int xPos, int yPos, int numRow, int numCol) {
        return (yPos + 1 == numCol) ? true : false;
    }

    private static boolean checkBackward(int xPos, int yPos, int numRow, int numCol) {
        return (yPos - 1 < 0) ? true : false;
    }

    private static boolean checkDown(int xPos, int yPos, int numRow, int numCol) {
        return (xPos + 1 == numRow) ? true : false;
    }

    private static boolean checkUp(int xPos, int yPos, int numRow, int numCol) {
        return (xPos - 1 < 0) ? true : false;
    }

    public static int[][] createCompletedMapMine(int[][] mapmine) {
        for (int i = 0; i < mapmine.length; i++) {
            for (int j = 0; j < mapmine[i].length; j++) {
                mapmine[i][j] = sweepMine(mapmine, i, j);
            }
        }

        System.out.println("Ban do MapMine sau khi xac dinh co hinh dang nhu sau: ");
        showArr2Dim(mapmine);

        return mapmine;
    }

    public static int[][] createMapMine() {
        System.out.println("Nhập so hàng mảng 2 chieu: ");
        int numRow = getInput();
        System.out.println("Nhập so cột mảng 2 chieu: ");
        int numCol = getInput();

        arr2dim = new int[numRow][numCol];
        System.out.println("Chu y: gia tri -1 se duoc coi nhu la gia tri qua boom ");
        System.out.println("Hướng dẫn cách tạo bản đô: Bạn hãy nhập giá trị -1 tại những vị trí phần tử mà bạn muốn đặt boom ở đấy\n ngược lại những vị trí không có boom hãy nhập số 0 vào: ");
        for(int i = 0; i < arr2dim.length; i++){
            for(int j = 0; j < arr2dim[i].length; j++) {
                System.out.println("Nhap gia tri phan tu MapMine tai vi tri[" + i + "]" + "[" + j + "]");
                arr2dim[i][j] = getInput();
            }
        }

        System.out.println("Ban do MapMine ban vua tao ra co hinh dang nhu sau: ");
        showArr2Dim(arr2dim);
        return arr2dim;
    }

    private static void showArr2Dim(int[][] arr2dim) {
        for (int i = 0; i < arr2dim.length; i++) {
            for (int j = 0; j < arr2dim[i].length; j++) {
                System.out.print(arr2dim[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        //You an use this test Array to test
        //Chu y: gia tri -1 se duoc coi nhu la gia tri qua boom 
        int[][] test = {
            {0, -1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, -1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, -1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, -1, 0},
        };
        int[][] test2 = {
            {0, 0, 0, -1},
            {0, 0, 0, -1},
            {0, -1, 0, 0}
        };
        int[][] test3 = {
            {0, 0, -1},
            {0, -1, 0},
        };
        //createCompletedMapMine(test);
        //createCompletedMapMine(test2);

        // Or you can input mapMine from command dos:
        createCompletedMapMine(createMapMine());
    }
}