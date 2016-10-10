package com.dbdemo.dao;

import com.gzj.dao.mapper.SpiderCorpSmsSendDAO;
import com.gzj.dao.model.SpiderCorpSmsSendDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author guozijian
 * @date 2016/10/9 17:15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath*:*.xml"
})
public class SpiderCorpSmsSendDAOTest {

    @Autowired
    private SpiderCorpSmsSendDAO spiderCorpSmsSendDAO;

    @Test
    public void test() {
        SpiderCorpSmsSendDO spiderCorpSmsSendDO = spiderCorpSmsSendDAO.selectByPrimaryKey(5750);
        if (spiderCorpSmsSendDO != null) {
            System.out.println(spiderCorpSmsSendDO.getPhone());
        }
    }
}
