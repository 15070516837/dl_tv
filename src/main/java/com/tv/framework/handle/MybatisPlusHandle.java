package com.tv.framework.handle;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @program: dl_tv
 * @description:
 * @author: Json'
 * @create: 2023-05-13 01:56
 **/
@Component
public class MybatisPlusHandle implements MetaObjectHandler {

    private final Logger logger = LoggerFactory.getLogger(MybatisPlusHandle.class);


    @Override
    public void insertFill(MetaObject metaObject) {
        logger.info("MybatisPlusHandle类开始处理入库之前的指定字段值填充开始......");

        LocalDateTime now = LocalDateTime.now();
        this.strictInsertFill(metaObject, "tvCreateTime", LocalDateTime.class, now);
        logger.info("tvCreateTime填充的值为:" + now);

        Integer tvDelete = 0;
        this.strictInsertFill(metaObject, "tvDelete", Integer.class, tvDelete);
        logger.info("tvDelete填充的值为:" + tvDelete);

        logger.info("MybatisPlusHandle类开始处理入库之前的指定字段值填充结束......");
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
