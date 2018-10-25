package com.baizhi.dao;

import com.baizhi.entity.Admin;

import java.util.List;

/**
 * Created by Administrator on 2018/10/23.
 */
public interface AdminDao {
    public List<Admin> queryAll();
    /*登录*/
    public Admin query(Admin admin);
}
