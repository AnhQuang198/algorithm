package leetcode;

import java.util.*;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagramMap(s, t));

        String s1 = "rat", t1 = "car";
        System.out.println(isAnagramMap(s1, t1));

        String s2 = "aacc", t2 = "ccac";
        System.out.println(isAnagramMap(s2, t2));
    }

    /** O(n)
     * Tách 2 String thành 1 list các chữ, sau đó sắp xếp theo thứ tự rồi so sánh với nhau
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagramSorted(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        String[] sLetters = s.split("");
        String[] tLetters = t.split("");

        //Sắp xếp 2 list element string
        Arrays.sort(sLetters);
        Arrays.sort(tLetters);

        return Arrays.equals(sLetters, tLetters);
    }

    /** O(n)
     * Sử dụng HashMap, tách String thành 1 list các chữ, add từng element của string s vào HashMap và tăng value lên nếu trùng, sau đó duyệt qua string t và giảm value trong Map
     * Nếu sau cùng Map.isEmpty thì là đảo chữ
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagramMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        String[] sLetters = s.split("");
        String[] tLetters = t.split("");

        Map<String, Integer> mapData = new HashMap<>();
        //Push hết phần tử của s vào Map, nếu trùng thì tăng value lên 1, chưa có thì push vào với value là 1
        for (String sLetter : sLetters) {
            if (!mapData.containsKey(sLetter)) {
                mapData.put(sLetter, 1);
            } else {
                mapData.put(sLetter, mapData.get(sLetter) + 1);
            }
        }

        //Lấy từng phần tử trong Map ra theo t, nếu có thì trừ value đi 1
        for (String tLetter : tLetters) {
            if (mapData.containsKey(tLetter)) {
                mapData.put(tLetter, mapData.get(tLetter) - 1);
            }
            if (mapData.get(tLetter) != null && mapData.get(tLetter) == 0) {
                mapData.remove(tLetter);
            }
        }

        return mapData.isEmpty();
    }
}
