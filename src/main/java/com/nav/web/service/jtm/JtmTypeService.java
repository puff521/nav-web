package com.nav.web.service.jtm;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nav.web.entity.NavType;

import java.util.List;

public interface JtmTypeService extends IService<NavType> {

    List<NavType> getNvaTypeList();


}
