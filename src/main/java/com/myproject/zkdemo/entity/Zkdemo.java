package com.myproject.zkdemo.entity;

import javax.persistence.*;

/**
 * @Author wenhuigong
 * @Date 2019/7/27 13:34
 * @Description
 **/
@Entity
@Table(name = "zkdemo")
public class Zkdemo {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
