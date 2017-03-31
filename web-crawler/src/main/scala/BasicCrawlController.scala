import edu.uci.ics.crawler4j.crawler.{CrawlConfig,CrawlController};
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.{RobotstxtConfig,RobotstxtServer};

object BasicCrawlController {

    // クロールしたデータを保存しておくフォルダ
    val crawlStorageFolder = "./cache";

    // クロールを行うスレッド数
    val numberOfCrawlers = Integer.parseInt("1");

    // クロールのコンフィグを初期化
    val config = new CrawlConfig();
    
        config.setCrawlStorageFolder(crawlStorageFolder);

        // スレッドの間隔の秒数
        config.setPolitenessDelay(1000);

        // クロールする深さ(-1を設定することで、全てクロールする)
        config.setMaxDepthOfCrawling(-1);

        // クロールするページの最大数(-1を設定することで、最大値なし)
        config.setMaxPagesToFetch(1000);

        /*
         * バイナリーデータを取得するかどうか
         * pdf,images など
         */
        config.setIncludeBinaryContentInCrawling(false);

        /*
         * クロール中に中断した履歴を残すか
         * (英語の理解ができていないなめ、この意味であっているか不明)
         */
        config.setResumableCrawling(false);

    //CrawlControllerのインスタンス化
    val pageFetcher = new PageFetcher(config);
    val robotstxtConfig = new RobotstxtConfig();
    val robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
    val controller = new CrawlController(config, pageFetcher, robotstxtServer);

    // クロールするサイトを追加(複数追加可能)
    controller.addSeed("http://suumo.jp/ikkodate/tokyo/sc_setagaya/");

    // クロールスタート
    controller.start(classOf[BasicCrawler], numberOfCrawlers);
}