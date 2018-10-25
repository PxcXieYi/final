package com.baizhi.entity;

/**
 * Created by Administrator on 2018/10/25.
 */
//章节表
public class Chapter {
    private int id;  //章节音频的id
    private int ablumId;//对应的专辑的id
    private String title; //章节音频的名字
    private String url;  //章节音频的路径
    private String size; //章节音频的大小
    private String duration;//章节音频的时长

    public Chapter() {
    }

    public Chapter(int id, int ablumId, String title, String url, String size, String duration) {
        this.id = id;
        this.ablumId = ablumId;
        this.title = title;
        this.url = url;
        this.size = size;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAblumId() {
        return ablumId;
    }

    public void setAblumId(int ablumId) {
        this.ablumId = ablumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", ablumId=" + ablumId +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", size='" + size + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
