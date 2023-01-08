package com.problems.hackerrank;

import java.util.Arrays;

public class Contacts {
    class Node{
        int count;
        Node[] children;

        Node(){
            this.count = 0;
            this.children = new Node[26];
            Arrays.fill(children, null);
        }

        public void insert(Node current, String value){
            for(char c : value.toCharArray()){
                int index = c - 'a';

                if(current.children[index] == null){
                    current.children[index] = new Node();
                }

                current.children[index].count++;
                current = current.children[index];
            }
        }
    }


}

/*
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

 */

/*
class Result {

    */
/*
     * Complete the 'contacts' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts 2D_STRING_ARRAY queries as parameter.
     *//*


    public static List<Integer> contacts(List<List<String>> queries) {
        // Write your code here

    }

}
*/

/*
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int queriesRows = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> queries = new ArrayList<>();

        IntStream.range(0, queriesRows).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.contacts(queries);

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
 */