package com.examples.filesorter;

import java.util.ArrayList;
import java.util.List;

public class File {
    int id;
    int size;
    String name;
    List<String> tags;
    File(int id, int size, String name){
        this.id = id;
        this.name = name;
        this.size = size;

    }

    public void setTag(String tag){
        if(tags == null){
            tags = new ArrayList<>();
        }
        tags.add(tag);
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", size=" + size +
                ", name='" + name + '\'' +
                ", tags=" + tags +
                '}';
    }
}
