package com.dbdemo.dao;

import com.gzj.tulip.jade.annotation.DAO;
import com.gzj.tulip.jade.annotation.SQL;
import com.gzj.tulip.jade.annotation.SQLParam;
import com.gzj.tulip.jade.plugin.sql.GenericDAO;

import java.util.List;

/**
 * @author guozijian
 * @date 2016/9/23 20:25
 */
@DAO(catalog = "dz_db")
public interface UserDAO{
    @SQL("create table user (id int, name varchar(200));")
    void createTable();

    @SQL("insert into user (id, name) values(:1, :2);")
    void insert(int id, String name);

    @SQL("select name from user where id=:1")
    String getName(int id);

    @SQL("select name from user order by id asc")
    String[] findNames();

    @SQL("INSERT INTO test (name) values " +
            "#for (brm in :names) { (:brm), }")
    public boolean insertBtach( @SQLParam("names") List<String> names);

    @SQL("UPDATE test set name='dsd' where id in (:1) ")
    public boolean updateBatch(List<Integer> ids);
}
