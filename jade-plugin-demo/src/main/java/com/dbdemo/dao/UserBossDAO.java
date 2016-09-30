package com.dbdemo.dao;

import com.gzj.tulip.jade.annotation.DAO;
import com.gzj.tulip.jade.annotation.SQL;

/**
 * @author guozijian
 * @date 2016/9/26 20:27
 */
@DAO(catalog = "blue_user")
public interface UserBossDAO {
    @SQL("select company_name from user_boss where id=:1")
    String getCompanyName(int id);
}
