package com.tv.reptile.service;

import java.util.List;

/**
 * 各个平台的抽象
 *
 * @author Json
 */
public interface ICrawlWebsite {

    /**
     * 获取主页标签列表
     *
     * @param url
     * @param abstractReptile
     * @return
     */
    void getLabelList(String url, AbstractReptile abstractReptile);

    /**
     * 获取影视列表
     *
     * @param url
     * @param abstractReptile
     * @return
     */
    void getMovies(String url, AbstractReptile abstractReptile);
}
