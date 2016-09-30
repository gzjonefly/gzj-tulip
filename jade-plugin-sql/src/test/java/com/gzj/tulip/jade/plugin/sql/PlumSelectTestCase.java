/**
 *
 */
package com.gzj.tulip.jade.plugin.sql;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.gzj.tulip.jade.plugin.sql.dao.UserInfoDAO;
import com.gzj.tulip.jade.plugin.sql.model.UserInfoConditions;
import com.gzj.tulip.jade.plugin.sql.model.UserInfoDO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alan.Geng[gengzhi718@gmail.com]
 */
public class PlumSelectTestCase extends AbstractTestCase {

    @Autowired
    private UserInfoDAO userInfoDAO;

    public void testGetById() {
        UserInfoDO userInfoDO = userInfoDAO.selectByPrimaryKey(2L);

        assert userInfoDO != null;
        System.out.println(JSON.toJSONString(userInfoDO, SerializerFeature.PrettyFormat));
    }

    public void testSelectByConditions() {
        UserInfoConditions conditions = new UserInfoConditions();
        conditions.setDistinct(true);
        conditions.setOrderByClause("CREATE_TIME ASC");
        //UserInfoConditions.Criteria criteria = conditions.createCriteria().andIdEqualTo(1).startOrBracket().andIdBetween(2, 3).endBracket();
        UserInfoConditions.Criteria criteria = conditions.createCriteria().andIdEqualTo(1).
                startAndBracket().
                orIdIsNull().orIdIsNotNull().
                endBracket();
        //conditions.or();

        List<UserInfoDO> userInfoDO = userInfoDAO.selectByConditions(conditions);

        assert userInfoDO != null;
        System.out.println(JSON.toJSONString(userInfoDO, SerializerFeature.PrettyFormat));
    }

    public void testCount() {
        UserInfoConditions conditions = new UserInfoConditions();
        conditions.createCriteria().andIdIsNotNull();
        System.out.println(userInfoDAO.countByConditions(conditions));
    }

    public void testFindByGroupId() {
        List<UserInfoDO> userInfos = userInfoDAO.findByGroupId(100L);

        System.out.println(JSON.toJSONString(userInfos, SerializerFeature.PrettyFormat));
    }

    public void testFindByNameLike() {
        List<UserInfoDO> userInfos = userInfoDAO.findByNameLike("耿%");

        System.out.println(JSON.toJSONString(userInfos, SerializerFeature.PrettyFormat));
    }

    public void testFindByIdBetween() {
        List<UserInfoDO> userInfos = userInfoDAO.findByIdBetween(0, 9);

        System.out.println(JSON.toJSONString(userInfos, SerializerFeature.PrettyFormat));
    }

    public void testGetOrderBy() {
        List<UserInfoDO> userInfos = userInfoDAO.findByNameLikeWithOrder(//
                "耿%", Plum.asc("id", "createTime").desc("lastUpdateTime"));

        System.out.println(JSON.toJSONString(userInfos, SerializerFeature.PrettyFormat));
    }

    public void testGetRange() {
        List<UserInfoDO> userInfos = userInfoDAO.findByNameWithLimit("耿%", 0, 2);

        System.out.println(JSON.toJSONString(userInfos, SerializerFeature.PrettyFormat));
    }

    public void testFindByGroupIds() {
        List<Integer> groupIds = new ArrayList<Integer>();
        groupIds.add(100);
        groupIds.add(101);

        List<UserInfoDO> userInfos = userInfoDAO.findByGroupIds(groupIds);

        System.out.println(JSON.toJSONString(userInfos, SerializerFeature.PrettyFormat));
    }

}
