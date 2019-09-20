package Leetcode;

import java.util.*;
//import javafx.util.Pair;

public class WordLadder127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return ladderLengthTwoEnd(beginWord, endWord, wordList);
    }

    boolean onlyOneChar(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
                if (diff > 1) return false;
            }
        }
        return true;
    }

    public int ladderLengthOneEnd(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null) return 0;
        if (beginWord.equals(endWord)) return 0;
        int cnt = 0;
        Queue<Node> candi = new LinkedList<>();
        Node head = new Node(beginWord, 1);  // init with 1
        candi.add(head);

        while (!candi.isEmpty()) {
            Node cur = candi.poll();
            int size = wordList.size();
            for (int i = 0; i < size; i++) {
                if (wordList.get(i).equals("")) continue;

                if (onlyOneChar(cur.s, wordList.get(i))) {
                    if (wordList.get(i).equals(endWord)) return cur.cnt + 1;
                    candi.add(new Node(wordList.get(i), cur.cnt + 1));
                    wordList.set(i, "");
                }
            }
        }
        return 0;
    }

    public int ladderLengthTwoEnd(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null) return 0;
        if (beginWord.equals(endWord)) return 0;

        Queue<Node> front = new LinkedList<>();
        Queue<Node> back = new LinkedList<>();
        Node head = new Node(beginWord, 1);  // init with 1
        front.add(head);
        back.add(new Node(endWord, 1));

        while (!front.isEmpty() && !back.isEmpty()) {
            Node cur = front.poll();
            Node bk = back.poll();
            for (int i = 0; i < wordList.size(); i++) {
                if (wordList.get(i).equals("")) continue;

                if (onlyOneChar(cur.s, wordList.get(i))) {
                    if (wordList.get(i).equals(endWord)) return cur.cnt + 1;
                    front.add(new Node(wordList.get(i), cur.cnt + 1));
                    wordList.set(i, "");
                }
            }
        }
        return 0;
    }

    static class Node {
        private String s;
        private int cnt;
        public Node(String s, int c) {
            this.s = s;
            this.cnt = c;
        }
    }

    public static void main(String[] args) {
        List<String> toTest = new ArrayList<>(
                Arrays.asList("hot","dot","dog","lot","log"));
        WordLadder127 t = new WordLadder127();
        String beg = "hit", end = "cog";
        System.out.println(t.ladderLength(beg, end, toTest));
    }
}
