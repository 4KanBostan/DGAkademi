
import java.util.HashSet;

public class Hashset {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet<>();
        hashSet.add("Elma");
        hashSet.add("Armut");
        hashSet.add("Elma");
        hashSet.add("Kiraz");

        System.out.println("listede eleman sayisi :"+hashSet.size());

        System.out.println("liste bos mu :"+hashSet.isEmpty());

    }




}


