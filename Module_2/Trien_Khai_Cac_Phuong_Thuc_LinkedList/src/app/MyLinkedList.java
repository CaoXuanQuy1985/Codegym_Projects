package app;

class Link {
     int iData;
     double dData;
     Link next;

    public Link(int iData, double dData) {
        this.iData = iData;
        this.dData = dData;
    }

    public void displayLink() {
        System.out.print("{" + iData + ", " + dData + "}, ");
    }

    public String toString() {
        return "{" + iData + ", " + dData + "}, ";
    }
}

public class MyLinkedList {
    private Link first;

    public MyLinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int iData, double dData) {
        Link newLink = new Link(iData, dData);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst() {
        Link removedLink = first;
        first = first.next;

        return removedLink;
    }

    public Link find(Link link) {
        Link current = first;

        while (current != null) {
            if (current.iData == link.iData && current.dData == link.dData) {
                return current;
            }
            current = current.next;
        }

        System.out.println("Not found");
        return null;
    }

    public Link delete(Link link) {
        Link current = first;
        Link previous = null;

        if (first.iData == link.iData && first.dData == link.dData) {
            this.deleteFirst();
        } else {
            while (current != null) {
                if (current.iData != link.iData && current.dData != link.dData) {
                    previous = current;
                    current = current.next;
                } else {
                    previous.next = current.next;
                    return current;
                }
            }
        }

        return null;
    }

    /*public boolean insert(int index, Link link) {

    }*/

    public void displayLinkedList() {
        Link currentLink = first;

        System.out.println("LinkedList: (first --> last):");
        while (currentLink != null) {
            currentLink.displayLink();
            currentLink = currentLink.next;
        }

        System.out.println();
    }
}