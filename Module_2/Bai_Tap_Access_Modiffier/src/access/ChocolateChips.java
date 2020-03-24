package access;
import access.dessert.*;

public class ChocolateChips extends Cookie{
    public ChocolateChips() {
        System.out.println("Chocolate Construcotr");
    }
    public void chomp(){
        Cookie cookie = new Cookie();
        //cookie.bite();  Error can not call bite method() because bite() has package access modiffier
    }
    public static void main(String[] args) {
        ChocolateChips chocolate = new ChocolateChips();
        chocolate.chomp();
        chocolate.bite_2();
    }
}

