package com.baizhi.service;

import com.baizhi.entity.Admin;

import java.util.List;

/**
 * Created by Administrator on 2018/10/23.
 */
public interface AdminService {
    public List<Admin> queryAll();
    /*登录*/
    public Admin query(Admin admin);
}
