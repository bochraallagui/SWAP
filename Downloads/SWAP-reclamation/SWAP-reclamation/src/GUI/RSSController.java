/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import services.Rss;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


/**
 * FXML Controller class
 *
 * @author bochra
 */
public class RSSController implements Initializable {

    @FXML
    private Label txtRSS;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
                List<String> rssFeeds = new ArrayList<>();        
         rssFeeds.add("https://rss.app/feeds/egxU6XyhyMxZmTvZ.xml");
         rssFeeds.add("https://rss.app/feeds/9TT9m58gyJiUTSOF.xml");
         rssFeeds.add("https://rss.app/feeds/6pA4FWy7uBJrHvaC.xml");
         rssFeeds.add("https://rss.app/feeds/cIw9mJ3KID0M7nUp.xml");
         rssFeeds.add("https://rss.app/feeds/aiEbDby3s6SHkfvS.xml");
         rssFeeds.add("https://rss.app/feeds/uZrgXF3ZfVsHh5v5.xml");
         rssFeeds.add("https://rss.app/feeds/6TJKC5gIESL9Jt3h.xml");
         rssFeeds.add("https://rss.app/feeds/tpHTXuFe1T1pYozy.xml");
         rssFeeds.add("https://rss.app/feeds/7TmLlNXPYZnOiZST.xml");
         rssFeeds.add("https://rss.app/feeds/H4FyHjDXuq3LG6gj.xml");
        
                 
        
        
 StringBuilder builder = new StringBuilder();
        for (String feed : rssFeeds) {
            builder.append(Rss.readRSS(feed)).append("\n\n");
        }
        txtRSS.setText(builder.toString());
    }
}