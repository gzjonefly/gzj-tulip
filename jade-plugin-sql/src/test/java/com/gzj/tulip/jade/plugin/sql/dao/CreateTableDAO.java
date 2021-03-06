/**
 * 
 */
package com.gzj.tulip.jade.plugin.sql.dao;

import com.gzj.tulip.jade.annotation.DAO;
import com.gzj.tulip.jade.annotation.SQL;

@DAO
public interface CreateTableDAO {

    String create_user_info_table = "create table user_info "
                                    + "(id bigint IDENTITY not null primary key"
                                    + ",name varchar(200) null "
                                    + ",group_id bigint not null"
                                    + ",birthday datetime not null" + ",age int not null"
                                    + ",money decimal(20,2) not null"
                                    + ",create_time datetime not null"
                                    + ",last_update_time timestamp not null"
                                    + ",status int not null"
                                    + ",editable int not null" + ");";

    @SQL(create_user_info_table)
    public void createUserInfoTable();
}
