package com.nav.web.controller;


import com.nav.web.entity.NavSite;
import com.nav.web.entity.NavType;
import com.nav.web.service.jtm.JtmDomainService;
import com.nav.web.service.jtm.JtmSiteService;
import com.nav.web.service.jtm.JtmTypeService;
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
@RequestMapping("jtm")
@Slf4j
public class JtmController {

    @Autowired
    private JtmDomainService navDomainService;

    @Autowired
    private JtmTypeService jtmTypeService;

    @Autowired
    private JtmSiteService jtmSiteService;


    @GetMapping("/index")
    @ApiOperation("获取站点数据")
    public String dfc(Model model) {

        List<NavType> navTypeList =   jtmTypeService.getNvaTypeList();
        Map<String, List<NavSite>> siteMap = jtmSiteService.getSiteList();
        model.addAttribute("domainAddress", navDomainService.getDomainUrl());
        model.addAttribute("navTypeList", navTypeList);
        model.addAttribute("siteMap", siteMap);
        return "jtm/index";
    }

    @GetMapping("/gysl")
    @ApiOperation("获取站点数据")
    public String gysl(Model model) {
        return "jtm/gysl";
    }
}
