import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;

public class Arraylist {
    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList<>();
        arrayList.add("Furkan");
        arrayList.add("Dogus");
        arrayList.add(5);
        arrayList.add(43);

        for(int i = 0; i <arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }
        System.out.println("-------------------");
        arrayList.remove(2);
        System.out.println("2. indisdeki eleman cikariliyor...");
        for(int i = 0; i <arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }
        System.out.println("-----------------------");
        System.out.println("listeye eleman ekleniyor...");
        arrayList.add("HAsan");
        System.out.println("liste son durum : "+arrayList);
    }
}
