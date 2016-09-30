package com.dbdemo.dao;

import com.dbdemo.model.TestDO;
import com.gzj.tulip.jade.annotation.DAO;
import com.gzj.tulip.jade.plugin.sql.GenericDAO;

/**
 * @author guozijian
 * @date 2016/9/29 17:48
 */
@DAO(catalog = "dz_db")
public interface TestDAO extends GenericDAO<TestDO, Long, Integer> {
}
