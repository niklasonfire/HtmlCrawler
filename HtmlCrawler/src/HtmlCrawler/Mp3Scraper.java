package HtmlCrawler;

import java.io.File;
import java.util.ArrayList;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;


public class Mp3Scraper {
	public static void main(String[] args) throws Exception{
		
			final Document document = Jsoup.connect("https://www.christus-centrum.de/media/?type=1289377&tx_podcast_display%5Bpodcast%5D=1&tx_podcast_display%5Baction%5D=show&cHash=dda9a1712fb73744006e306a04fbf47c").get();
			Document doc = Jsoup.parse(document.toString(), "", Parser.xmlParser());
			
			Elements links = doc.select("item").select("enclosure");
			ArrayList<String> linkArr = new ArrayList();
			int i = 0;
			String tmp;
			for(Element link : links) {
				tmp = link.toString();
				tmp = tmp.substring(tmp.indexOf("http"), tmp.indexOf(".mp3"))+".mp3";
				linkArr.add(tmp);
				
			}
		
	}
}
