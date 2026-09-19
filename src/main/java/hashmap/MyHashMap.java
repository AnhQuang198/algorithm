package hashmap;

public class MyHashMap {
    private Integer[] keys;
    private String[] values;

    public MyHashMap(int capacity) { //tạo Hashmap với size bucket mặc định
        keys = new Integer[capacity];
        values = new String[capacity];
    }

    public void put(int key, String value) {
        int index = getIndex(key);
        System.out.println("Index bucket is: " + index);
        keys[index] = key;
        values[index] = value;
    }

    public String get(int key) {
        int index = getIndex(key);
        return values[index];
    }

    private int getIndex(int key){
        return key % keys.length;
    }
}
