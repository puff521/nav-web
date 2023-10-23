package com.nav.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nav.web.entity.NavDomain;
import com.nav.web.entity.NavType;

public interface NavDomainService extends IService<NavDomain> {
     String  getDomainUrl();
}
