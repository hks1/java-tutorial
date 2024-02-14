package com.taggingsystem;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaggingSystem taggingSystem = new TaggingSystem();

        // Add some articles
        taggingSystem.addArticle(1, "Introduction to Java", "This is an article about Java.");
        taggingSystem.addArticle(2, "Data Structures in Java", "An overview of common data structures.");
        taggingSystem.addArticle(3, "Web Development with Spring Boot", "Building web applications using Spring Boot.");

        // Tag the articles
        taggingSystem.addTagToArticle(1, "Java");
        taggingSystem.addTagToArticle(1, "Programming");
        taggingSystem.addTagToArticle(2, "Data Structures");
        taggingSystem.addTagToArticle(3, "Web Development");
        taggingSystem.addTagToArticle(3, "Java");

        // Search for articles with a specific tag
        String tagToSearch = "Java";
        List<Article> searchResults = taggingSystem.searchArticlesByTag(tagToSearch);

        System.out.println("Articles with the tag '" + tagToSearch + "':");
        for (Article article : searchResults) {
            System.out.println("Article " + article.getId() + ": " + article.getTitle());
        }
    }
}
