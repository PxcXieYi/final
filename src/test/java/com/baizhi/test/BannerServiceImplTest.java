package com.baizhi.test;

import com.baizhi.CmfzApp;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/10/24.
 */
/**
 * 开启springboot自动配置
 */
@SpringBootTest(classes = CmfzApp.class)
/**
 * 开启spring工厂，创建对象
 */
@RunWith(SpringRunner.class)
public class BannerServiceImplTest {
    @Autowired
    private BannerService bannerService;
    @Test
    public void test1(){
        List<Banner> banners = bannerService.selectAllBanner();
        System.out.println(banners);
    }
   /* @Test
    public void test2(){
        Banner banner = new Banner(0,"王五","1",0,"真好");
        bannerService.addBanner(banner);

    }*/
    @Test
    public void test3(){

        bannerService.delete(9);

    }
   /* @Test
    public void test4(){
        Banner banner = new Banner(14,"王五","1",0,"2018-10-12","测试");
        bannerService.updateBanner(banner);

    }*/


}