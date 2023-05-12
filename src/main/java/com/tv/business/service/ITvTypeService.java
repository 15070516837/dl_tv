package com.tv.business.service;

import com.tv.business.entity.TvType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 影视类型表业务接口
 *
 * @author Json
 * @since 2023-05-13 01:19:57
 */
public interface ITvTypeService extends IService<TvType> {

    /**
     * 获取影视类型
     *
     * @return
     */
    public List<TvType> getTvTypeList();

}

