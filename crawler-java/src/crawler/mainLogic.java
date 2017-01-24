package crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class mainLogic {
	public static void main(String[] args) throws IOException{
		Document document = Jsoup.connect("http://takujiro.net/2017/01/24/scala-jsoup/").get();
		Elements elements = document.select("h2,h3");

		for(Element el : elements){
			System.out.println(el.text());
		}
	}
}
