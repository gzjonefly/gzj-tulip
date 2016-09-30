/**
 *
 */
package com.gzj.tulip.jade.plugin.sql;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.gzj.tulip.jade.plugin.sql.dao.UserInfoDAO;
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
public class PlumInsertTestCase extends AbstractTestCase {


    @Autowired
    private UserInfoDAO userInfoDAO;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testInsert() {
        UserInfoDO userInfo = createUserInfoDO(102, 30);

        Long id = userInfoDAO.insert(userInfo);


        System.out.println(JSON.toJSONString(userInfoDAO.selectByPrimaryKey(id), SerializerFeature.PrettyFormat));
    }

    public void testBatchInsert() {
        List<UserInfoDO> userInfos = new ArrayList<UserInfoDO>(5);
        for (int i = 0; i < 5; i++) {
            userInfos.add(createUserInfoDO(103, 40 + i));
        }
        userInfoDAO.insertIgnoreNull(userInfos);
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
