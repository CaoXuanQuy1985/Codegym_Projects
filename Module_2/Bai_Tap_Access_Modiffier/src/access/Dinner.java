package access;
import access.dessert.*;

public class Dinner {
    public static void main(String[] args) {
        Cookie cookie = new Cookie();
        //cookie.bite();  Error compile since method bite() has package access modifier !!!
    }
}