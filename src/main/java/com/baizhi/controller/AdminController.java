package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/10/23.
 */
@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("/query")
    public String query(Admin admin, HttpSession session,String str){
        Admin admin2 = adminService.query(admin);
        if(admin2!=null){
            System.out.println(admin2);
            session.setAttribute("admin",admin2);
            String code = (String)session.getAttribute("vrifyCode");
            if(code.equals(str)){

                return "redirect:/main/main.jsp";
            }
        }
        return "redirect:/login.jsp";
    }
}
