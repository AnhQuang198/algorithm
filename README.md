# Algorithm Learning

Sandbox học thuật toán bằng Java. Cài đặt lại các thuật toán sắp xếp kinh điển, giải bài LeetCode, và tự viết cấu trúc dữ liệu (HashMap) từ đầu.

## Yêu cầu

- Java 8+
- Maven 3.x

## Build

```bash
mvn compile
mvn clean
```

## Chạy

Mỗi class có `main` riêng. Chạy trực tiếp sau khi compile:

```bash
java -cp target/classes sort.QuickSort
java -cp target/classes leetcode.TheeSum
java -cp target/classes hashmap.Main
```

Hoặc dùng Maven:

```bash
mvn exec:java -Dexec.mainClass="leetcode.TwoSum"
```

## Cấu trúc

```
src/main/java/
├── sort/       # Bubble, Selection, Insertion, Shell, Merge, Quick, Counting, Radix
├── leetcode/   # TwoSum, TheeSum, ValidAnagram, GroupAnagrams, LongestConsecutiveSequence
└── hashmap/    # MyHashMap tự cài đặt + Main demo
```

## Quy ước

- Mỗi thuật toán = 1 class độc lập, có `main` chạy test case mẫu.
- Nhiều cách giải cho cùng 1 bài = nhiều method trong cùng class, đặt tên theo độ phức tạp (VD: `threeSumON3` cho O(N³)).
- Javadoc mô tả hướng tiếp cận của từng lời giải.
