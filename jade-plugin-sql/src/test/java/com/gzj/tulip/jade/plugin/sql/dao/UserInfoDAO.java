/**
 *
 */
package com.gzj.tulip.jade.plugin.sql.dao;

import com.gzj.tulip.jade.plugin.sql.GenericDAO;
import com.gzj.tulip.jade.plugin.sql.annotations.*;
import com.gzj.tulip.jade.plugin.sql.model.UserInfoConditions;
import com.gzj.tulip.jade.plugin.sql.model.UserInfoDO;
import com.gzj.tulip.jade.annotation.DAO;
import com.gzj.tulip.jade.annotation.SQLParam;
import com.gzj.tulip.jade.plugin.sql.Order;

import java.util.List;

/**
 * @author Alan.Geng[gengzhi718@gmail.com]
 */
/*
 * 继承GenericDAO并使用泛型标注对应的实体类型，即拥有了基本的CRUD操作。
 * 你并不需要一个实现类，在Service层中直接使用：
 * @Autowired
 * private UserInfoDAO userInfoDAO;
 * spring框架将自动注入一个自动生成的实现。
 */
@DAO
public interface UserInfoDAO extends GenericDAO<UserInfoDO, Long, UserInfoConditions> {

    /**
     * 指定字段查询
     *
     * @param contractPlanId
     * @return
     */
    public List<UserInfoDO> findByGroupId(
            @SQLParam("groupId") Long groupId);

    /**
     * 字符串Like查询
     *
     * @param name
     * @return
     */
    public List<UserInfoDO> findByNameLike(
            @SQLParam("name") @Like String name);

    /**
     * 值区间查询
     *
     * @param min
     * @param max
     * @return
     */
    public List<UserInfoDO> findByIdBetween(
            @SQLParam("id") @Ge long min,
            @SQLParam("id") @Le long max);

    /**
     * 排序查询
     *
     * @param name
     * @param order
     * @return
     */
    public List<UserInfoDO> findByNameLikeWithOrder(
            @SQLParam("name") @Like String name,
            Order order);

    /**
     * Range查询
     *
     * @param name
     * @param range
     * @return
     */
    @IgnoreNull(false)
    public List<UserInfoDO> findByNameWithLimit(
            @SQLParam("name") @Like String name,
            @Offset int offset,
            @Limit int limit);

    /**
     * In查询
     *
     * @param groupIds
     * @return
     */
    public List<UserInfoDO> findByGroupIds(
            @SQLParam("groupId") @In List<Integer> groupIds);

    /**
     * 通过指定字段条件更新
     *
     * @param name
     * @param group
     */
    public void updateByGroup(
            @SQLParam("name") @IgnoreNull(false) String name,
            @SQLParam("age") Integer age,
            @Where
            @SQLParam("groupId") Integer group);

    public void updateByGroupConditions(
            @SQLParam("name") @IgnoreNull(false) String name,
            @Where
            @SQLParam("conditions") UserInfoConditions conditions);

    /**
     * 通过指定字段条件更新
     *
     * @param name
     * @param group
     */
    public void updateByGroupIds(
            @SQLParam("name") String name,
            @SQLParam("age") int age,
            @Where
            @SQLParam("groupId") @In List<Integer> group);

    /**
     * 通过指定字段删除
     *
     * @param groupId
     */
    public void deleteByGroupId(
            @SQLParam("groupId") Integer groupId);
}
