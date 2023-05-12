package com.tv.business.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
* 影视类型表
*
* @author Json
* @since 2023-05-13 01:19:57
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("tv_type")
public class TvType extends CommonEntity {

    /**
    * 主键id
    */
    @TableId(type = IdType.ASSIGN_ID)
    private Long tvId;
    /**
    * 类型名称
    */
    private String tvTypesName;
    /**
    * 类型排序
    */
    private Integer tvTypesSort;
    /**
    * 父级类型
    */
    private Long tvParent;
    /**
    * 创建时间
    */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime tvCreateTime;
    /**
    * 修改时间
    */
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime tvUpdateTime;
    /**
    * 逻辑删除(0:没有删除 1:删除)
    */
    @TableField(fill = FieldFill.INSERT)
    private Integer tvDelete;
}
