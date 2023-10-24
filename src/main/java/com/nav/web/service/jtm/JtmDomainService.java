package com.nav.web.service.jtm;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nav.web.entity.NavDomain;

public interface JtmDomainService extends IService<NavDomain> {
     String  getDomainUrl();
}
