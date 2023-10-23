package com.nav.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nav.web.entity.NavSite;
import com.nav.web.entity.NavType;

import java.util.List;

public interface NavTypeService extends IService<NavType> {

    List<NavType> getNvaTypeList();


}
