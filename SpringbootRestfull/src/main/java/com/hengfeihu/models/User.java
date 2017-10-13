package com.hengfeihu.models;

import io.ebean.Finder;
import io.ebean.Model;
import io.ebean.annotation.CreatedTimestamp;
import io.ebean.annotation.UpdatedTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 用户实体类
 * Created by hengfeihu on 2017/10/13.
 */
@Entity
@Table(name = "sy_user")
public class User extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100)
    private String username;

    @Column(length = 100)
    private String password;

    @CreatedTimestamp
    private Timestamp createTime;

    @UpdatedTimestamp
    private Timestamp updateTime;
}
