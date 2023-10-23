package com.nav.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nav.web.entity.NavSite;
import com.nav.web.entity.NavType;
import com.nav.web.mapper.NavSiteMapper;
import com.nav.web.service.NavSiteService;
import com.nav.web.service.NavTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
//@CacheConfig(cacheNames = {"site"})
public class NavSiteServiceImpl extends ServiceImpl<NavSiteMapper, NavSite> implements NavSiteService {


    @Autowired
    private NavTypeService navTypeService;

    @Override
    public   Map<String, List<NavSite>> getSiteList() {
        List<NavType>  navTypes =  navTypeService.list();
        List<NavSite> navSiteList = this.list();
        // 按照游戏分类分组
        Map<Long, List<NavSite>> gameCategoryMap =
                navSiteList.stream().collect(Collectors.groupingBy(NavSite::getNavTypeId));

        Map<String, List<NavSite>> stringListMap = new HashMap<>();
        gameCategoryMap.forEach((kev, value) -> {
            navTypes.forEach(typeItem->{
                if(kev.equals(typeItem.getNavTypeId())){
                    stringListMap.put(typeItem.getNavCode(),value);
                }
            });
        });
        return stringListMap;
    }
}
