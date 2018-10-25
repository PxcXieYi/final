package com.baizhi.service.impl;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/10/24.
 */
@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;
    @Override
    public List<Banner> selectAllBanner() {
        return bannerDao.selectAllBanner();
    }

    @Override
    public boolean addBanner(Banner banner) {

        return bannerDao.addBanner(banner);
    }

    @Override
    public boolean delete(int id) {
       boolean data= bannerDao.delete(id);
        return data;
    }

    @Override
    public boolean updateBanner(Banner banner) {
        boolean data= bannerDao.updateBanner(banner);
        return data;
    }
}
