package app;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class GrandSmith extends Apple{}
class Gala extends Apple {}
class Fuji extends Apple {}
class Braeburn extends Apple {}

public class GenericsAndUpcasting {
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<Apple>();

        apples.add(new GrandSmith());
        apples.add(new Gala());
        apples.add(new Fuji());
        apples.add(new Braeburn());

        for (Apple apple : apples) {
            System.out.println(apple.id());
        }

        List<Apple> listAppels = new ArrayList<Apple>();
        listAppels = new LinkedList<Apple>();
    }
}