package us.codecraft.webmagic.samples;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author code4crafter@gmail.com <br>
 */
public class HuxiuProcessor implements PageProcessor {
    @Override
    public void process(Page page) {
        List<String> requests = page.getHtml().links().regex(".*article.*").all();
        page.addTargetRequests(requests);
        page.putField("title", page.getHtml().xpath("//div[@class='clearfix neirong']//h1/text()"));
        page.putField("content", page.getHtml().xpath("//div[@id='neirong_box']/tidyText()"));
    }

    @Override
    public Site getSite() {
        return Site.me().setDomain("www.huxiu.com").addStartUrl("http://www.huxiu.com/");
    }

    public static void main(String[] args) {
        Spider.create(new HuxiuProcessor()).run();
    }
}
