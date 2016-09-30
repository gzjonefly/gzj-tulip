package com.dbdemo.dao;

import com.dbdemo.model.TestDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guozijian
 * @date 2016/9/23 20:30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath*:*.xml"
})
public class UserDAOTest {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserBossDAO userBossDAO;
    @Autowired
    private TestDAO testDAO;

    @Test
    public void test() {
        System.out.println(userDAO.getName(899));
    }

    @Test
    public void testInBatch() {
        List<String> names = new ArrayList<String>();
        names.add("张1");
        names.add("张2");
        userDAO.insertBtach(names);
    }

    @Test
    public void testUpdateBatch() {
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        userDAO.updateBatch(ids);
    }

    @Test
    public void testInsertBatch() {
        List<TestDO> list = new ArrayList<TestDO>();
        for (int i = 0; i < 2; i++) {
            TestDO testDO = new TestDO();
            testDO.setName("王" + i);
            list.add(testDO);
        }

        testDAO.insertIgnoreNull(list);
    }

    @Test
    public void testUserBoss() {
        System.out.println(userBossDAO.getCompanyName(100));
    }
}
