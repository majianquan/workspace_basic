package demo.tree;
import java.util.TreeMap;

public class Trie {
    private Node root;
    private int size;

    private class Node {
        private boolean isWord;
        private TreeMap<Character,Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }
        public Node() {
            this(false);
        }
    }

    public Trie() {
        this.root = new Node();
    }
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null) {
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);
        }
        if(!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }
    public void addWord(String word) {
        addWord(root,word,0);
    }
    private void addWord(Node node ,String word,int index) {
        if(!node.isWord && index == word.length()) {
            node.isWord = true;
            size++;
        }
        if(word.length() > index) {
            char addLetter = word.charAt(index);
            if(node.next.get(addLetter) == null) {
                node.next.put(addLetter,new Node());
            }
            addWord(node.next.get(addLetter),word,index + 1);
        }
    }
    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }
    public boolean recursionContains(String word) {
        Node cur = root;
        return contains(root, word, 0);
    }

    private boolean contains(Node node, String word, int index) {
        if(index == word.length()) {
            return node.isWord;
        }
        if(node.next.get(word.charAt(index))  == null) {
            return false;
        } else {
            return contains(node.next.get(word.charAt(index)), word, index + 1);
        }
    }

    public boolean isPrefix(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if(cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }
    public boolean recursionIsPrefix(String word) {
        return isPrefix(root,word,0);
    }
    private boolean isPrefix(Node node,String word,int index) {
        if(index == word.length()) {
            return false;
        }
        char c = word.charAt(index);
        if(node.next.get(c) == null) {
            return false;
        } else {
            return isPrefix(node.next.get(c), word, index + 1);
        }
    }

    public int getSize() {
        return size;
    }
}
