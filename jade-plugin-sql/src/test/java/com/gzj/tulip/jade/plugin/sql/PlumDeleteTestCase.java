/**
 *
 */
package com.gzj.tulip.jade.plugin.sql;

import com.gzj.tulip.jade.plugin.sql.dao.UserInfoDAO;
import com.gzj.tulip.jade.plugin.sql.model.UserInfoConditions;

import javax.annotation.Resource;

/**
 * @author Alan
 */
public class PlumDeleteTestCase extends AbstractTestCase {

    @Resource
    private UserInfoDAO userInfoDAO;

    public void testDelete() {
        userInfoDAO.deleteByPrimaryKey(0l);
    }

    public void testDeleteByConditions() {
        UserInfoConditions conditions = new UserInfoConditions();
        conditions.createCriteria().andIdEqualTo(1);
        userInfoDAO.deleteByConditions(conditions);
    }

    public void testDeleteByGroupId() {
        userInfoDAO.deleteByGroupId(100);
        printJson(userInfoDAO.findByNameLike("耿直%"));
    }
}
