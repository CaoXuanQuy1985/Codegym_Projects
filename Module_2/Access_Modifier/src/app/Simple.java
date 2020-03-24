package app;

class A {
    private int data = 40;

    private void msg() {
        System.out.println("Hello java");
    }
}

public class Simple {
    public static void main(String[] args) {
        A objA = new A();
        //System.out.println(objA.msg()); Compile Error due private modifier !!!
        //System.out.println(objA.data); Compile Error due private modifier !!!
    }
}