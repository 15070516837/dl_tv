package com.tv.business.mapper;

import com.tv.business.entity.TvType;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* 影视类型表tv_type表持久层接口
*
* @author Json
* @since 2023-05-13 01:19:57
*/
@Mapper
public interface TvTypeMapper extends BaseMapper<TvType> {

}

