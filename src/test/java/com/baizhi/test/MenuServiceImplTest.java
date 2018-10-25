package com.baizhi.test;

import com.baizhi.CmfzApp;
import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
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
public class MenuServiceImplTest {
    @Autowired
    private MenuService menuService;
    @Test
    public void test1(){
        List<Menu> menuList = menuService.selectAll();
        for (Menu menu : menuList) {
            System.out.println("一级标题id："+menu.getId()+"  一级标题名字："+menu.getTitle()+"一级标题图标 :"+menu.getIconCls());
            List<Menu> menuList1 = menu.getMenuList();
            for (Menu menu1 : menuList1) {
                System.out.println("二级标题id :"+menu1.getId()
                        + " 二级标题名字："+menu1.getTitle()
                        +"二级标题图标 :"+menu1.getIconCls()
                        +"二级标题路径 :"+menu1.getUrl()
                        +"二级标题父id :"+menu1.getParentid());
            }
        }


    }

}