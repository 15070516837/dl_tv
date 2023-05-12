package com.tv.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tv.business.entity.TvType;
import com.tv.business.mapper.TvTypeMapper;
import com.tv.business.service.ITvTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @author Json
 * @since 2023-05-13 01:19:57
 */
@Slf4j
@Service
public class TvTypeServiceImpl extends ServiceImpl<TvTypeMapper, TvType> implements ITvTypeService {


    @Autowired
    private TvTypeMapper tvTypeMapper;

    /**
     * 获取影视类型,并且填充过滤值
     *
     * @return
     */
    @Override
    public List<TvType> getTvTypeList() {
        List<TvType> tvTypes = tvTypeMapper.selectList(new LambdaQueryWrapper<>());
        if (!Objects.isNull(tvTypes)) {
            tvTypes.forEach(i -> {
                i.setFilterData(i.getTvTypesName());
            });
        }
        return tvTypes;
    }
}

