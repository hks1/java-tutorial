package com.webcrawler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class WebCrawlerTest {

    WebCrawler obj;

    @BeforeEach
    void setUp() {
        obj = new WebCrawler();
    }

    @Test
    void getDomain() throws URISyntaxException {
        assertEquals("news.yahoo.com", obj.getDomain("http://news.yahoo.com/news/topics/"));
        assertEquals("news.yahoo.com", obj.getDomain("http://www.news.yahoo.com/news/topics/"));
    }
}