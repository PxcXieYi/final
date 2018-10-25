package com.baizhi.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/10/23.
 */
public class Menu {
    private int id;
    private String title;
    private int parentid;
    private String iconCls;
    private String url;
    private List<Menu> menuList;

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public Menu() {
    }

    public Menu(int id, String title, int parentid, String iconCls, String url, List<Menu> menuList) {
        this.id = id;
        this.title = title;
        this.parentid = parentid;
        this.iconCls = iconCls;
        this.url = url;
        this.menuList = menuList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", parentid=" + parentid +
                ", iconCls='" + iconCls + '\'' +
                ", url='" + url + '\'' +
                ", menuList=" + menuList +
                '}';
    }
}
