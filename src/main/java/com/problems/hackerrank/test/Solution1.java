package com.problems.hackerrank.test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result1 {

    /*
     * Complete the 'numberOfItems' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER_ARRAY startIndices
     *  3. INTEGER_ARRAY endIndices
     */

    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        //Map<int[], Integer> map = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] indices = new int[2];
        int start = -1;
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '|'){
                indices = new int[]{start, i+1};
                map.put(indices[0], count);
                start = i+1;
                count = 0;
            }else{
                count++;
            }

        }
        System.out.println(map);
        return result;
    }

    /*
    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
    // Write your code here
        List<Integer> result = new ArrayList<>();
        //Map<int[], Integer> map = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < startIndices.size(); i++){
            char[] arr = s.substring(startIndices.get(i)-1, endIndices.get(i)).toCharArray();
            //System.out.println(Arrays.toString(arr));
            boolean start = false;
            int count = 0;
            int total = 0;
            for(int j = 0; j < arr.length; j++){
                if(arr[j] == '|' && !start){
                    start = true;
                    count = 0;
                }else if(arr[j] == '|'){
                    total += count;
                    count = 0;
                }else{
                    count++;
                }
            }
            result.add(total);
        }
        return result;
    }

}
     */

}

public class Solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int startIndicesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> startIndices = IntStream.range(0, startIndicesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int endIndicesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> endIndices = IntStream.range(0, endIndicesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result1.numberOfItems(s, startIndices, endIndices);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

