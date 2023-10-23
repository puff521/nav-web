package com.nav.web.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nav.web.entity.NavDomain;
import com.nav.web.entity.NavType;
import com.nav.web.mapper.NavDomainMapper;
import com.nav.web.mapper.NavTypeMapper;
import com.nav.web.service.NavDomainService;
import com.nav.web.service.NavTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class NavDomainServiceImpl extends ServiceImpl<NavDomainMapper, NavDomain> implements NavDomainService {


    @Override
    public String getDomainUrl() {
        LambdaQueryWrapper<NavDomain> queryWrapper = Wrappers.lambdaQuery(NavDomain.class)
                .eq(NavDomain::getStatus, 1)
                .eq(NavDomain::getDiscardStatus, 0);

        List<NavDomain> domainList = this.list(queryWrapper);
        if (CollectionUtils.isNotEmpty(domainList)) {
            return domainList.get(0).getAddress();
        }
        return "";
    }
}
