package com.jsjx.dorm.app.service;

import com.jsjx.dorm.app.dao.DormUserDao;
import com.jsjx.dorm.app.domain.DormUser;
import com.jsjx.dorm.baseutils.BaseService;

import java.util.List;

public interface DormUserService extends BaseService<DormUserDao, DormUser> {

   List<DormUser> findBySelective(DormUser param);

}
