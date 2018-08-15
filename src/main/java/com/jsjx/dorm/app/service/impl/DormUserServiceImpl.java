
package com.jsjx.dorm.app.service.impl;

import com.jsjx.dorm.app.dao.DormUserDao;
import com.jsjx.dorm.app.domain.DormUser;
import com.jsjx.dorm.app.service.DormUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jsjx.dorm.baseutils.impl.BaseServiceImpl;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DormUserServiceImpl extends BaseServiceImpl<DormUserDao, DormUser> implements DormUserService {

    @Autowired
    private DormUserDao dao;

    @Override
    @Transactional(readOnly = true)
    public List<DormUser> findBySelective(DormUser param) {
        return dao.findBySelective(param);
    }

}

