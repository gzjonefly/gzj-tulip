package com.dbdemo.model;

import com.gzj.tulip.jade.plugin.sql.annotations.Column;
import com.gzj.tulip.jade.plugin.sql.annotations.Table;

import java.io.Serializable;

/**
 * @author guozijian
 * @date 2016/9/29 17:48
 */
@Table(pk = "id")
public class TestDO implements Serializable {
    private static final long serialVersionUID = 5972214592211414413L;

    @Column(pk = true)
    private Long id;

    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
