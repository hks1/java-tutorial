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



class Result {

    /*
     * Complete the 'minimalHeaviestSetA' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        Collections.sort(arr);
        //System.out.println(arr);
        int total = 0;
        for(int i : arr){
            total += i;
        }
        int right = arr.size()-1;
        int asum = 0;
        int bsum = total;
        while(asum <= bsum){
            int val = arr.get(right);
            asum += val;
            result.add(val);
            bsum -= val;
            right--;
        }
        /*
        for(int i = arr.size()-1; i >=0; i-- ){
            if(asum )
        }
        */
        Collections.reverse(result);
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.minimalHeaviestSetA(arr);

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
