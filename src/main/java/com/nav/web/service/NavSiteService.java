package com.nav.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nav.web.entity.NavSite;

import java.util.List;
import java.util.Map;

public interface NavSiteService extends IService<NavSite> {

   Map<String, List<NavSite>> getSiteList();

}
