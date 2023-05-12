package com.tv.reptile.service;

import com.tv.business.mapper.TvTypeMapper;
import com.tv.business.service.impl.TvTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @program: dl_tv
 * @description:
 * @author: Json'
 * @create: 2023-05-12 19:54
 **/
@Component
public class TenXunCrawlWebsite implements ICrawlWebsite {

    @Autowired
    private TvTypeServiceImpl tvTypeService;

    /**
     * 爬取腾讯列表
     *
     * @param url
     * @param abstractReptile
     */
    @Override
    public void getLabelList(String url, AbstractReptile abstractReptile) {
        abstractReptile.warehousing(tvTypeService, url);
    }

    /**
     * 爬取指定列表的影视
     *
     * @param url
     * @param abstractReptile
     */
    @Override
    public void getMovies(String url, AbstractReptile abstractReptile) {
        abstractReptile.warehousing(tvTypeService, url);
    }

}
