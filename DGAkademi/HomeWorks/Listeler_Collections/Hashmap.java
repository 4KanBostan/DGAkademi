import java.util.HashMap;

;
public class Hashmap {
    public static void main(String[] args) {

        HashMap hashMap = new HashMap<>();

        hashMap.put(0,"Furkan");
        hashMap.put(1,"Hasan");
        hashMap.put(2,"Dogan");

        for (Object x: hashMap.values()) {
            System.out.println(x);
        }
        System.out.println("------------------------------");
        hashMap.remove(2);  // key değeri 2 olan eleman silindi
        for (Object x: hashMap.values()) {
            System.out.println(x);
        }
        System.out.println("--------------------------------------");
        hashMap.replace(1,"Onur");      //1. elemannın value değştirilidi
        for (Object x: hashMap.values()) {
            System.out.println(x);
        }

        System.out.println("-----------------------------");
        hashMap.clear(); //temizlendi

        for (Object x: hashMap.values()) {
            System.out.println(x);
        }


    }
}