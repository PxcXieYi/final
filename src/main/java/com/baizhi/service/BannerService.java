package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.List;

/**
 * Created by Administrator on 2018/10/24.
 */
public interface BannerService {
    //轮播图展示
    public List<Banner> selectAllBanner();

    boolean addBanner(Banner banner);

    boolean delete(int id);

    boolean updateBanner(Banner banner);
}
