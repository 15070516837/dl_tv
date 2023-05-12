package com.tv.business.entity;

import lombok.Data;

/**
 * @program: dl_tv
 * @description: 过滤
 * @author: Json'
 * @create: 2023-05-12 19:21
 **/
@Data
public class CommonEntity {
    /**
     * 需要排查过滤的数据，因为数据库已经存在
     */
    private String filterData;

}
