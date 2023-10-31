package com.nav.web.controller;


import com.nav.web.entity.NavSite;
import com.nav.web.entity.NavType;
import com.nav.web.service.fm.FmDomainService;
import com.nav.web.service.fm.FmSiteService;
import com.nav.web.service.fm.FmTypeService;
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
@RequestMapping("fm")
@Slf4j
public class FmController {

    @Autowired
    private FmDomainService fmDomainService;

    @Autowired
    private FmTypeService fmTypeService;

    @Autowired
    private FmSiteService fmSiteService;


    @GetMapping("/index")
    @ApiOperation("获取站点数据")
    public String dfc(Model model) {

        List<NavType> navTypeList =   fmTypeService.getNvaTypeList();
        Map<String, List<NavSite>> siteMap = fmSiteService.getSiteList();
        model.addAttribute("domainAddress", fmDomainService.getDomainUrl());
        model.addAttribute("navTypeList", navTypeList);
        model.addAttribute("siteMap", siteMap);
        return "fm/index";
    }


    @GetMapping("/gysl")
    @ApiOperation("获取站点数据")
    public String gysl(Model model) {
        return "fm/gysl";
    }

}
