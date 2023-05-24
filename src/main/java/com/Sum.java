package com;

import com.lc.tree.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class Sum{

    public  final Logger LOGGER = Logger.getLogger(this.getClass().getName());
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        TreeNode(int i){}

    }

    {
        System.out.println(this.getClass());
        System.out.println(this.getClass().getName());
        LOGGER.log(Level.INFO, this.getClass().getName());
    }
    public void printSquare(double x){
        System.out.println(x*x);
    }

    public static void main(String[] args) {
        Sum sum = new Sum();
        sum.printSquare(5);
        //sum.printSquare("Hello");
        String s;
        Process p;
        try {
            p = Runtime.getRuntime().exec("cmd /c dir");
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(p.getInputStream())
            );
            while ((s = br.readLine()) != null){
                System.out.println("line : " + s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int[] arr = {-10, -5, 3, 7, 8, 9};
        int mid = arr.length/2;
        System.out.println(mid);

        BSTfromArr(arr);

        int asciiValue = 97;

        char convertedChar = (char)asciiValue;
        System.out.println(convertedChar);

        ArrayList<Character> chars = new ArrayList<>();
        chars.add('d');
        chars.add('e');
        chars.add('m');
        System.out.println(Arrays.toString(chars.toArray()));
        //System.out.println(String.join("", chars));

        //ArrayList<Character> strings = new ArrayList<>()

        Map<Character, Character> map = new HashMap<>();
        for(char c = 'A'; c <= 'J'; c++){
            map.put(c, Character.toLowerCase(c));
        }
        System.out.println(map);


    }

    public static TreeNode BSTfromArr(int[] arr){
        return makeTree(arr, 0, arr.length-1);
    }

    public static TreeNode makeTree(int[] arr, int start, int end){
        if(start > end) return null;

        int mid = start + (end-start)/2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = makeTree(arr, start, mid-1);
        node.right = makeTree(arr, mid+1, end);
        return node;
    }

}