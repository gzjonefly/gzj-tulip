/**
 *
 */
package com.gzj.tulip.jade.plugin.sql;

import com.gzj.tulip.jade.annotation.ReturnGeneratedKeys;
import com.gzj.tulip.jade.annotation.SQL;
import com.gzj.tulip.jade.annotation.SQLParam;
import com.gzj.tulip.jade.plugin.sql.annotations.IgnoreNull;
import com.gzj.tulip.jade.plugin.sql.annotations.Where;

import java.util.List;

/**
 * @author Alan.Geng[gengzhi718@gmail.com]
 */
public interface GenericDAO<E, ID, CONDITIONS> {

    /**
     * count(*)
     *
     * @param conditions
     * @return
     */
    @SQL("SELECT count(*) from {table_name}")
    long countByConditions(@Where @SQLParam("conditions") CONDITIONS conditions);

    /**
     * 通过主键查询
     *
     * @param id
     * @return
     */
    E selectByPrimaryKey(@SQLParam("id") ID id);

    /**
     * 通过条件查询
     *
     * @param conditions
     * @return
     */
    List<E> selectByConditions(@Where @SQLParam("conditions") CONDITIONS conditions);

    /**
     * 插入数据（会插入空值）
     *
     * @param entity
     * @return
     */
    @ReturnGeneratedKeys
    ID insert(@SQLParam("entity") E entity);

    /**
     * 插入数据（忽略空值）
     *
     * @param entity
     * @return
     */
    @ReturnGeneratedKeys
    @IgnoreNull
    ID insertIgnoreNull(@SQLParam("entity") E entity);

//    /**
//     * 批量插入数据
//     * 会转换成多条insert语句（慎用）
//     *
//     * @param entity
//     * @return 是否更新成功（实现原理：true=如果本次执行影响的行数大于0）
//     */
//    boolean insert(@SQLParam("entity") List<E> entity);
//
//    /**
//     * 批量插入数据（忽略空值）
//     * 不用保证列表所有数据的非空字段是一致的
//     * 会转换成多条insert语句（慎用）
//     *
//     * @param entity
//     * @return 是否更新成功（实现原理：true=如果本次执行影响的行数大于0）
//     */
//    @IgnoreNull
//    boolean insertIgnoreNull(@SQLParam("entity") List<E> entity);

    /**
     * 批量插入数据（会插入空值）
     *
     * @param entities
     * @return 是否更新成功（实现原理：true=如果本次执行影响的行数大于0）
     */
    @SQL("insert into {table_name} ({table_columns}) values {table_values}")
    boolean insert(@SQLParam("entities") List<E> entities);

    /**
     * 批量插入数据（忽略空值）
     * 需要保证列表所有数据的非空字段是一致的
     *
     * @param entities
     * @return 是否更新成功（实现原理：true=如果本次执行影响的行数大于0）
     */
    @IgnoreNull
    @SQL("insert into {table_name} ({table_columns}) values {table_values}")
    boolean insertIgnoreNull(@SQLParam("entities") List<E> entities);

    /**
     * 通过主键更新数据
     *
     * @param entity
     */
    int updateByPrimaryKey(@SQLParam("entity") E entity);

    /**
     * 通过主键更新数据(忽略空)
     *
     * @param entity
     */
    @IgnoreNull
    int updateByPrimaryKeyIgnoreNull(@SQLParam("entity") E entity);

    /**
     * 通过条件更新数据
     *
     * @param entity
     * @param conditions
     * @return
     */
    int updateByConditions(@SQLParam("entity") E entity,
                           @Where
                           @SQLParam("conditions") CONDITIONS conditions);

    /**
     * 通过条件更新数据（忽略空）
     *
     * @param entity
     * @param conditions
     * @return
     */
    @IgnoreNull
    int updateByConditionsIgnoreNull(@SQLParam("entity") E entity,
                                     @Where
                                     @SQLParam("conditions") CONDITIONS conditions);

    /**
     * 通过主键删除数据
     *
     * @param id
     */
    @SQL("delete from {table_name} where {primary_key} = :1")
    boolean deleteByPrimaryKey(@SQLParam("id") ID id);

    /**
     * 通过条件删除数据
     *
     * @param conditions
     * @return
     */
    int deleteByConditions(@Where @SQLParam("conditions") CONDITIONS conditions);
}
