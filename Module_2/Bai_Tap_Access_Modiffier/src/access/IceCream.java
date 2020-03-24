package access;

class Sundea {
    private Sundea(){}

    public static Sundea makeSundea(){
        return new Sundea();
    }
}

public class IceCream {
    public static void main(String[] args) {
        //Sundea sundea = new Sundea(); Error can not instance object by call the constructor because consturctor is private
        Sundea objSundea = Sundea.makeSundea(); // It is ok
    }
}