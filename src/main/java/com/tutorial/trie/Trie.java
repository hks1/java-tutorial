package com.tutorial.trie;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Trie {
    private TrieNode root; // Root node

    // constructor
    public Trie(){
        root = new TrieNode();
    }
    // Function to get the index of a character 'x'
    public int getIndex(char x){
        return x - 'a'; // index is based on the position of character in alphabet
    }

    // function to insert a key in the Trie
    public void insert(String key){
        if(key == null){
            return; // null key can't be inserted
        }
        key = key.toLowerCase(); // keys are stored in lower case
        TrieNode currNode = this.root;
        int index = 0; // to store character index
        // Iterate the Trie with the given character index,
        // If it is null, then create a TrieNode and go down a level
        for(int level = 0; level < key.length(); level++){
            index = getIndex(key.charAt(level));
            if(currNode.children[index] == null){
                currNode.children[index] = new TrieNode();
            }
            currNode = currNode.children[index];
        }
        // Mark the end character as leaf node
        currNode.markAsLeaf();
    }

    @Override
    public String toString() {
        return "Trie{" +
                "root=" + root +
                '}';
    }
    
    public void print(){
        //TrieNode currentNode = this.root;
        List<Character> list = new ArrayList<>();
        ArrayDeque<TrieNode> queue = new ArrayDeque<>();
        queue.add(this.root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                
            }
        }
    }
}
