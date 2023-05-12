package com.tv.business.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: dl_tv
 * @description:
 * @author: Json'
 * @create: 2023-05-12 20:28
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TvTypeEntity extends CommonEntity {

    private Long tvId;

    private String tvTypesName;

    private Integer tvTypesSort;

    private Long tvParent;

}
