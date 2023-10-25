package com.nav.web.controller;

import com.nav.web.common.utils.SecurityUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/index")
    @ApiOperation("获取站点数据")
    public String index(Model model) {
        String siteCode =  SecurityUtils.getHeader("siteCode");
        System.out.println("============"+siteCode);
        if("fm_dh".equals(siteCode)){
            return "forward:/fm/index";
        } else if ("jtm_dh".equals(siteCode)) {
            return "forward:/jtm/index";
        }
        return "index";
    }


    @GetMapping("/gysl/{siteCode}")
    @ApiOperation("获取站点数据")
    public String gysl(@PathVariable  String siteCode) {
        if("fm_dh".equals(siteCode)){
            return "forward:/fm/gysl";
        } else if ("jtm_dh".equals(siteCode)) {
            return "forward:/jtm/gysl";
        }
        return "index";
    }

}
