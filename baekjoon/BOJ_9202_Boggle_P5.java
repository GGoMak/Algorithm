package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_9202_Boggle_P5 {

    static Trie trie;
    static char[][] map;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int score, findCnt;
    static StringBuilder longestWord;
    static Set<String> set;
    static StringBuilder sb = new StringBuilder();

    static class Trie {
        TrieNode rootNode;

        Trie() {
            rootNode = new TrieNode();
        }

        void insert(String word) {
            TrieNode thisNode = this.rootNode;

            for (int i = 0; i < word.length(); i++) {
                thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
            }

            thisNode.setLastChar(true);
        }

        boolean contains(String word) {
            TrieNode thisNode = this.rootNode;

            for (int i = 0; i < word.length(); i++) {
                char character = word.charAt(i);
                TrieNode node = thisNode.getChildNodes().get(character);

                if (node == null) {
                    return false;
                }

                thisNode = node;
            }

            return thisNode.isLastChar();
        }
    }

    static class TrieNode {
        private Map<Character, TrieNode> childNodes = new HashMap<>();

        private boolean isLastChar;

        public Map<Character, TrieNode> getChildNodes() {
            return childNodes;
        }

        public boolean isLastChar() {
            return this.isLastChar;
        }

        public void setLastChar(boolean isLastChar) {
            this.isLastChar = isLastChar;
        }
    }

    public static void solve(int x, int y, boolean[][] visit, StringBuilder word) {

        if(word.length() > 8) {
            return;
        }

        if(trie.contains(word.toString())) {
            if(!set.contains(word.toString())) {
                findCnt++;
                set.add(word.toString());

                if(word.length() == 3 || word.length() == 4){
                    score += 1;
                } else if(word.length() == 5) {
                    score += 2;
                } else if(word.length() == 6) {
                    score += 3;
                } else if(word.length() == 7) {
                    score += 5;
                } else if(word.length() == 8) {
                    score += 11;
                }

                if(longestWord.length() < word.length()) {
                    longestWord = new StringBuilder(word);
                } else if((longestWord.length() == word.length()) && (word.toString().compareTo(longestWord.toString()) < 0)) {
                    longestWord = new StringBuilder(word);
                }
            }
        }

        for(int i = 0; i < 8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || ny >= 4 || nx >= 4) {
                continue;
            }

            if(!visit[nx][ny]) {
                visit[nx][ny] = true;
                solve(nx, ny, visit, word.append(map[nx][ny]));
                word.setLength(word.length() - 1);
                visit[nx][ny] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        trie = new Trie();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            trie.insert(br.readLine());
        }

        br.readLine();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            map = new char[4][4];
            findCnt = 0;
            score = 0;
            longestWord = new StringBuilder();
            set = new TreeSet<>();

            for(int i = 0; i < 4; i++){
                String ss = br.readLine();
                for(int j = 0; j < 4; j++){
                    map[i][j] = ss.charAt(j);
                }
            }
            br.readLine();

            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 4;j++) {
                    boolean[][] visit = new boolean[4][4];
                    visit[i][j] = true;
                    solve(i, j, visit, new StringBuilder().append(map[i][j]));
                }
            }

            sb.append(score).append(" ").append(longestWord).append(" ").append(findCnt).append("\n");
        }

        System.out.println(sb);
    }
}