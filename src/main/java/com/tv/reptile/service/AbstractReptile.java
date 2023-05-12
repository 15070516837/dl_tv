package com.tv.reptile.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tv.business.entity.CommonEntity;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: dl_tv
 * @description: 爬取抽象
 * @author: Json'
 * @create: 2023-05-12 18:43
 **/
public abstract class AbstractReptile<T extends CommonEntity> {

    /**
     * 爬取数据
     *
     * @param url
     * @return
     */
    protected List<T> reptileListData(String url) {
        throw new RuntimeException("Please call the specific implementation");
    }


    /**
     * 获取过滤数据
     *
     * @return
     */
    protected List<T> getFilterData() {
        throw new RuntimeException("Please call the specific implementation");
    }


    /**
     * 将数据入库
     */
    public final void warehousing(IService<T> iService, String url) {
        //获取爬取的数据
        Map<String, List<T>> reptileDataMap = Optional.ofNullable(reptileListData(url).stream().collect(Collectors.groupingBy(T::getFilterData))).orElse(new HashMap<>(0));
        //剔除掉数据库已经存在的数据
        List<T> filterDatas = Optional.ofNullable(getFilterData()).orElse(new LinkedList<>());
        for (T filterData : filterDatas) {
            if (reptileDataMap.containsKey(filterData.getFilterData())) {
                reptileDataMap.remove(filterData.getFilterData());
            }
        }
        //入库
        if (!Objects.isNull(reptileDataMap.values())) {
            List<T> reptileDataList = reptileDataMap.values().stream().flatMap(i -> i.stream()).collect(Collectors.toList());
            iService.saveBatch(reptileDataList);
        }
    }

}
