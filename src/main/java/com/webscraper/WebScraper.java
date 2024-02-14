package com.webscraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebScraper {
    private static final int NUM_THREADS = 4; // Number of threads for scraping

    public static void main(String[] args) {
        String urlToScrape = "https://google.com"; // Replace with the URL you want to scrape
        WebScraper webScraper = new WebScraper();
        webScraper.scrape(urlToScrape);
    }

    public void scrape(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("a[href]");

            // Create a thread pool with the specified number of threads
            ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

            // Iterate through each link and create a thread to scrape it
            for (Element link : links) {
                String linkUrl = link.absUrl("href");
                executor.execute(new ScrapeTask(linkUrl));
            }

            // Shutdown the thread pool
            executor.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ScrapeTask implements Runnable {
        private final String url;

        public ScrapeTask(String url) {
            this.url = url;
        }

        @Override
        public void run() {
            try {
                Document doc = Jsoup.connect(url).get();
                // Process the scraped data here
                System.out.println("Scraped URL: " + url);
                // Add your custom parsing logic here
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
