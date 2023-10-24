package com.nav.web.service.fm;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nav.web.entity.NavSite;

import java.util.List;
import java.util.Map;

public interface FmSiteService extends IService<NavSite> {

   Map<String, List<NavSite>> getSiteList();

}
