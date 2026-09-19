package leetcode;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] lstStr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(lstStr));
    }

    /** ==> total: O(N*MlogM)
     * N = No of total strings
     * M = Size of each string
     * Time Complexity = O(N*MlogM)
     * Space Complexity = O(N)
     * Sử dụng sort mỗi lần lặp qua array, sau đó check trong HashMap. Nếu đã có key thì push thêm phần tử vào List, nếu chưa có tạo list mới với str hiện tại
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        // O(N*MlogM) => vì 1 vòng for là O(N) trong đó có Array.sort là O(MlogM)
        for (String str : strs) {
            String[] characters = str.split("");
            Arrays.sort(characters);
            String strSorted = Arrays.toString(characters);
            if (!map.containsKey(strSorted)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(strSorted, list);
            } else {
                map.get(strSorted).add(str);
            }
        }

        List<List<String>> result = new ArrayList<>();
        // O(N)
        for (String str : map.keySet()) {
            List<String> list = map.get(str);
            result.add(list);
        }
        return result;
    }
}
