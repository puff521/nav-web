package com.nav.web.service.fm;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nav.web.entity.NavType;

import java.util.List;

public interface FmTypeService extends IService<NavType> {

    List<NavType> getNvaTypeList();


}
