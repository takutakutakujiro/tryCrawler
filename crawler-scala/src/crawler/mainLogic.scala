package crawler

import org.jsoup._
import scala.collection.JavaConverters._

object mainLogic extends App{
    
    val doc = Jsoup.connect("http://takujiro.net/2017/01/24/scala-jsoup/").get
    val elements = doc.select("h2,h3").asScala
    
    for(element <- elements) {
      println(element.text)
    }
}