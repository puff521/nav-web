package com.nav.web.service.jtm;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nav.web.entity.NavSite;

import java.util.List;
import java.util.Map;

public interface JtmSiteService extends IService<NavSite> {

   Map<String, List<NavSite>> getSiteList();

}
