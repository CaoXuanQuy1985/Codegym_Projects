package access.dessert;

public class Cookie {
    public Cookie(){
        System.out.println("Cookie constructor");
    }
    void bite() {
        System.out.println("method bite() has package access modifier");
    }
    protected void bite_2(){
        System.out.println("method bite(2) has protected access modifier");
    }
}