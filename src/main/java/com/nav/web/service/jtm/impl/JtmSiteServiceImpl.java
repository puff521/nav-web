package com.nav.web.service.jtm.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nav.web.entity.NavSite;
import com.nav.web.entity.NavType;
import com.nav.web.mapper.NavSiteMapper;
import com.nav.web.service.jtm.JtmSiteService;
import com.nav.web.service.jtm.JtmTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
//@CacheConfig(cacheNames = {"site"})
public class JtmSiteServiceImpl extends ServiceImpl<NavSiteMapper, NavSite> implements JtmSiteService {


    @Autowired
    private JtmTypeService jtmTypeService;

    @Override
    @DS("jtm")
    public Map<String, List<NavSite>> getSiteList() {
        List<NavType> navTypes = jtmTypeService.list();
        List<NavType> navTypeSorts = navTypes.stream()
                .sorted(Comparator.comparing(NavType::getSort))
                .collect(Collectors.toList());

        List<NavSite> navSiteList = this.list();
        navSiteList.sort(Comparator.comparing(NavSite::getSort));

        // 按照游戏分类分组
        Map<Long, List<NavSite>> gameCategoryMap =
                navSiteList.stream().collect(Collectors.groupingBy(NavSite::getNavTypeId));

        Map<String, List<NavSite>> stringListMap = new LinkedHashMap<>();

        navTypeSorts.forEach(typeItem -> {
            gameCategoryMap.forEach((kev, value) -> {
                if (kev.equals(typeItem.getNavTypeId())) {
                    stringListMap.put(typeItem.getNavCode(), value);
                }
            });
        });

        return stringListMap;
    }
}
