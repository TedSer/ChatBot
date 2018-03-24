import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StartPars {
    public static void main(String[] arg)throws IOException {
        List<Article> articleList = new ArrayList<>();

        Document doc = Jsoup.connect("https://planetakino.ua/lvov/showtimes/").get();
        Elements pElements = doc.getElementsByAttributeValue("class", "movie-title") ;

        pElements.forEach(pElement -> {
            Element aElement = pElement.child(0);
            String url = aElement.attr("href");
            String title = aElement.child(0).text();

            articleList.add(new Article(url, title ));
    });
        articleList.forEach(System.out::println);

    }
}

class Article {
    private String url;
    private String name;

    public Article (String url, String name) {
        this.url = url;
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Article{" +
                "url = " + url +
                ", name = " + name +
                '}';

    }
}