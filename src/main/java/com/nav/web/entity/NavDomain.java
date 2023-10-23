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
public class NavDomain extends BaseEntity {

    /** 域名id */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long domainId;

    /** 域名地址 */
    @ApiModelProperty(name = "域名地址")
    private String address;

    /** 域名描述 */
    @ApiModelProperty(name = "域名描述")
    private String descContent;

    /** 状态 0 关闭 1 开启 */
    @ApiModelProperty(name = "状态 0 关闭 1 开启")
    private Integer status;

    /** 是否作废 状态 1正常 0 作废 */
    @ApiModelProperty(name = "是否作废 状态 0正常 -1 作废")
    private Integer discardStatus;

}
