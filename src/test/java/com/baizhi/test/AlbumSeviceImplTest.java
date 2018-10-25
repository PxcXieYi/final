package com.baizhi.test;

import com.baizhi.CmfzApp;
import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.service.AlbumSevice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/10/25.
 */
/**
 * 开启springboot自动配置
 */
@SpringBootTest(classes = CmfzApp.class)
/**
 * 开启spring工厂，创建对象
 */
@RunWith(SpringRunner.class)
public class AlbumSeviceImplTest {
    @Autowired
    private AlbumSevice albumSevice;
    @Test
    public void test1(){
        List<Album> chapterList = albumSevice.selectAllAlbum();
        System.out.println(chapterList);
    }
    @Test
    public void test2(){
        Album ablum = new Album();
        ablum.setTitle("时间简史");
        ablum.setCoverImg("1");
        ablum.setCount(2);
        ablum.setScore(90);
        ablum.setAuthor("霍金");
        ablum.setBrief("真厉害");
        ablum.setBroadCast("王猛师兄");



        boolean data = albumSevice.insertAlbum(ablum);
        System.out.println(data);
    }
    @Test
    public void test3(){

        int id = albumSevice.selectOneAlbum("时间简史");
        System.out.println(id);
    }


}