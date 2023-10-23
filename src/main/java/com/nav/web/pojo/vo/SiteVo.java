package com.nav.web.pojo.vo;

import io.swagger.annotations.ApiModelProperty;

public class SiteVo {

    /**
     *
     */
    private Long siteId;

    /**
     * 站点类型id
     */
    @ApiModelProperty(name = "站点类型id")
    private Long navTypeId;

    /**
     * 站点的url
     */
    @ApiModelProperty(name = "站点的url")
    private String siteUrl;

    /**
     * 站点编码
     */
    @ApiModelProperty(name = "站点编码")
    private String siteCode;

    /**
     * 站点名称
     */
    @ApiModelProperty(name = "站点名称")
    private String siteName;

    /**
     * 站点访问我方url
     */
    @ApiModelProperty(name = "站点访问我方url")
    private String jumpUrl;

    /**
     * 站点跳转本站方式 1直链 2携带code跳转
     */
    @ApiModelProperty(name = "站点跳转本站方式 1直链 2携带code跳转")
    private Long jumpType;

    /**
     * 状态 0 关闭 1 开启
     */
    @ApiModelProperty(name = "状态 0 关闭 1 开启")
    private Integer status;

    /**
     * 状态 0 关闭 1 开启
     */
    @ApiModelProperty(name = "状态 0 关闭 1 开启")
    private String naveCode;
}
