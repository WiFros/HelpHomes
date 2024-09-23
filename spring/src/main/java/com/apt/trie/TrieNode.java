package com.apt.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private final Map<String, TrieNode> children = new HashMap<>();
    private boolean isEndOfWord;

    public Map<String, TrieNode> getChildren() {
        return children;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }
}
