package hashmap;

public class Main {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap(10);

        map.put(1, "25");
        map.put(2, "26");
        map.put(1, "27");
        map.put(3, "28");

        System.out.println(map.get(1));
        System.out.println(map.get(2));
    }
}
