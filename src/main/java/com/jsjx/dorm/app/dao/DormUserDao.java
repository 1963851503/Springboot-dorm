package com.jsjx.dorm.app.dao;


import com.jsjx.dorm.app.domain.DormUser;
import com.jsjx.dorm.baseutils.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DormUserDao extends BaseDao<DormUser>  {

   List<DormUser> findBySelective(DormUser param);

}
