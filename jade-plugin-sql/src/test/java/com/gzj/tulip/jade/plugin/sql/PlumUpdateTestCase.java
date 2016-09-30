/**
 *
 */
package com.gzj.tulip.jade.plugin.sql;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.gzj.tulip.jade.plugin.sql.dao.UserInfoDAO;
import com.gzj.tulip.jade.plugin.sql.model.UserInfoConditions;
import com.gzj.tulip.jade.plugin.sql.model.UserInfoDO;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Alan.Geng[gengzhi718@gmail.com]
 */
public class PlumUpdateTestCase extends AbstractTestCase {

    @Autowired
    private UserInfoDAO purchaseContractDAO;

    public void testUpdate() {

        UserInfoDO contract = createUserInfoDO(101, 15);
        contract.setId(1L);
        contract.setName("guozijian");

        System.out.println(purchaseContractDAO.updateByPrimaryKey(contract));

        UserInfoDO user = purchaseContractDAO.selectByPrimaryKey(1L);
        System.out.println(JSON.toJSONString(user, SerializerFeature.PrettyFormat));
    }

    public void testUpdateIgnoreNull() {

        UserInfoDO contract = new UserInfoDO();
        contract.setId(1L);
        contract.setName("guozijian");

        System.out.println(purchaseContractDAO.updateByPrimaryKeyIgnoreNull(contract));

        UserInfoDO user = purchaseContractDAO.selectByPrimaryKey(1L);
        System.out.println(JSON.toJSONString(user, SerializerFeature.PrettyFormat));
    }

    public void testSpecialUpdate() {
        //purchaseContractDAO.updateByGroup(null, 25, 100);
        UserInfoConditions conditions = new UserInfoConditions();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(10);
        //conditions.createCriteria().andIdEqualTo(1);
        conditions.setDistinct(true);
        conditions.setOrderByClause("id desc");
        conditions.createCriteria().andIdLessThanOrEqualTo(2).andIdEqualTo(1).andIdLessThan(2).andIdBetween(3,4).andIdGreaterThan(5).andIdGreaterThanOrEqualTo(5)
                .andIdIsNotNull().andIdIsNull().andIdNotBetween(6,7).andIdIn(ids).andIdNotIn(ids);
        //purchaseContractDAO.updateByGroupConditions(null, 25, 100);
        purchaseContractDAO.updateByGroupConditions("12",conditions);

        List<UserInfoDO> updated = purchaseContractDAO.findByGroupId(100L);
        System.out.println(JSON.toJSONString(updated, SerializerFeature.PrettyFormat));
    }

    public void testSpecialUpdate1() {
        //purchaseContractDAO.updateByGroup(null, 25, 100);
        UserInfoConditions conditions = new UserInfoConditions();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(10);
        //conditions.createCriteria().andIdEqualTo(1);
        conditions.createCriteria().andIdLessThanOrEqualTo(2).andIdEqualTo(1).andIdLessThan(2).andIdBetween(3,4).andIdGreaterThan(5).andIdGreaterThanOrEqualTo(5)
                .andIdIsNotNull().andIdIsNull().andIdNotBetween(6,7).andIdIn(ids).andIdNotIn(ids);
        //purchaseContractDAO.updateByGroupConditions(null, 25, 100);
        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setName("eqeq");
        purchaseContractDAO.updateByConditionsIgnoreNull(userInfoDO,conditions);

        List<UserInfoDO> updated = purchaseContractDAO.findByGroupId(100L);
        System.out.println(JSON.toJSONString(updated, SerializerFeature.PrettyFormat));
    }

    public void testSpecialInUpdate() {
        List<Integer> groupIds = new ArrayList<Integer>();
        groupIds.add(100);
        groupIds.add(101);

        purchaseContractDAO.updateByGroupIds("Alan.Geng", 29, groupIds);

        List<UserInfoDO> updated = purchaseContractDAO.findByGroupIds(groupIds);
        System.out.println(JSON.toJSONString(updated, SerializerFeature.PrettyFormat));
    }

    private static UserInfoDO createUserInfoDO(long group, int age) {
        UserInfoDO userInfo = new UserInfoDO();

        userInfo.setName("耿直PlumInsertTestCase");
        userInfo.setMoney(new BigDecimal("123456"));
        userInfo.setEditable(true);
        userInfo.setGroupId(group);
        userInfo.setAge(age);
        userInfo.setBirthday(DateUtils.addYears(new Date(), -userInfo.getAge()));
        userInfo.setStatus(2);
        userInfo.setCreateTime(new Date());
        userInfo.setEditable(true);
        userInfo.setLastUpdateTime(new Date());

        return userInfo;
    }
}
