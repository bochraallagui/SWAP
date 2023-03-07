package services;

import java.io.*;
import java.net.*;

public class Rss {

    public static void main(String[] args) {
       
        System.out.println(readRSS("https://rss.app/feeds/egxU6XyhyMxZmTvZ.xml"));
        System.out.println(readRSS("https://rss.app/feeds/9TT9m58gyJiUTSOF.xml"));
        System.out.println(readRSS("https://rss.app/feeds/6pA4FWy7uBJrHvaC.xml"));
        System.out.println(readRSS("https://rss.app/feeds/cIw9mJ3KID0M7nUp.xml"));
        System.out.println(readRSS("https://rss.app/feeds/aiEbDby3s6SHkfvS.xml"));
        System.out.println(readRSS("https://rss.app/feeds/uZrgXF3ZfVsHh5v5.xml"));
        System.out.println(readRSS("https://rss.app/feeds/6TJKC5gIESL9Jt3h.xml"));
        System.out.println(readRSS("https://rss.app/feeds/tpHTXuFe1T1pYozy.xml"));
        System.out.println(readRSS("https://rss.app/feeds/7TmLlNXPYZnOiZST.xml"));
        System.out.println(readRSS("https://rss.app/feeds/H4FyHjDXuq3LG6gj.xml"));
       
    }

    public static String readRSS(String urlAddress) {
        try {
            URL rssUrl = new URL(urlAddress);
            BufferedReader in = new BufferedReader(new InputStreamReader(rssUrl.openStream()));
            String sourceCode = "";
            String line;
            while ((line = in.readLine()) != null) {
                if (line.contains("<title>")) {
                    int firstPos = line.indexOf("<title>");
                    String temp = line.substring(firstPos);
                    temp = temp.replace("<title>", "");
                    int lastPos = temp.indexOf("</title>");
                    temp = temp.substring(0, lastPos);
                    temp = removeCDATA(temp); // Remove CDATA tags and surrounding characters
                    sourceCode += temp + "\n";
                }
            }
            in.close();
            return sourceCode;
        } catch (MalformedURLException ue) {
            System.out.println("Malformed URL");
        } catch (IOException ioe) {
            System.out.println("Something went wrong reading the contents");
        }
        return null;
    }

    public static String removeCDATA(String input) {
        String output = input.replaceAll("<!\\[CDATA\\[|\\]\\]>", "");
        return output;
    }
}
