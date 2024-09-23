package com.apt.trie;

import org.springframework.stereotype.Component;

@Component
public class Trie {
    private final TrieNode root = new TrieNode();

    public TrieNode getRoot() {
        return root;
    }

    public void insert(String sido, String gugun, String dong) {
        TrieNode node = root;
        for (String part : new String[]{sido, gugun, dong}) {
            node.getChildren().putIfAbsent(part, new TrieNode());
            node = node.getChildren().get(part);
        }
        node.setEndOfWord(true);
    }

    public TrieNode search(String... parts) {
        TrieNode node = root;
        for (String part : parts) {
            node = node.getChildren().get(part);
            if (node == null) {
                return null;
            }
        }
        return node;
    }
}
