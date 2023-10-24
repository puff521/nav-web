package com.nav.web.service.jtm.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nav.web.entity.NavType;
import com.nav.web.mapper.NavTypeMapper;
import com.nav.web.service.jtm.JtmTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class JtmTypeServiceImpl extends ServiceImpl<NavTypeMapper, NavType> implements JtmTypeService {


    @DS("jtm")
    @Override
    public  List<NavType> getNvaTypeList() {
        LambdaQueryWrapper<NavType> queryWrapper = Wrappers.lambdaQuery(NavType.class)
                .eq(NavType::getStatus, 1);
        List<NavType> domainList =  this.list(queryWrapper);

        return  domainList;
    }

}
