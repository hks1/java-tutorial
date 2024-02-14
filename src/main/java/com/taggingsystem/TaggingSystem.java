package com.taggingsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TaggingSystem {
    private Map<Integer, Article> articles;

    public TaggingSystem() {
        articles = new HashMap<>();
    }

    public void addArticle(int id, String title, String content) {
        articles.put(id, new Article(id, title, content));
    }

    public void addTagToArticle(int articleId, String tag) {
        Article article = articles.get(articleId);
        if (article != null) {
            article.addTag(tag);
        }
    }

    public List<Article> searchArticlesByTag(String tag) {
        List<Article> results = new ArrayList<>();
        for (Article article : articles.values()) {
            if (article.getTags().contains(tag)) {
                results.add(article);
            }
        }
        return results;
    }
}

