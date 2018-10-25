package com.baizhi.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/10/25.
 */
//专辑表
public class Album {
    private int id;
    private String title; //专辑名字
    private String coverImg;//封面图片
    private int count;//专辑的数量
    private int score;//专辑的评分
    private String author;//专辑的作者
    private String broadCast;//音频的播音人
    private String brief;//专辑的简介
    private Date publishDate;//专辑的发布时间
    private List<Chapter> children;//章节表
    public Album() {
    }

    public Album(int id, String title, String coverImg, int count, int score, String author, String broadCast, String brief, Date publishDate, List<Chapter> children) {
        this.id = id;
        this.title = title;
        this.coverImg = coverImg;
        this.count = count;
        this.score = score;
        this.author = author;
        this.broadCast = broadCast;
        this.brief = brief;
        this.publishDate = publishDate;
        this.children = children;
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

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadCast() {
        return broadCast;
    }

    public void setBroadCast(String broadCast) {
        this.broadCast = broadCast;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", coverImg='" + coverImg + '\'' +
                ", count=" + count +
                ", score=" + score +
                ", author='" + author + '\'' +
                ", broadCast='" + broadCast + '\'' +
                ", brief='" + brief + '\'' +
                ", publishDate=" + publishDate +
                ", children=" + children +
                '}';
    }
}
