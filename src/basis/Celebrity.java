package basis;

import java.util.HashSet;

public class Celebrity {

    String name;
    int age;

    public Celebrity(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public int hashCode() {
        return name.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Celebrity) || obj == null)
            return false;

        Celebrity otherCeleb = (Celebrity) obj;
        return name.equals(otherCeleb.name);
    }

    public static void main(String[] args) {
        HashSet<Celebrity> set = new HashSet();
        Celebrity realKardashian = new Celebrity("Kim", 17);
        Celebrity kardashianClone = new Celebrity("Kim", 17);

        set.add(realKardashian);

        if (set.contains(kardashianClone)) {
            System.out.println("Kim is a celebrity");
        } else {
            System.out.println("Can't find Kim");
        }
    }
}
