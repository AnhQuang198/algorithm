# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project

Personal Java algorithm-learning sandbox. Maven project, Java 8, no external dependencies, no test framework. Code comments often written in Vietnamese.

## Build & Run

```bash
mvn compile                                              # compile all
mvn exec:java -Dexec.mainClass="sort.QuickSort"          # run one class
java -cp target/classes leetcode.TheeSum                 # run after compile
mvn clean                                                # wipe target/
```

No `mvn test` — no tests exist. Each algorithm class has its own `main` method that runs sample cases and prints results to stdout. That is the verification loop.

## Structure

Three package buckets under `src/main/java/`:

- `sort/` — classic sort algorithms (Bubble, Selection, Insertion, Shell, Merge, MergeSortTwoArray, Quick, Counting, Radix). Each is standalone with its own `main`.
- `leetcode/` — LeetCode problem solutions (TwoSum, TheeSum [sic], ValidAnagram, GroupAnagrams, LongestConsecutiveSequence). Convention: multiple solution methods per class named by complexity (e.g. `threeSumON3` for O(N³) brute force), driven from `main` with labeled test cases.
- `hashmap/` — from-scratch `MyHashMap` (fixed-size arrays, no collision handling) plus `Main` demo.

## Conventions

- Each new algorithm = new class with its own `main`. No shared runner.
- Multiple approaches to same problem = multiple methods on same class, suffixed by big-O.
- Javadoc on solution methods explains the approach (usually Vietnamese).
- Typos in class names (`TheeSum`) are preserved — don't rename without asking.
