package com.baizhi.controller;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/23.
 */
@Controller
@RequestMapping("/main")
public class MenuController {
    @Autowired
    private MenuService menuService;
   /* @RequestMapping("/selectAll")
    public String selectAll(HttpSession session){
        List<Menu> menus = menuService.selectAll();
        System.out.println(menus);
        session.setAttribute("menus",menus);
        return "redirect:/main/main.jsp";

    }*/
    @RequestMapping("/selectAll")
    public @ResponseBody List<Menu> selectAll(){
        List<Menu> menus = menuService.selectAll();
        System.out.println(menus);
        return menus;

    }
}
