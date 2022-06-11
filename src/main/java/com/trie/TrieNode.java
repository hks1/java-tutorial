package com.trie;

public class TrieNode {

    TrieNode[] children;
    boolean isEndWord; // true if node represents end of the word
    static final int ALPHABET_SIZE = 26; // total # of English Alphabets = 26 ( assuming lowercase only)

    TrieNode(){
        this.isEndWord = false;
        this.children = new TrieNode[ALPHABET_SIZE];
    }

    // function to mark the current node as leaf
    public void markAsLeaf(){
        this.isEndWord = true;
    }

    // function to unMark the current node as leaf
    public void unMarkAsLeaf(){
        this.isEndWord = false;
    }

}
