package com.nav.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nav.web.entity.NavDomain;
import com.nav.web.entity.NavSite;
import com.nav.web.entity.NavType;
import com.nav.web.mapper.NavSiteMapper;
import com.nav.web.mapper.NavTypeMapper;
import com.nav.web.service.NavSiteService;
import com.nav.web.service.NavTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class NavTypeServiceImpl extends ServiceImpl<NavTypeMapper, NavType> implements NavTypeService {


    @Override
    public  List<NavType> getNvaTypeList() {
        LambdaQueryWrapper<NavType> queryWrapper = Wrappers.lambdaQuery(NavType.class)
                .eq(NavType::getStatus, 1);
        List<NavType> domainList =  this.list(queryWrapper);

        return  domainList;
    }

}
