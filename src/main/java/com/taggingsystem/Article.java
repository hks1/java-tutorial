package com.taggingsystem;

import java.util.ArrayList;
import java.util.List;

class Article {
    private int id;
    private String title;
    private String content;
    private List<String> tags;

    public Article(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.tags = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<String> getTags() {
        return tags;
    }

    public void addTag(String tag) {
        tags.add(tag);
    }
}
