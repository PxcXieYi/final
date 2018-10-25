package com.baizhi.test;

import com.baizhi.CmfzApp;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/10/23.
 */

/**
 * 开启springboot自动配置
 */
@SpringBootTest(classes = CmfzApp.class)
/**
 * 开启spring工厂，创建对象
 */
@RunWith(SpringRunner.class)
public class AdminServiceImplTest {
    @Autowired
    private AdminService adminService;
    @Test
    public void test1(){
        Admin admin = new Admin();
        admin.setName("张三");
        admin.setPassword("123456");
        Admin query = adminService.query(admin);
        System.out.println(query);
    }
    @Test
    public void test2(){
        List<Admin> admins = adminService.queryAll();
        System.out.println(admins);
    }
}