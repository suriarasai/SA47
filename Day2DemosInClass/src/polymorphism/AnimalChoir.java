package polymorphism;

import java.util.*;

public class AnimalChoir {

    private Vector members;

    public AnimalChoir() {
        members = new Vector();
    }

    public void addMember(Animal a) {
        members.add(a);
    }

    public void sing() {
        for (int x = 0; x < members.size(); x++) {
            Animal a = (Animal) members.elementAt(x);
            a.makeSound();
        }
    }

}
