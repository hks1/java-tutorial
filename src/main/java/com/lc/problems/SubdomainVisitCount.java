package com.lc.problems;

import java.util.*;

// 811. Subdomain Visit Count
//A website domain "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com", at the next level, we have "leetcode.com" and at the lowest level, "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.
//
//A count-paired domain is a domain that has one of the two formats "rep d1.d2.d3" or "rep d1.d2" where rep is the number of visits to the domain and d1.d2.d3 is the domain itself.
//
//For example, "9001 discuss.leetcode.com" is a count-paired domain that indicates that discuss.leetcode.com was visited 9001 times.
//Given an array of count-paired domains cpdomains, return an array of the count-paired domains of each subdomain in the input. You may return the answer in any order.
//
//
// Indeed
public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains){
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        //System.out.println(Arrays.toString(cpdomains[0].split(" ")));
        for(int i = 0; i < cpdomains.length; i++){
            //String[] cpdomain = cpdomains[i].split("\\s+"); // records are space separated
            String[] cpdomain = cpdomains[i].split(","); // records are comma separated
            //System.out.println(Arrays.toString(cpdomain));
            int count = Integer.valueOf(cpdomain[0]);
            String[] domains = cpdomain[1].split("\\.");
            //System.out.println("domains -> " + cpdomain[1] + " " + Arrays.toString(domains));
            //System.out.println(Arrays.toString(domains));
            String cur = "";
            for(int j = domains.length-1; j >= 0; j--){
                cur = domains[j] + (j < domains.length-1 ? "." : "") + cur;

                map.put(cur, map.getOrDefault(cur, 0) + count);

            }
        }
        for(String domain : map.keySet()){
            result.add(map.get(domain) + " " + domain);
        }
        return result;
    }
}

class TDSubdomainVisitCount{
    public static void main(String[] args) {
        SubdomainVisitCount obj = new SubdomainVisitCount();
        //System.out.println(obj.subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));

        String[] counts = {
                "900,google.com",
                "60,mail.yahoo.com",
                "10,mobile.sports.yahoo.com",
                "40,sports.yahoo.com",
                "300,yahoo.com",
                "10,stackoverflow.com",
                "20,overflow.com",
                "5,com.com",
                "2,en.wikipedia.org",
                "1,m.wikipedia.org",
                "1,mobile.sports",
                "1,google.co.uk"
        };

        System.out.println(obj.subdomainVisits(counts));
    }
}
