package com.nav.web.controller;


import com.nav.web.entity.NavSite;
import com.nav.web.entity.NavType;
import com.nav.web.service.NavDomainService;
import com.nav.web.service.NavSiteService;
import com.nav.web.service.NavTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Api(tags = "站点")
@Controller
@RequestMapping("site")
@Slf4j
public class SiteController {

    @Autowired
    private NavDomainService navDomainService;

    @Autowired
    private NavTypeService navTypeService;

    @Autowired
    private NavSiteService navSiteService;

    @GetMapping("/siteList")
    @ApiOperation("获取站点数据")
    public String List(Model model) {
        NavSite navSite = new NavSite();
        navSite.setSiteId(1L);
        navSite.setSiteName("风马修");
        navSite.setSiteUrl("https://www.baidu.com/");
        model.addAttribute("site", navSite);
        return "index";
    }


    @GetMapping("/index")
    @ApiOperation("获取站点数据")
    public String dfc(Model model) {

        List<NavType> navTypeList =   navTypeService.getNvaTypeList();
        Map<String, List<NavSite>> siteMap = navSiteService.getSiteList();
        model.addAttribute("domainAddress", navDomainService.getDomainUrl());
        model.addAttribute("navTypeList", navTypeList);
        model.addAttribute("siteMap", siteMap);
        return "index";
    }

}
