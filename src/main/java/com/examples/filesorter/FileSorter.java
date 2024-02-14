package com.examples.filesorter;

import java.util.*;

public class FileSorter {
    public static void main(String[] args) {
        File file1 = new File(1, 200, "file1");
        file1.setTag("tag1");
        File file2 = new File(2, 400, "file2");
        file2.setTag("tag1");

        File file3 = new File(3, 550, "file3");
        file3.setTag("tag2");
        File file4 = new File(4, 500, "file4");
        file4.setTag("tag3");
        file4.setTag("tag4");
        File file5 = new File(1, 200, "file5");
        file1.setTag("tag4");

        List<File> files = new ArrayList<>();
        files.addAll(Arrays.asList(file2, file1, file3, file4));
        System.out.println(files);
        List<String> result = getTopTags(files, 2);
        System.out.println(result);



        /*Map<String, Integer> map = new HashMap<>();

        for (File file :
                files) {
            for (String tag :
                    file.tags) {
                map.put(tag, map.getOrDefault(tag, 0) + file.size);
            }
        }
        System.out.println(map);
        // create a list of tags
        List<String> tags = new ArrayList<>(map.keySet());
        // sort it based on size
        tags.sort((a,b) -> map.get(a) - map.get(b));
        Collections.reverse(tags);
        System.out.println(tags);*/

    }

    public static List<String> getTopTags(List<File> files, int count){
        Map<String, Integer> map = new HashMap<>();

        for (File file :
                files) {
            for (String tag :
                    file.tags) {
                map.put(tag, map.getOrDefault(tag, 0) + file.size);
            }
        }
        System.out.println(map);
        // create a list of tags
        List<String> tags = new ArrayList<>(map.keySet());
        // sort it based on size
        tags.sort((a,b) -> map.get(a) - map.get(b));
        Collections.reverse(tags);
        System.out.println(tags);
        return tags.subList(0,2);
    }
}
