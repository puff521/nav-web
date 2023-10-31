package com.nav.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.nav.web.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel("站点对象")
public class NavType extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 类型id */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "ID")
    @TableId(value = "nav_type_id", type = IdType.INPUT)
    private Long navTypeId;

    /** 站点类型：1-导航 2-视频 3-小时 4-图片 5-工具 */
    @ApiModelProperty(name = "站点类型：1-导航 2-视频 3-小时 4-图片 5-工具")
    private String navCode;

    /** 类型名称 */
    @ApiModelProperty(name = "类型名称")
    private String navName;

    /** 状态 0 关闭 1 开启 */
    @ApiModelProperty(name = "状态 0 关闭 1 开启")
    private Long status;

    @ApiModelProperty(name = "排序字段")
    private Integer sort;

}
