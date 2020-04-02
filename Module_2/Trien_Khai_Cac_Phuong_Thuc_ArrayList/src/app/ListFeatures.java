package app;

import java.util.*;
import typeinfo.pets.*;

public class ListFeatures {
    public static void main(String[] args) {
        Random rand = new Random(47);

        List<Pet> pets = Pets.arrayList(7);
        System.out.println("1. " + pets);
        Hamster h = new Hamster();
        pets.add(h);
        System.out.println("2. " + pets);
        System.out.println("3. pets.contains(h): " + pets.contains(h));
        pets.remove(h);
        Pet p = pets.get(2);
        System.out.println("4. p = " + p + " pets.indexOf(p) = " + pets.indexOf(p));
        Pet cymric = new Cymric();
        System.out.println("5. indexOf(cymric): " + pets.indexOf(cymric)); 
        System.out.println("6. remove(cymric): " + pets.remove(cymric));
        pets.remove(p);
        System.out.println("8. pets = " + pets);
        pets.add(3, new Mouse());
        System.out.println("9. pets = " + pets);
        List<Pet> sub = pets.subList(1, 4);
        System.out.println("10. subList: " + sub);
        System.out.println("11. pets.containsAll(sub) = " + pets.containsAll(sub));
        Collections.sort(sub);
        System.out.println("12. sorted subList: " + sub);
        System.out.println("13. pets.containsAll(sub) = " + pets.containsAll(sub));
        Collections.shuffle(sub, rand);
        System.out.println("14. pets.containsAll(sub) = " + pets.containsAll(sub));
        List<Pet> copy = new ArrayList<Pet>(pets);
        sub = Arrays.asList(pets.get(1), pets.get(4));
        System.out.println("15. sub = " + sub);
        copy.retainAll(sub);
        System.out.println("16. copy = " + copy);
        copy = new ArrayList<Pet>(pets);
        copy.remove(2);
        System.out.println("17. copy = " + copy);
        copy.removeAll(sub);
        System.out.println("18. copy = " + copy);
        copy.set(1, new Mouse());
        System.out.println("19. copy = " + copy);
        copy.addAll(2, sub);
        System.out.println("20. copy = " + copy);
        System.out.println("21. pets.isEmpty() = " + pets.isEmpty());
        pets.clear();
        System.out.println("22. pets.isEmpty() = " + pets.isEmpty());
        pets.addAll(Pets.arrayList(4));
        System.out.println("21. pets = " + pets);
        Object[] o = pets.toArray();
        System.out.println(o[3]);
        Pet[] pa = pets.toArray(new Pet[0]);
        System.out.println("23. " + pa[3].id());
    }
}