
import java.util.regex.Pattern;

import edu.uci.ics.crawler4j._

class BasicCrawler extends WebCrawler {

    val IMAGE_EXTENSIONS = Pattern.compile(".*\\.(css|xml|js|gif|jpg|png|mp3|mp3|zip|gz)$");

    /*
     * 正規表現を利用して、クロールするかを判断する
     * (クロールを開始するのに必ずoverrideする必要あり)
     */
    override def shouldVisit(page: Page, url: WebURL): Boolean = {
        val href = url.getURL.toLowerCase

        if (IMAGE_EXTENSIONS.matcher(href).matches)  {
            return false
        }

        return href.startsWith("http://takujiro.net/")
    }

    /*
     * フェッチされたページを取得した後のメソッド
     * (クロールを開始するのに必ずoverrideする必要あり)
     */
    override def visit(page: Page): Unit = {
        val docid = page.getWebURL.getDocid
        val url = page.getWebURL.getURL
        val domain = page.getWebURL.getDomain
        val path = page.getWebURL.getPath
        val subDomain = page.getWebURL.getSubDomain
        val parentUrl = page.getWebURL.getParentUrl
        val anchor = page.getWebURL.getAnchor

        println("Docid: {" + docid + "}")
        println("URL: {" + url + "}")
        println("Domain: {" + domain + "}")
        println("Sub-domain: {" + subDomain + "}")
        println("Path: {" + path + "}")
        println("Parent page: {" + parentUrl + "}")
        println("Anchor text: {" + anchor + "}")
    }
}