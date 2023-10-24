package com.nav.web.service.fm;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nav.web.entity.NavDomain;

public interface FmDomainService extends IService<NavDomain> {
     String  getDomainUrl();
}
