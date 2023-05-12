package com.tv;

import com.tv.business.entity.TvTypeEntity;
import com.tv.reptile.service.AbstractReptile;
import com.tv.reptile.service.TenXunCrawlWebsite;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @program: dl_tv
 * @description:
 * @author: Json'
 * @create: 2023-05-12 20:25
 **/

@SpringBootTest
@RunWith(SpringRunner.class)
public class ICrawIWebsiteTest {

    @Autowired
    private TenXunCrawlWebsite tenXunCrawlWebsite;


    @Test
    public void test1() {
        tenXunCrawlWebsite.getMovies("https://v.qq.com", new AbstractReptile<TvTypeEntity>() {
            /**
             * 爬取指定数据
             * @param url
             * @return
             */
            @Override
            protected List<TvTypeEntity> reptileListData(String url) {
                List<TvTypeEntity> tvTypeEntityList = new LinkedList<>();
                try {
                    //加载解析一个URL
                    Document doc = Jsoup.connect(url).timeout(10000).userAgent("Mozilla").get();
                    if (Objects.isNull(doc)) {
                        return tvTypeEntityList;
                    }
                    //获取每一个标签的跳转地址，标签名称
                    Elements labels = doc.select("a[class=nav-item]");
                    for (int i = 0; i < labels.size(); i++) {
                        Element label = labels.get(i);
                        //跳转地址
                        String href = label.attr("href");
                        String text = label.select("div[class=text]").first().text();
                        if (!href.contains("https:")) {
                            TvTypeEntity build = TvTypeEntity.builder().tvId(1L).tvTypesName(text).tvTypesSort(i+1).tvParent(0L).build();
                            tvTypeEntityList.add(build);
                        }
                    }
                    return tvTypeEntityList;
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException("服务器异常");
                }
            }

            /**
             * 获取已经存在的数据
             * @return
             */
            @Override
            protected List<TvTypeEntity> getFilterData() {
                return super.getFilterData();
            }
        });
    }
}
