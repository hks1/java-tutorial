package com.webcrawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WebCrawler {
    private static final int MAX_DEPTH = 5; // Maximum depth to crawl
    private Set<String> visitedUrls = new HashSet<>();
    private Queue<UrlDepthPair> urlsToVisit = new LinkedList<>();

    public void crawl(String startUrl) {
        urlsToVisit.add(new UrlDepthPair(startUrl, 0));

        while (!urlsToVisit.isEmpty()) {
            UrlDepthPair currentUrl = urlsToVisit.poll();
            if (currentUrl.getDepth() > MAX_DEPTH) {
                continue;
            }

            if (!visitedUrls.contains(currentUrl.getUrl())) {
                System.out.println("Visiting: " + currentUrl.getUrl());
                visitedUrls.add(currentUrl.getUrl());

                try {
                    // Fetch the HTML content of the current URL
                    Document doc = Jsoup.connect(currentUrl.getUrl()).get();
                    // Process the page (you can add your logic here)
                    processPage(doc);

                    // Find and add links to the queue
                    Elements links = doc.select("a[href]");
                    for (Element link : links) {
                        String linkUrl = link.absUrl("href");
                        urlsToVisit.add(new UrlDepthPair(linkUrl, currentUrl.getDepth() + 1));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void processPage(Document doc) {
        // Add your logic here to process the content of the page
        // For example, you can extract data or perform specific actions based on the page content.
    }

    public String getDomain(String url) throws URISyntaxException {
        URI uri = new URI(url);
        return uri.getHost();
    }

    public static void main(String[] args) {
        String startUrl = "https://example.com"; // Replace with the starting URL for your crawler
        WebCrawler crawler = new WebCrawler();
        crawler.crawl(startUrl);
    }
}

class UrlDepthPair {
    private final String url;
    private final int depth;

    public UrlDepthPair(String url, int depth) {
        this.url = url;
        this.depth = depth;
    }

    public String getUrl() {
        return url;
    }

    public int getDepth() {
        return depth;
    }
}
