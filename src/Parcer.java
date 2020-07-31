import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parcer {
    public static void main(String[] args) throws IOException {
        List<Article> articleList = new ArrayList<>();
        Document doc = Jsoup.connect ("http://4pda.ru").get();
        Elements h1Elements = doc.getElementsByAttributeValue("class", "list-post-title");
        h1Elements.forEach(h1Element -> {
            Element aElement = h1Element.child(0);
            String url = aElement.attr("href");
            String title = aElement.child(0).text();
            articleList.add(new Article(url, title));
        });
        articleList.forEach(System.out::println);
    }

}

class Article {
    private String name;
    private String url;

    public Article(String name, String url) {
        this.name = name;
        this.url = url;
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
        return "Artile{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}



//.userAgent("Mozilla/5.0 (Windows NT 6.1; "+ "WOW64; rv:5.0) Gecko/20100101 Firefox/5.0")